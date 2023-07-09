package com.bwgjoseph.springsecuritycustompreauthenticationflow;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeController {

    @GetMapping("/me")
    public UserDetails me(@AuthenticationPrincipal UserDetails userDetails) {
        return userDetails;
    }
}
