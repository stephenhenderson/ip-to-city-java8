package ipforcity;

public enum KnownIpAddress {
    
    LISBURN_GB("GB", "LISBURN", new IpV4Address("212.219.119.152")),
    ECHIROLLES_FR("FR", "ECHIROLLES", new IpV4Address("89.156.204.193"));
    
    private final String countryCode;
    private final String cityName;
    private final IpV4Address ipV4Address;
    
    private KnownIpAddress(String countryCode, String cityName, IpV4Address ipV4Address) {
        this.countryCode = countryCode;
        this.cityName = cityName;
        this.ipV4Address = ipV4Address;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public IpV4Address getIpV4Address() {
        return ipV4Address;
    }


    @Override
    public String toString() {
        return "KnownIpAddresses{" +
                "countryCode='" + countryCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", ipV4Address=" + ipV4Address +
                '}';
    }
}
