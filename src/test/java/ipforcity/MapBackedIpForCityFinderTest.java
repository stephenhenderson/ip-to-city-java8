package ipforcity;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static ipforcity.KnownIpAddress.ECHIROLLES_FR;
import static ipforcity.KnownIpAddress.LISBURN_GB;
import static ipforcity.TwoLetterIsoCountry.UNITED_KINGDOM;
import static ipforcity.TwoLetterIsoCountry.FRANCE;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class MapBackedIpForCityFinderTest {
    
    private Map<NormalizedCityCode, IpV4Address> ipV4AddressMap;
    private MapBackedIpForCityFinder finder;
    
    @Before
    public void setup(){
        this.ipV4AddressMap = Arrays.asList(KnownIpAddress.values())
                .stream()
                .collect(Collectors.toMap(
                        c -> NormalizedCityCode.newCityCode(c.getCityName(), c.getCountryCode()),
                        c -> c.getIpV4Address()));
        this.finder = new MapBackedIpForCityFinder(ipV4AddressMap);
    }
    
    @Test
    public void findsIpV4AddressForKnownCityWithOnlyAsciiCharacters() {
        Optional<IpV4Address> foundAddressResult = finder.findIpV4AddressForCity(UNITED_KINGDOM, "Lisburn");
        assertIpAddressFound(LISBURN_GB, foundAddressResult);
    }
    
    @Test
    public void findsIpV4AddressForKnownCityWithNonAsciiCharacters() {
        Optional<IpV4Address> foundAddressResult = finder.findIpV4AddressForCity(FRANCE, "Échirolles");
        assertIpAddressFound(ECHIROLLES_FR, foundAddressResult);
    }
    
    @Test
    public void returnsEmptyForUnknownCity() {
        Optional<IpV4Address> foundAddressResult = finder.findIpV4AddressForCity(UNITED_KINGDOM, "NowheresTown");
        assertEquals("Result for unknown city", Optional.empty(), foundAddressResult);
    }
    
    private void assertIpAddressFound(KnownIpAddress knownIp, Optional<IpV4Address> foundAddressResult) {
        assertTrue("Expected to find ipaddress for " + knownIp, foundAddressResult.isPresent());
        assertEquals("Ip address for " + knownIp, knownIp.getIpV4Address(), foundAddressResult.get());
    }
}
