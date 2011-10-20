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

    AD("AND", 20),
    AE("ARE", 784),
    AF("AFG", 4),
    AG("ATG", 28),
    AI("AIA", 660),
    AL("ALB", 8),
    AM("ARM", 51),
    AO("AGO", 24),
    AQ("ATA", 10),
    AR("ARG", 32),
    AS("ASM", 16),
    AT("AUT", 40),
    AU("AUS", 36),
    AW("ABW", 533),
    AX("ALA", 248),
    AZ("AZE", 31),
    BA("BIH", 70),
    BB("BRB", 52),
    BD("BGD", 50),
    BE("BEL", 56),
    BF("BFA", 854),
    BG("BGR", 100),
    BH("BHR", 48),
    BI("BDI", 108),
    BJ("BEN", 204),
    BL("BLM", 652),
    BM("BMU", 60),
    BN("BRN", 96),
    BO("BOL", 68),
    BQ("BES", 535),
    BR("BRA", 76),
    BS("BHS", 44),
    BT("BTN", 64),
    BV("BVT", 74),
    BW("BWA", 72),
    BY("BLR", 112),
    BZ("BLZ", 84),
    CA("CAN", 124),
    CC("CCK", 166),
    CD("COD", 180),
    CF("CAF", 140),
    CG("COG", 178),
    CH("CHE", 756),
    CI("CIV", 384),
    CK("COK", 184),
    CL("CHL", 152),
    CM("CMR", 120),
    CN("CHN", 156),
    CO("COL", 170),
    CR("CRI", 188),
    CU("CUB", 192),
    CV("CPV", 132),
    CW("CUW", 531),
    CX("CXR", 162),
    CY("CYP", 196),
    CZ("CZE", 203),
    DE("DEU", 276),
    DJ("DJI", 262),
    DK("DNK", 208),
    DM("DMA", 212),
    DO("DOM", 214),
    DZ("DZA", 12),
    EC("ECU", 218),
    EE("EST", 233),
    EG("EGY", 818),
    EH("ESH", 732),
    ER("ERI", 232),
    ES("ESP", 724),
    ET("ETH", 231),
    FI("FIN", 246),
    FJ("FJI", 242),
    FK("FLK", 238),
    FM("FSM", 583),
    FO("FRO", 234),
    FR("FRA", 250),
    GA("GAB", 266),
    GB("GBR", 826),
    GD("GRD", 308),
    GE("GEO", 268),
    GF("GUF", 254),
    GG("GGY", 831),
    GH("GHA", 288),
    GI("GIB", 292),
    GL("GRL", 304),
    GM("GMB", 270),
    GN("GIN", 324),
    GP("GLP", 312),
    GQ("GNQ", 226),
    GR("GRC", 300),
    GS("SGS", 239),
    GT("GTM", 320),
    GU("GUM", 316),
    GW("GNB", 624),
    GY("GUY", 328),
    HK("HKG", 344),
    HM("HMD", 334),
    HN("HND", 340),
    HR("HRV", 191),
    HT("HTI", 332),
    HU("HUN", 348),
    ID("IDN", 360),
    IE("IRL", 372),
    IL("ISR", 376),
    IM("IMN", 833),
    IN("IND", 356),
    IO("IOT", 86),
    IQ("IRQ", 368),
    IR("IRN", 364),
    IS("ISL", 352),
    IT("ITA", 380),
    JE("JEY", 832),
    JM("JAM", 388),
    JO("JOR", 400),
    JP("JPN", 392),
    KE("KEN", 404),
    KG("KGZ", 417),
    KH("KHM", 116),
    KI("KIR", 296),
    KM("COM", 174),
    KN("KNA", 659),
    KP("PRK", 408),
    KR("KOR", 410),
    KW("KWT", 414),
    KY("CYM", 136),
    KZ("KAZ", 398),
    LA("LAO", 418),
    LB("LBN", 422),
    LC("LCA", 662),
    LI("LIE", 438),
    LK("LKA", 144),
    LR("LBR", 430),
    LS("LSO", 426),
    LT("LTU", 440),
    LU("LUX", 442),
    LV("LVA", 428),
    LY("LBY", 434),
    MA("MAR", 504),
    MC("MCO", 492),
    MD("MDA", 498),
    ME("MNE", 499),
    MF("MAF", 663),
    MG("MDG", 450),
    MH("MHL", 584),
    MK("MKD", 807),
    ML("MLI", 466),
    MM("MMR", 104),
    MN("MNG", 496),
    MO("MAC", 446),
    MP("MNP", 580),
    MQ("MTQ", 474),
    MR("MRT", 478),
    MS("MSR", 500),
    MT("MLT", 470),
    MU("MUS", 480),
    MV("MDV", 462),
    MW("MWI", 454),
    MX("MEX", 484),
    MY("MYS", 458),
    MZ("MOZ", 508),
    NA("NAM", 516),
    NC("NCL", 540),
    NE("NER", 562),
    NF("NFK", 574),
    NG("NGA", 566),
    NI("NIC", 558),
    NL("NLD", 528),
    NO("NOR", 578),
    NP("NPL", 524),
    NR("NRU", 520),
    NU("NIU", 570),
    NZ("NZL", 554),
    OM("OMN", 512),
    PA("PAN", 591),
    PE("PER", 604),
    PF("PYF", 258),
    PG("PNG", 598),
    PH("PHL", 608),
    PK("PAK", 586),
    PL("POL", 616),
    PM("SPM", 666),
    PN("PCN", 612),
    PR("PRI", 630),
    PS("PSE", 275),
    PT("PRT", 620),
    PW("PLW", 585),
    PY("PRY", 600),
    QA("QAT", 634),
    RE("REU", 638),
    RO("ROU", 642),
    RS("SRB", 688),
    RU("RUS", 643),
    RW("RWA", 646),
    SA("SAU", 682),
    SB("SLB", 90),
    SC("SYC", 690),
    SD("SDN", 729),
    SE("SWE", 752),
    SG("SGP", 702),
    SH("SHN", 654),
    SI("SVN", 705),
    SJ("SJM", 744),
    SK("SVK", 703),
    SL("SLE", 694),
    SM("SMR", 674),
    SN("SEN", 686),
    SO("SOM", 706),
    SR("SUR", 740),
    SS("SSD", 728),
    ST("STP", 678),
    SV("SLV", 222),
    SX("SXM", 534),
    SY("SYR", 760),
    SZ("SWZ", 748),
    TC("TCA", 796),
    TD("TCD", 148),
    TF("ATF", 260),
    TG("TGO", 768),
    TH("THA", 764),
    TJ("TJK", 762),
    TK("TKL", 772),
    TL("TLS", 626),
    TM("TKM", 795),
    TN("TUN", 788),
    TO("TON", 776),
    TR("TUR", 792),
    TT("TTO", 780),
    TV("TUV", 798),
    TW("TWN", 158),
    TZ("TZA", 834),
    UA("UKR", 804),
    UG("UGA", 800),
    UM("UMI", 581),
    US("USA", 840),
    UY("URY", 858),
    UZ("UZB", 860),
    VA("VAT", 336),
    VC("VCT", 670),
    VE("VEN", 862),
    VG("VGB", 92),
    VI("VIR", 850),
    VN("VNM", 704),
    VU("VUT", 548),
    WF("WLF", 876),
    WS("WSM", 882),
    YE("YEM", 887),
    YT("MYT", 175),
    ZA("ZAF", 710),
    ZM("ZMB", 894),
    ZW("ZWE", 716);

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
