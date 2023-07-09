package com.bwgjoseph.springsecuritycustompreauthenticationflow.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class PreAuthUserDetailsService implements AuthenticationUserDetailsService<PreAuthenticatedAuthenticationToken> {

    @Override
    public UserDetails loadUserDetails(PreAuthenticatedAuthenticationToken token) throws UsernameNotFoundException {
        // List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ADMIN"));
        PreAuthenticationDetails details = (PreAuthenticationDetails) token.getDetails();
        return this.buildUserDetails(token, details.getGrantedAuthorities());
    }

    protected UserDetails buildUserDetails(PreAuthenticatedAuthenticationToken token, Collection<? extends GrantedAuthority> authorities) {
        return new PreAuthUserDetails(token.getName(), authorities);
    }
}
