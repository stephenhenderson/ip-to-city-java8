package ipforcity;

public class UnknownCountryCodeException extends RuntimeException {
    public UnknownCountryCodeException(String countryCode) {
        super("Unknown country code: " + countryCode);
    }
}
