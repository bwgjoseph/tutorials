package com.bwgjoseph.springbootstrategypattern;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FlightController {
    private final Map<String, FlightInfo> flightInfoMap;

    @GetMapping("/flights/{airline}")
    public String getFlightInfo(@PathVariable("airline") String airline) {
        FlightInfo flightInfo = this.flightInfoMap.get(airline);

        if (flightInfo != null) {
            return flightInfo.display();
        }

        return "N.A";
    }
}
