package ipforcity;

import java.util.Optional;

/**
 * Unique code for a city with any non-ascii characters stripped
 */
public class NormalizedCityCode {
    
    private final NonEmptyUpperCaseAsciiString normalizedCityName;
    private final TwoLetterIsoCountry countryCode;
    
    public NormalizedCityCode(NonEmptyUpperCaseAsciiString normalizedCityName,
                              TwoLetterIsoCountry countryCode) {
        
        if(normalizedCityName == null) {
            throw new IllegalArgumentException("Normalized city cannot be null");
        } else if(countryCode == null) {
            throw new IllegalArgumentException("Country code cannot be null");
        }
        this.normalizedCityName = normalizedCityName;
        this.countryCode = countryCode;
    }

    public static NormalizedCityCode newCityCode(String rawCityName, String rawCountryCode) {
        NonEmptyUpperCaseAsciiString normalizedCity = CityNameNormalizer.normalizeCityName(rawCityName);
        TwoLetterIsoCountry isoCountry = TwoLetterIsoCountry.fromCode(rawCountryCode);
        return new NormalizedCityCode(normalizedCity, isoCountry);
    }
    
    public NonEmptyUpperCaseAsciiString getNormalizedCityName() {
        return normalizedCityName;
    }

    public TwoLetterIsoCountry getCountryCode() {
        return countryCode;
    }
    
    @Override
    public String toString() {
        return normalizedCityName + "-" + countryCode.getCode();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NormalizedCityCode that = (NormalizedCityCode) o;

        if (countryCode != that.countryCode) return false;
        if (!normalizedCityName.equals(that.normalizedCityName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = normalizedCityName.hashCode();
        result = 31 * result + countryCode.hashCode();
        return result;
    }
}
