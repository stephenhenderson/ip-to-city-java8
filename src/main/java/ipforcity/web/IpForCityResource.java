package ipforcity.web;

import ipforcity.IpForCityFinder;
import ipforcity.TwoLetterIsoCountry;
import ipforcity.UnknownCountryCodeException;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.codahale.metrics.annotation.Timed;

@Path("/ipforcity")
@Produces(MediaType.APPLICATION_JSON)
public class IpForCityResource {
	
	private final IpForCityFinder ipForCityFinder;
	
	public IpForCityResource(IpForCityFinder ipForCityFinder) {
		this.ipForCityFinder = ipForCityFinder;
	}
	
	@GET
	@Timed
	public IpForCityResult lookupIpForCity(
			@QueryParam("city") String city,
			@QueryParam("country") String country) {
		try {
			TwoLetterIsoCountry countryCode = TwoLetterIsoCountry.fromCode(country);
			IpForCityResult result = ipForCityFinder.findIpV4AddressForCity(countryCode, city)
					.map(IpForCityResult::fromIpV4)
					.orElseThrow(() -> new RuntimeException("No results"));
			return result;
		} catch(UnknownCountryCodeException e) {
			
			Response r = null;
			throw new BadRequestException(e);
		}
	}
}
