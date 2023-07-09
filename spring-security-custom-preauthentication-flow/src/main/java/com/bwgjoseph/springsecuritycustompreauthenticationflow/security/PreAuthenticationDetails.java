package com.bwgjoseph.springsecuritycustompreauthenticationflow.security;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class PreAuthenticationDetails extends WebAuthenticationDetails implements GrantedAuthoritiesContainer {
    private static final String HEADER_AUTHORITY = "X-Authorities";
    private final List<String> authorities;

    public PreAuthenticationDetails(HttpServletRequest request) {
        super(request);
        this.authorities = List.of(request.getHeader(HEADER_AUTHORITY).split(","));
    }

    @Override
    public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
        return this.authorities.stream().map(SimpleGrantedAuthority::new).toList();
    }

}
