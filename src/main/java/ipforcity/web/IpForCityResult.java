package ipforcity.web;

import ipforcity.IpV4Address;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IpForCityResult {

	private final String ipV4Address;
	
	public static IpForCityResult fromIpV4(IpV4Address ipV4Address) {
		return new IpForCityResult(ipV4Address.toString());
	}
	
	public IpForCityResult(String ipV4Address) {
		this.ipV4Address = ipV4Address;
	}
	
	@JsonProperty
	public String getIpV4Address() {
		return ipV4Address;
	}
	
}
