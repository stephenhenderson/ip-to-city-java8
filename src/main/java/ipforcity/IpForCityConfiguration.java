package ipforcity;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class IpForCityConfiguration extends Configuration {
	
	@NotEmpty
	private String maxmindLocationFile;
	
	@NotEmpty
	private String maxmindBlocksFile;

	@JsonProperty
	public String getMaxmindLocationFile() {
		return maxmindLocationFile;
	}
	
	@JsonProperty
	public void setMaxmindLocationFile(String maxmindLocationFile) {
		this.maxmindLocationFile = maxmindLocationFile;
	}
	
	@JsonProperty
	public String getMaxmindBlocksFile() {
		return maxmindBlocksFile;
	}
	
	@JsonProperty
	public void setMaxmindBlocksFile(String maxmindBlocksFile) {
		this.maxmindBlocksFile = maxmindBlocksFile;
	}
	
	
	
	
}
