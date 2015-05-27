package ipforcity.web;

import static ipforcity.TwoLetterIsoCountry.UNITED_KINGDOM;
import ipforcity.IpForCityFinder;

import com.codahale.metrics.health.HealthCheck;

public class IpForCityHealthCheck extends HealthCheck {

	private final IpForCityFinder ipForCityFinder;
	
	public IpForCityHealthCheck(IpForCityFinder ipForCityFinder) {
		this.ipForCityFinder = ipForCityFinder;
	}
	
	@Override
	protected Result check() throws Exception {
		boolean isHealthy = doesIpFinderReturnAnIpAddressForLondon();
		if (isHealthy) {
			return Result.healthy();
		} else {
			return Result.unhealthy("IpForCityFinder does not find an ipV4 address for London, UK");
		}
	}
	
	private boolean doesIpFinderReturnAnIpAddressForLondon() {
		return ipForCityFinder.findIpV4AddressForCity(UNITED_KINGDOM, "London").isPresent();
	}

}
