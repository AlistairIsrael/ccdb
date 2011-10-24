#!/usr/bin/env ruby

INPUT_FILENAME = ARGV[0] || 'iso3166.colonized'

COUNTRIES = []

File.open(INPUT_FILENAME) { |file|
  file.each { |line|
    COUNTRIES << line.split('|').map {|s| s.strip }
  }
}

# Extract the header
HEADER = COUNTRIES.shift

SORTED_BY_ALPHA2 = COUNTRIES.sort { |a, b| a[1] <=> b[1] }

File.open("countries.properties-raw", "w", :encoding => 'ISO-8859-1') { |out|
  SORTED_BY_ALPHA2.each { |country|
    out.puts "#{country[1]}.name=#{country[0]}"
  }
}

# TODO Figure out a way to do the escaping ourselves

NATIVE2ASCII=`which native2ascii`
if NATIVE2ASCII
  `native2ascii -encoding iso-8859-1 countries.properties-raw countries.properties`
else
  puts "native2ascii not found! Convert countries.properties by hand."
end

File.open("Country.java", "w") { |out|
  out.puts <<END
/**
 * ccdb: Country Code Database
 *
 * Copyright (c) 2011 by Alistair A. Israel.
 * This software is made available under the terms of the MIT License.
 *
 * Created Oct 19, 2011
 */
package ccdb;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1">http://en.wikipedia.org/wiki/ISO_3166-1</a>
 * @author Alistair A. Israel
 */
public enum Country {

END

  out.write SORTED_BY_ALPHA2.map { |country|
    "    #{country[1]}(\"#{country[2]}\", #{country[3]})"
  }.join(",\n")
  out.puts ';'

  out.puts <<END

    private final String alpha3;

    private final int numericCode;

    private Country(final String alpha3, final int numericCode) {
        this.alpha3 = alpha3;
        this.numericCode = numericCode;
    }

    /**
     * @return the alpha3
     */
    public final String getAlpha3() {
        return alpha3;
    }

    /**
     * @return the numericCode
     */
    public final int getNumericCode() {
        return numericCode;
    }

    /**
     * @return the country name in the default {@link Locale}
     */
    public final String getDisplayName() {
        return getDisplayName(Locale.getDefault());
    }

    /**
     * @param locale
     *        the {@link Locale}
     * @return the locale-specific country name
     */
    public final String getDisplayName(final Locale locale) {
        final ResourceBundle messages = ResourceBundle.getBundle("ccdb.countries", locale);
        if (messages != null) {
            return messages.getString(name() + ".name");
        }
        return name();
    }

    /**
     * @return an array of available two-letter country codes
     */
    public static String[] getAvailableCodes() {
        final int n = values().length;
        final String[] results = new String[n];
        for (int i = 0; i < n; ++i) {
            results[i] = values()[i].name();
        }
        return results;
    }

    /**
     * @see <a
     *      href="http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom">http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom</a>
     */
    private static final class A2_LOOKUP_HOLDER {
        private static final Map<String, Country> MAP;
        static {
            MAP = new HashMap<String, Country>(values().length);
            for (final Country country : values()) {
                MAP.put(country.name(), country);
            }
        }
    }

    /**
     * Just an alias for {@link Country#valueOf(String)}, for consistency.
     *
     * @param alpha2
     *        the two-letter country code
     * @return the corresponding Country, if it exists
     */
    public static Country lookupByAlpha2(final String alpha2) {
        return A2_LOOKUP_HOLDER.MAP.get(alpha2);
    }

    /**
     * @see <a
     *      href="http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom">http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom</a>
     */
    private static final class A3_LOOKUP_HOLDER {
        private static final Map<String, Country> MAP;
        static {
            MAP = new HashMap<String, Country>(values().length);
            for (final Country country : values()) {
                MAP.put(country.alpha3, country);
            }
        }
    }

    /**
     * Lookup a {@link Country} by three-letter country code
     *
     * @param alpha3
     *        the three-letter country code
     * @return the corresponding Country, if it exists
     */
    public static Country lookupByAlpha3(final String alpha3) {
        return A3_LOOKUP_HOLDER.MAP.get(alpha3);
    }

    /**
     * @see <a
     *      href="http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom">http://en.wikipedia.org/wiki/Initialization_on_demand_holder_idiom</a>
     */
    private static final class NUM_LOOKUP_HOLDER {
        private static final Map<Integer, Country> MAP;
        static {
            MAP = new HashMap<Integer, Country>(values().length);
            for (final Country country : values()) {
                MAP.put(Integer.valueOf(country.numericCode), country);
            }
        }
    }

    /**
     * @param numericCode
     *        the numeric country code
     * @return the corresponding country, if it exists
     */
    public static Country lookupByNumericCode(final int numericCode) {
        return NUM_LOOKUP_HOLDER.MAP.get(Integer.valueOf(numericCode));
    }
}
END
}

puts 'Copy Country.java to src/main/java/ccdb'
puts 'Copy countries.propertise to src/main/resources/ccdb'

#KTHXBAI
