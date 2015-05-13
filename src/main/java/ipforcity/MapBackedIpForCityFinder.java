package ipforcity;

import java.util.Map;
import java.util.Optional;

public class MapBackedIpForCityFinder implements IpForCityFinder {
    
    private final Map<NormalizedCityCode,IpV4Address> ipV4AddressMap;
    
    public MapBackedIpForCityFinder(final Map<NormalizedCityCode, IpV4Address> ipV4AddressMap) {
        this.ipV4AddressMap = ipV4AddressMap;
    }
    
    @Override
    public Optional<IpV4Address> findIpV4AddressForCity(TwoLetterIsoCountry country, String cityName) {
        NonEmptyUpperCaseAsciiString normalizedCityName = CityNameNormalizer.normalizeCityName(cityName);
        NormalizedCityCode cityCode = new NormalizedCityCode(normalizedCityName, country);
        return Optional.ofNullable(ipV4AddressMap.get(cityCode));
    }
}
