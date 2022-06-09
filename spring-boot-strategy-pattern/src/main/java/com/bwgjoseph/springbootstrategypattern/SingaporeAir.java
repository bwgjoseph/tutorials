package com.bwgjoseph.springbootstrategypattern;

import org.springframework.stereotype.Service;

@Service("SingaporeAir")
public class SingaporeAir implements FlightInfo {

    @Override
    public String display() {
        return "Singapore Airlines";
    }

}
