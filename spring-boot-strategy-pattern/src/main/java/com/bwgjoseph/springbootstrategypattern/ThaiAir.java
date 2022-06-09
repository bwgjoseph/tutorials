package com.bwgjoseph.springbootstrategypattern;

import org.springframework.stereotype.Service;

@Service("ThaiAir")
public class ThaiAir implements FlightInfo {

    @Override
    public String display() {
        return "Thai Airways";
    }

}
