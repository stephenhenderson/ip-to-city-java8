package ipforcity;

import java.util.regex.Pattern;


public class IpV4Address {
    
    private static final Pattern IP_V4_REGEX = Pattern.compile("^[0-9][0-9]?[0-9]?\\.[0-9]+\\.[0-9]+\\.[0-9]+$");
    
    private final String ipString;

    public IpV4Address(String ipAddress) throws IllegalArgumentException {
    	if(!IP_V4_REGEX.matcher(ipAddress).matches()) {
    		throw new IllegalArgumentException("Invalid ipv4 address: " + ipAddress);
    	}
    	this.ipString = ipAddress;
    }
    
    @Override
    public String toString() {
        return ipString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IpV4Address that = (IpV4Address) o;

        if (ipString != null ? !ipString.equals(that.ipString) : that.ipString != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return ipString != null ? ipString.hashCode() : 0;
    }
}
