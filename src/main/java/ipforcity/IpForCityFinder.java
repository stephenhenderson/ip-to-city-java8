package ipforcity;

import java.util.Optional;

public interface IpForCityFinder {

    Optional<IpV4Address> findIpV4AddressForCity(TwoLetterIsoCountry country, String cityName);
    
}
