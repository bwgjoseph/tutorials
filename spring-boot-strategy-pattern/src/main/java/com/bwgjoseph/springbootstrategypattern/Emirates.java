package com.bwgjoseph.springbootstrategypattern;

import org.springframework.stereotype.Service;

@Service("Emirates")
public class Emirates implements FlightInfo {

    @Override
    public String display() {
        return "Emirates Airlines";
    }

}
