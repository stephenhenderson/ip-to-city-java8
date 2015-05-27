package ipforcity.web;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import ipforcity.IpForCityFinder;
import ipforcity.IpV4Address;
import ipforcity.TwoLetterIsoCountry;

import java.util.Optional;

import org.junit.Test;

import com.codahale.metrics.health.HealthCheck.Result;

public class IpForCityHealthCheckTest {

	private IpForCityFinder healthyIpForCityFinder = new IpForCityFinder() {
		@Override
		public Optional<IpV4Address> findIpV4AddressForCity(TwoLetterIsoCountry country, String cityName) {
			return Optional.of(new IpV4Address("123.65.23.1"));
		}
	};
	
	private IpForCityFinder unhealthyIpForCityFinder = new IpForCityFinder() {
		@Override
		public Optional<IpV4Address> findIpV4AddressForCity(TwoLetterIsoCountry country, String cityName) {
			return Optional.empty();
		}
	};
	
	@Test
	public void healthCheckIsPositiveWhenIpExistsForCity() throws Exception {
		Result healthCheckResult = new IpForCityHealthCheck(healthyIpForCityFinder).check();
		assertTrue("Health check should be positive", healthCheckResult.isHealthy());
	}
	
	@Test
	public void healthCheckIsNegativeWhenNoIpExistsForCity() throws Exception {
		Result healthCheckResult = new IpForCityHealthCheck(unhealthyIpForCityFinder).check();
		assertFalse("Health check should be negative", healthCheckResult.isHealthy());
	}
}
