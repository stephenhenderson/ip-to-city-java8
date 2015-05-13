package ipforcity.maxmind;

import ipforcity.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MaxmindIpV4MapBuilder {
    
    public Map<NormalizedCityCode, IpV4Address> buildMap(String blocksFile, String locationsFile) {
        //BufferedReader blocksReader = java.nio.file.Files.newBufferedReader()
        return Collections.emptyMap();
    }
    
    public static Map<String,NormalizedCityCode> loadIpRangeIdToCity(String locationsFile) {
        try {
            System.out.println("Extracting ip-ranges for cities from " + locationsFile);
            Map<String, NormalizedCityCode> ipRangeToCity = new HashMap<>();
            Path locationsFilePath = FileSystems.getDefault().getPath(locationsFile);
            BufferedReader blocksReader = java.nio.file.Files.newBufferedReader(locationsFilePath, StandardCharsets.UTF_8);
            boolean isFirst = true;
            while(blocksReader.ready()) {
                if (isFirst) {
                    isFirst = false;
                    continue;
                }
                String line = blocksReader.readLine();
                String[] fields = line.split(",");
                String ipRangeId = fields[0];
                TwoLetterIsoCountry country = TwoLetterIsoCountry.fromCode(fields[3]);
                String rawCityName = fields[7].replace("\"", "");
                NonEmptyUpperCaseAsciiString normalizedCityName = CityNameNormalizer.normalizeCityName(rawCityName);
                NormalizedCityCode cityCode = new NormalizedCityCode(normalizedCityName, country);
                ipRangeToCity.put(ipRangeId, cityCode);
            }
            return ipRangeToCity;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
