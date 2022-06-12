package com.bwgjoseph.springbootaopwithfilters;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Startup implements ApplicationListener<ApplicationReadyEvent> {
    private final FlightService flightService;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.flightService.getFlight();
    }

}
