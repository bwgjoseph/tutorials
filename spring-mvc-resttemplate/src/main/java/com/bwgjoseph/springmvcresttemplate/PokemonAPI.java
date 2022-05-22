package com.bwgjoseph.springmvcresttemplate;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PokemonAPI {
    private static final String POKE_URL = "https://pokeapi.co/api/v2/pokemon/{name}";
    private final RestTemplate restTemplate;

    public Pokemon get(String name) {
        return restTemplate.exchange(POKE_URL, HttpMethod.GET, null, Pokemon.class, name).getBody();
    }
}
