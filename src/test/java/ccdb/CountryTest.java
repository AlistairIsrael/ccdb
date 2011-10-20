/**
 * ccdb: Country Code Database
 *
 * Copyright (c) 2011 by Alistair A. Israel.
 * This software is made available under the terms of the MIT License.
 *
 * Created Oct 19, 2011
 */
package ccdb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Locale;

import org.junit.Test;

/**
 * JUnit test for {@link Country}.
 *
 * @author Alistair A. Israel
 */
public final class CountryTest {

    /**
     * Test for {@link Country#lookupByAlpha2(String)}
     */
    @Test
    public void testLookupByAlpha2() {
        assertSame(Country.PH, Country.lookupByAlpha2("PH"));
    }

    /**
     * Test for {@link Country#lookupByAlpha3(String)}
     */
    @Test
    public void testLookupByAlpha3() {
        assertSame(Country.PH, Country.lookupByAlpha3("PHL"));
    }

    /**
     * Test for {@link Country#lookupByNumericCode(int)}
     */
    @Test
    public void testLookupByNumericCode() {
        assertSame(Country.PH, Country.lookupByNumericCode(Country.PH.getNumericCode()));
    }

    /**
     * Test for {@link Country#getName(Locale)}
     */
    @Test
    public void testGetNameLocale() {
        final Locale def = Locale.getDefault();
        try {
            Locale.setDefault(Locale.ENGLISH);
            assertEquals("Åland Islands", Country.AX.getDisplayName());
        } finally {
            Locale.setDefault(def);
        }
    }
}
