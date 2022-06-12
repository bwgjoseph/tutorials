package com.bwgjoseph.springbootaopwithfilters;

import org.springframework.stereotype.Service;

@Service
public class FlightService {
    @LogExecutionTime
    protected void getFlight() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
