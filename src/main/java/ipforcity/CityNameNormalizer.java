package ipforcity;

import org.apache.commons.lang3.StringUtils;

public class CityNameNormalizer {
    
    public static NonEmptyUpperCaseAsciiString normalizeCityName(String rawCityName) {
        String withoutAccents = StringUtils.stripAccents(rawCityName);
        String withoutAccentsAndUpperCase = StringUtils.upperCase(withoutAccents);
        return new NonEmptyUpperCaseAsciiString(withoutAccentsAndUpperCase);
    }
    
}
