package com.bwgjoseph.springbootstrategypattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class FlightNonStrategyController {
    private final SingaporeAir singaporeAir;
    private final ThaiAir thaiAir;

    @GetMapping("/flights/ns/{airline}")
    public String getFlightInfo(@PathVariable("airline") String airline) {
        if ("ThaiAir".equals(airline)) {
            return this.thaiAir.display();
        }

        if ("SingaporeAir".equals(airline)) {
            return this.singaporeAir.display();
        }

        return "N.A";
    }
}
