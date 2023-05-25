package com.bwgjoseph.springsecurityfilterchain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

@EnableWebSecurity(debug = true)
@Configuration
public class WebSecurityConfig {
    /**
     * This allows us to get an instance of the {@code AuthenticationManager} so to inject into {@code RequestHeaderAuthenticationFilter}
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Comment `@Bean` to disable auto registration of `RequestHeaderAuthenticationFilter` to Servlet Filter
     */
    @Bean // remove on part 4, add back on part 5
    public RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter(AuthenticationManager authenticationManager) {
        RequestHeaderAuthenticationFilter requestHeaderAuthenticationFilter = new RequestHeaderAuthenticationFilter();
        requestHeaderAuthenticationFilter.setPrincipalRequestHeader("X-User");
        requestHeaderAuthenticationFilter.setExceptionIfHeaderMissing(true);
        requestHeaderAuthenticationFilter.setAuthenticationManager(authenticationManager);

        return requestHeaderAuthenticationFilter;
    }

    // part 1
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .build();
    }

    // part 2
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    //     return http
    //         .authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
    //         .build();
    // }

    // part 3
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
    //     return http
    //         .anonymous(AbstractHttpConfigurer::disable)
    //         .authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
    //         // .addFilter(requestHeaderAuthenticationFilter(authenticationManager))
    //         .build();
    // }

    // part 4, 5
    // @Bean
    // public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
    //     return http
    //         .anonymous(AbstractHttpConfigurer::disable)
    //         .authorizeHttpRequests(authz -> authz.anyRequest().authenticated())
    //         .addFilter(requestHeaderAuthenticationFilter(authenticationManager))
    //         .build();
    // }

    /**
     * Uncomment this to toggle between registering and not registering with Servlet Filter
     */
    // enable on part 5
    // @Bean
    // public FilterRegistrationBean<RequestHeaderAuthenticationFilter> registration(RequestHeaderAuthenticationFilter filter) {
    //     FilterRegistrationBean<RequestHeaderAuthenticationFilter> registration = new FilterRegistrationBean<>(filter);
    //     registration.setEnabled(false);
    //     return registration;
    // }

}
