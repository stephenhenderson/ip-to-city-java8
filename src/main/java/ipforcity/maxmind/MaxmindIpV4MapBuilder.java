package ipforcity.maxmind;

import ipforcity.CityNameNormalizer;
import ipforcity.IpV4Address;
import ipforcity.NonEmptyUpperCaseAsciiString;
import ipforcity.NormalizedCityCode;
import ipforcity.TwoLetterIsoCountry;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaxmindIpV4MapBuilder {
    
	private static Logger LOG = LoggerFactory.getLogger(MaxmindIpV4MapBuilder.class);
	
	public static final int NUM_HEADER_LINES = 1;
	
    public Map<NormalizedCityCode, IpV4Address> buildMap(String blocksFile, String locationsFile) {
    	LOG.info("Reading ip-ranges from {} ...", locationsFile);
    	Map<String, NormalizedCityCode> ipRangeIdToCity = loadIpRangeIdToCity(locationsFile);
    	return loadIpRangeIdToIpAddress(blocksFile)
    		.filter(p -> ipRangeIdToCity.containsKey(p.ipRangeId))
    		.collect(Collectors.toMap(
    				p -> ipRangeIdToCity.get(p.ipRangeId), 
    				p -> p.ipV4Address,
    				(ip1, ip2) -> ip1)
    				);
    }
    
    public Map<String,NormalizedCityCode> loadIpRangeIdToCity(String locationsFile) {
        try {
            LOG.info("Extracting ip-ranges for cities from {}", locationsFile);
            Stream<String> lines = linesFromFile(locationsFile);
            Map<String, NormalizedCityCode> ipRangeIdToCity = loadIpRangeIdToCity(lines);
            LOG.info("Extracted {} cities from {}", ipRangeIdToCity.size(), locationsFile);
            return ipRangeIdToCity;
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Stream<ParsedBlocksFileLine> loadIpRangeIdToIpAddress(String blocksFile) {
    	try {
            return loadIpRangeIdToIpAddress(linesFromFile(blocksFile));
    	} catch(IOException e) {
    		throw new RuntimeException(e);
    	}
    }
    
	public Stream<ParsedBlocksFileLine> loadIpRangeIdToIpAddress(Stream<String> lines) {
		return lines.map(ParsedBlocksFileLine::fromCsvLine);
	}
    
    private Stream<String> linesFromFile(String fileName) throws IOException{
    	Path filePath = FileSystems.getDefault().getPath(fileName);
    	return Files.lines(filePath).skip(NUM_HEADER_LINES);
    }
    
    public Map<String,NormalizedCityCode> loadIpRangeIdToCity(Stream<String> lines) {
    	return lines
        		.map(ParsedLocationsFileLine::fromCsvLine)
        		.filter(p -> p.isPresent())
        		.map(p -> p.get())
        		.collect(Collectors.toMap(
        			parsedLine -> parsedLine.ipRangeId,
        			parsedLine -> parsedLine.cityCode));
    }
    
    
    public static class ParsedLocationsFileLine {
    	public final String ipRangeId;
    	public final NormalizedCityCode cityCode;
    	
    	public ParsedLocationsFileLine(String ipRangeId, NormalizedCityCode cityCode) {
    		this.ipRangeId = ipRangeId;
    		this.cityCode = cityCode;
    	}
    	
    	public static Optional<ParsedLocationsFileLine> fromCsvLine(String line) {
    		try {
	    		String[] fields = line.split(",");
	            String ipRangeId = fields[0];
	            TwoLetterIsoCountry country = TwoLetterIsoCountry.fromCode(fields[4]);
	            String rawCityName = fields[10].replace("\"", "");
	            if (StringUtils.isNotBlank(rawCityName)) {
	            	NonEmptyUpperCaseAsciiString normalizedCityName = CityNameNormalizer.normalizeCityName(rawCityName);
	            	NormalizedCityCode cityCode = new NormalizedCityCode(normalizedCityName, country);
	            	return Optional.of(new ParsedLocationsFileLine(ipRangeId, cityCode));
	            } else {
	            	// Not all location lines are for cities
	            	return Optional.empty();
	            }
    		} catch(Exception e) {
    			LOG.warn("Invalid locations file line: {}", line);
    			return Optional.empty();
    		}
            
    	}
    }
    
    public static class ParsedBlocksFileLine {
    	public final String ipRangeId;
    	public final IpV4Address ipV4Address;
    	
    	public ParsedBlocksFileLine(String ipRangeId, IpV4Address ipV4Address) {
    		this.ipRangeId = ipRangeId;
    		this.ipV4Address = ipV4Address;
    	}
    	
    	public static ParsedBlocksFileLine fromCsvLine(String line) {
    		String[] fields = line.split(",");
    		IpV4Address ipV4Address = new IpV4Address(StringUtils.substringBefore(fields[0],"/"));
    		String ipRangeId = fields[1];
    		return new ParsedBlocksFileLine(ipRangeId, ipV4Address);
    	}
    	
    }
}
