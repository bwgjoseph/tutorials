package com.bwgjoseph.springmvcresttemplate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
    @Bean
    public RestTemplate myRestTemplate() {
        return new RestTemplate();
    }
}
