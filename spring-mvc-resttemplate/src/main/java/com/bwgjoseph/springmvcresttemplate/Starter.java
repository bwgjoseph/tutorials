package com.bwgjoseph.springmvcresttemplate;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Starter implements ApplicationListener<ApplicationReadyEvent> {
    private final PokemonAPI pokemonAPI;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        Pokemon pokemon = this.pokemonAPI.get("ditto");
        log.info("{}", pokemon.toString());
    }

}
