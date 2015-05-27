package ipforcity;

public class UnknownCountryCodeException extends RuntimeException {
    
	private static final long serialVersionUID = 1L;

	public UnknownCountryCodeException(String countryCode) {
        super("Unknown country code: " + countryCode);
    }
}
