package com.bwgjoseph.springsecuritydebug;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
    @Value("${web.security.debug}")
    private boolean enableDebug;

    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.debug(enableDebug);
    }
}
