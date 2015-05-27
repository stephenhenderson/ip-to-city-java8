Ip for City
=================

Simple web-service to find an ipv4 address which resolves to a given city name using the 
[Maxmind geolite2 city](http://dev.maxmind.com/geoip/geoip2/geolite2/) geoip datasets. 
Essentially provides a reverse mapping of a regular maxmind lookup which returns the geo-location
for a given ip address.  

Notes
======
I previously wrote a version of the same service [in python](https://github.com/stephenhenderson/ip-to-city-lookup) 
to get some practical experience in writing an end-to-end webapp while learning the language. I rewrote it here 
in java for similar reasons, particularly to get practical experience with the new language features added in java 8 
(lambdas, nio updates, etc.) and to try out some recent java web-containers like dropwizard.

Running
========

* Download and extract the latest maxmind csv data files from [here](http://geolite.maxmind.com/download/geoip/database/GeoLite2-City-CSV.zip).
* Update `ip-for-city.yml` with the paths to the blocks and location files.
* Build the app with maven: `mvn clean install` - generates a 'fat jar' `ip-for-city-<VERSION>.jar` in `target/`
* Run as `java -jar target/ip-for-city-VERSION>.jar server ip-for-city.yml`


