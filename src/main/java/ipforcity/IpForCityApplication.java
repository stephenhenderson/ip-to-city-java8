package ipforcity;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ipforcity.maxmind.MaxmindIpV4MapBuilder;
import ipforcity.web.IpForCityHealthCheck;
import ipforcity.web.IpForCityResource;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IpForCityApplication extends Application<IpForCityConfiguration> {
	
	private static final Logger LOG = LoggerFactory.getLogger(IpForCityApplication.class);
		
	public static void main(String[] args) throws Exception {
		new IpForCityApplication().run(args);
	}
	
	@Override
    public void initialize(Bootstrap<IpForCityConfiguration> bootstrap) {
    }
	
	@Override
	public void run(IpForCityConfiguration configuration, Environment environment) throws Exception {
		IpForCityFinder ipForCityFinder = createIpForCityFinder(configuration);
		LOG.info("Registering IpForCityResource...");
		final IpForCityResource resource = new IpForCityResource(ipForCityFinder);
		environment.jersey().register(resource);
		LOG.info("Registered IpForCityResource successfully.");
		
		LOG.info("Registering healthcheck...");
		environment.healthChecks().register("IpForCityFinder", new IpForCityHealthCheck(ipForCityFinder));
		LOG.info("Registered health check successfully.");
	}
	
	@Override
    public String getName() {
        return "ip-for-city";
    }
	
	private IpForCityFinder createIpForCityFinder(IpForCityConfiguration conf) {
		LOG.info("Initialising ipForCityFinder...");
		MaxmindIpV4MapBuilder mapBuilder = new MaxmindIpV4MapBuilder();
		Map<NormalizedCityCode, IpV4Address> ipV4AddressMap = mapBuilder.buildMap(
				conf.getMaxmindBlocksFile(), 
				conf.getMaxmindLocationFile());
		LOG.info("Initialised ipForCityFinder successfully.");
		return new MapBackedIpForCityFinder(ipV4AddressMap);
	}
	
}
