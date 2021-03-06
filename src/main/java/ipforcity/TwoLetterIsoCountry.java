package ipforcity;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum TwoLetterIsoCountry {

    AFGHANISTAN("AF"),
    ALBANIA("AL"),
    ALGERIA("DZ"),
    AMERICAN_SAMOA("AS"),
    ANDORRA("AD"),
    ANGOLA("AO"),
    ANGUILLA("AI"),
    ANTARCTICA("AQ"),
    ANTIGUA_AND_BARBUDA("AG"),
    ARGENTINA("AR"),
    ARMENIA("AM"),
    ARUBA("AW"),
    AUSTRALIA("AU"),
    AUSTRIA("AT"),
    AZERBAIJAN("AZ"),
    BAHAMAS("BS"),
    BAHRAIN("BH"),
    BANGLADESH("BD"),
    BARBADOS("BB"),
    BELARUS("BY"),
    BELGIUM("BE"),
    BELIZE("BZ"),
    BENIN("BJ"),
    BERMUDA("BM"),
    BHUTAN("BT"),
    BOLIVIA("BO"),
    BOSNIA_AND_HERZEGOVINA("BA"),
    BOTSWANA("BW"),
    BOUVET_ISLAND("BV"),
    BRAZIL("BR"),
    BRITISH_INDIAN_OCEAN_TERRITORY("IO"),
    BRUNEI_DARUSSALAM("BN"),
    BULGARIA("BG"),
    BURKINA_FASO("BF"),
    BURUNDI("BI"),
    CAMBODIA("KH"),
    CAMEROON("CM"),
    CANADA("CA"),
    CAPE_VERDE("CV"),
    CAYMAN_ISLANDS("KY"),
    CENTRAL_AFRICAN_REPUBLIC("CF"),
    CHAD("TD"),
    CHILE("CL"),
    CHINA("CN"),
    CHRISTMAS_ISLAND("CX"),
    COCOS_KEELING_ISLANDS("CC"),
    COLOMBIA("CO"),
    COMOROS("KM"),
    CONGO("CD"),
    COOK_ISLANDS("CK"),
    COSTA_RICA("CR"),
    COTE_D_IVOIRE("CI"),
    CROATIA("HR"),
    CYPRUS("CY"),
    CZECH_REPUBLIC("CZ"),
    DENMARK("DK"),
    DJIBOUTI("DJ"),
    DOMINICA("DM"),
    DOMINICAN_REPUBLIC("DO"),
    EAST_TIMOR("TL"),
    ECUADOR("EC"),
    EGYPT("EG"),
    EL_SALVADOR("SV"),
    EQUATORIAL_GUINEA("GQ"),
    ERITREA("ER"),
    ESTONIA("EE"),
    ETHIOPIA("ET"),
    FALKLAND_ISLANDS_MALVINAS("FK"),
    FAROE_ISLANDS("FO"),
    FIJI("FJ"),
    FINLAND("FI"),
    FRANCE("FR"),
    FRENCH_GUIANA("GF"),
    FRENCH_POLYNESIA("PF"),
    FRENCH_SOUTHERN_TERRITORIES("TF"),
    GABON("GA"),
    GAMBIA("GM"),
    GEORGIA("GE"),
    GERMANY("DE"),
    GHANA("GH"),
    GIBRALTAR("GI"),
    GREECE("GR"),
    GREENLAND("GL"),
    GRENADA("GD"),
    GUADELOUPE("GP"),
    GUAM("GU"),
    GUATEMALA("GT"),
    GUINEA("GN"),
    GUINEA_BISSAU("GW"),
    GUYANA("GY"),
    HAITI("HT"),
    HEARD_AND_MCDONALD_ISLANDS("HM"),
    HONDURAS("HN"),
    HONG_KONG("HK"),
    HUNGARY("HU"),
    ICELAND("IS"),
    INDIA("IN"),
    INDONESIA("ID"),
    IRAQ("IQ"),
    IRELAND("IE"),
    ISRAEL("IL"),
    IRAN("IR"),
    ITALY("IT"),
    JAMAICA("JM"),
    JAPAN("JP"),
    JORDAN("JO"),
    KAZAKHSTAN("KZ"),
    KENYA("KE"),
    KIRIBATI("KI"),
    KUWAIT("KW"),
    KYRGYZSTAN("KG"),
    LAO_PEOPLES_DEMOCRATIC_REPUBLIC("LA"),
    LATVIA("LV"),
    LEBANON("LB"),
    LESOTHO("LS"),
    LIBERIA("LR"),
    LIBYA("LY"),
    LIECHTENSTEIN("LI"),
    LITHUANIA("LT"),
    LUXEMBOURG("LU"),
    MACAU("MO"),
    MACEDONIA("MK"),
    MADAGASCAR("MG"),
    MALAWI("MW"),
    MALAYSIA("MY"),
    MALDIVES("MV"),
    MALI("ML"),
    MALTA("MT"),
    MARSHALL_ISLANDS("MH"),
    MARTINIQUE("MQ"),
    MAURITANIA("MR"),
    MAURITIUS("MU"),
    MAYOTTE("YT"),
    MEXICO("MX"),
    MICRONESIA("FM"),
    MOLDOVA("MD"),
    MONACO("MC"),
    MONGOLIA("MN"),
    MONTSERRAT("MS"),
    MOROCCO("MA"),
    MOZAMBIQUE("MZ"),
    NAMIBIA("NA"),
    NAURU("NR"),
    NEPAL("NP"),
    NETHERLANDS("NL"),
    NETHERLANDS_ANTILLES("AN"),
    NEW_CALEDONIA("NC"),
    NEW_ZEALAND("NZ"),
    NICARAGUA("NI"),
    NIGER("NE"),
    NIGERIA("NG"),
    NIUE("NU"),
    NORFOLK_ISLAND("NF"),
    NORTHERN_MARIANA_ISLANDS("MP"),
    NORWAY("NO"),
    OMAN("OM"),
    PAKISTAN("PK"),
    PALAU("PW"),
    PALESTINIAN_TERRITORY("PS"),
    PANAMA("PA"),
    PAPUA_NEW_GUINEA("PG"),
    PARAGUAY("PY"),
    PERU("PE"),
    PHILIPPINES("PH"),
    PITCAIRN("PN"),
    POLAND("PL"),
    PORTUGAL("PT"),
    PUERTO_RICO("PR"),
    QATAR("QA"),
    REUNION("RE"),
    ROMANIA("RO"),
    RUSSIAN_FEDERATION("RU"),
    RWANDA("RW"),
    SAINT_KITTS_AND_NEVIS("KN"),
    SAINT_LUCIA("LC"),
    SAINT_VINCENT_AND_THE_GRENADINES("VC"),
    SAMOA("WS"),
    SAN_MARINO("SM"),
    SAO_TOME_AND_PRINCIPE("ST"),
    SAUDI_ARABIA("SA"),
    SENEGAL("SN"),
    SERBIA_AND_MONTENEGRO("CS"),
    SEYCHELLES("SC"),
    SIERRA_LEONE("SL"),
    SINGAPORE("SG"),
    SLOVAKIA("SK"),
    SLOVENIA("SI"),
    SOLOMON_ISLANDS("SB"),
    SOMALIA("SO"),
    SOUTH_AFRICA("ZA"),
    SOUTH_GEORGIA_AND_THE_SOUTH_SANDWICH_ISLANDS("GS"),
    SOUTH_KOREA("KR"),
    SPAIN("ES"),
    SRI_LANKA("LK"),
    ST_HELENA("SH"),
    ST_PIERRE_AND_MIQUELON("PM"),
    SURINAME("SR"),
    SVALBARD_AND_JAN_MAYEN_ISLANDS("SJ"),
    SWAZILAND("SZ"),
    SWEDEN("SE"),
    SWITZERLAND("CH"),
    TAIWAN("TW"),
    TAJIKISTAN("TJ"),
    TANZANIA("TZ"),
    THAILAND("TH"),
    TOGO("TG"),
    TOKELAU("TK"),
    TONGA("TO"),
    TRINIDAD_AND_TOBAGO("TT"),
    TUNISIA("TN"),
    TURKEY("TR"),
    TURKMENISTAN("TM"),
    TURKS_AND_CAICOS_ISLANDS("TC"),
    TUVALU("TV"),
    UGANDA("UG"),
    UKRAINE("UA"),
    UNITED_ARAB_EMIRATES("AE"),
    UNITED_KINGDOM("GB"),
    UNITED_STATES("US"),
    UNITED_STATES_MINOR_OUTLYING_ISLANDS("UM"),
    URUGUAY("UY"),
    UZBEKISTAN("UZ"),
    VANUATU("VU"),
    VATICAN("VA"),
    VENEZUELA("VE"),
    VIET_NAM("VN"),
    VIRGIN_ISLANDS_BRITISH("VG"),
    VIRGIN_ISLANDS_US("VI"),
    WALLIS_AND_FUTUNA_ISLANDS("WF"),
    WESTERN_SAHARA("EH"),
    YEMEN("YE"),
    ZAMBIA("ZM"),
    ZIMBABWE("ZW");
    
    private final String code;
    
    private TwoLetterIsoCountry(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }

    private static final Map<String, TwoLetterIsoCountry> codeToCountries = buildCountryCodesByCodeMap();
    
    private static Map<String, TwoLetterIsoCountry> buildCountryCodesByCodeMap() {
        return Arrays.asList(TwoLetterIsoCountry.values())
                .stream()
                .collect(Collectors.toMap(c -> c.getCode(), c -> c));
    }
    
    public static TwoLetterIsoCountry fromCode(String code) throws UnknownCountryCodeException {
        TwoLetterIsoCountry country = codeToCountries.get(code.toUpperCase());
        if(country != null) {
            return country;            
        } else {
            throw new UnknownCountryCodeException(code);
        }
    }
}
