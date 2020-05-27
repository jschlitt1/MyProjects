package edu.wctc.service.converter;

import edu.wctc.entity.Location;
import edu.wctc.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;


public class StringToLocationConverter implements Converter<String, Location> {
    @Autowired
    private LocationService locationService;

    /*
     * Source is guaranteed to not be null, see:
     * https://docs.spring.io/spring/docs/4.1.3.RELEASE/spring-framework-reference/htmlsingle/#core-convert
     */
    @Override
    public Location convert(String source) {
        int locationId = Integer.parseInt(source);
        Location aLocation = locationService.getLocation(locationId);

        return aLocation;
    }
}
