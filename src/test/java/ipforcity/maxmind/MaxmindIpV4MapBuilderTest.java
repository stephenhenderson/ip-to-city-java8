package ipforcity.maxmind;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import ipforcity.IpV4Address;
import ipforcity.TwoLetterIsoCountry;
import ipforcity.maxmind.MaxmindIpV4MapBuilder.ParsedBlocksFileLine;
import ipforcity.maxmind.MaxmindIpV4MapBuilder.ParsedLocationsFileLine;

import java.util.Optional;

import org.junit.Test;

public class MaxmindIpV4MapBuilderTest {
	
	@Test
	public void parsesRangeIdAndCityCodeFromLocationFileLine() {
		String csvLine = 
				"2639788,en,EU,Europe,GB,\"United Kingdom\",SCT,Scotland,EDH,Edinburgh,Queensferry,,Europe/London";
		Optional<ParsedLocationsFileLine> parsed = ParsedLocationsFileLine.fromCsvLine(csvLine);
		assertTrue("Location file line is valid", parsed.isPresent());
		parsed.ifPresent(p -> {
			assertEquals("Parsed range id", "2639788", p.ipRangeId);
			assertEquals("Parsed city code", TwoLetterIsoCountry.UNITED_KINGDOM, p.cityCode.getCountryCode());
			assertEquals("Parsed city name", "QUEENSFERRY", p.cityCode.getNormalizedCityName().toString());
		});
	}
	
	
	@Test
	public void parsesIpAddressAndRangeIdFromBlocksFileLine() {
		String csvLine = "128.71.14.0/24,2017370,2017370,,0,0,,55.7500,37.6166";
		ParsedBlocksFileLine parsed = ParsedBlocksFileLine.fromCsvLine(csvLine);
		assertEquals("Parsed ip-address", new IpV4Address("128.71.14.0"), parsed.ipV4Address);
		assertEquals("Parsed range id", "2017370", parsed.ipRangeId);
	}
	
}
