package ipforcity.web;

import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;
import ipforcity.*;

import java.util.Deque;
import java.util.Map;
import java.util.Optional;

public class IpForCityHttpHandler implements HttpHandler {

    public enum IpForCityQsParam {
        CITY_NAME("city"),
        COUNTRY_CODE("country");
        
        private String paramName;
        
        private IpForCityQsParam(String paramName) {
            this.paramName = paramName;
        }
        
        public String getParamName() {
            return paramName;
        }
        
        public String toString() {
            return String.format("%s(%s)", this.name(), paramName);
        }
    }
    
    private final IpForCityFinder ipForCityFinder;
    
    public IpForCityHttpHandler(final IpForCityFinder ipForCityFinder) {
        this.ipForCityFinder = ipForCityFinder;
    }
    
    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        Map<String, Deque<String>> queryStringParams = exchange.getQueryParameters();
        try {
            TwoLetterIsoCountry country = parseCountryFromParams(queryStringParams);
            String cityName = parseCityFromParams(queryStringParams);
            Optional<IpV4Address> result = ipForCityFinder.findIpV4AddressForCity(country, cityName);
            IpV4Address address = result.orElseThrow( () -> new Exception("City not found"));
            exchange.setResponseCode(200);
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getResponseSender().send(address.toString());
            
        } catch(Exception e) {
            exchange.setResponseCode(500);
            exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain");
            exchange.getResponseSender().send(e.toString() + " msg=" + e.getMessage());
        }
    }
    
    private Optional<String> getQsParam(IpForCityQsParam param, Map<String,Deque<String>> qsParams) {
        Deque<String> paramValues = qsParams.get(param.paramName);
        if(paramValues.isEmpty()){
            return Optional.empty();
        } else {
            return Optional.of(paramValues.getFirst());
        }
    }
    
    private String parseCityFromParams(Map<String, Deque<String>> queryStringParams) {
        return getQsParam(IpForCityQsParam.CITY_NAME, queryStringParams)
                .orElseThrow(() -> new RuntimeException("Missing CityName parameter"));
    }

    private TwoLetterIsoCountry parseCountryFromParams(Map<String, Deque<String>> queryStringParams) {
        return getQsParam(IpForCityQsParam.COUNTRY_CODE, queryStringParams)
                .map(TwoLetterIsoCountry::fromCode)
                .orElseThrow(() -> new RuntimeException("Missing CountryCode parameter"));
    }
}
