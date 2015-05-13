package ipforcity;

import io.undertow.Undertow;
import ipforcity.web.IpForCityHttpHandler;

import java.util.HashMap;

public class IpForCityWebServer {

    public static void main(String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(new IpForCityHttpHandler(
                        new MapBackedIpForCityFinder(
                                new HashMap<NormalizedCityCode,IpV4Address>())
                )).build();
        server.start();
        
    }
}
