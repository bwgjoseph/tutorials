package com.bwgjoseph.springbootmongodbdefaultmapping;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping("/person/{id}")
    public Optional<Person> get(@PathVariable("id") String id) {
        return this.personRepository.findById(id);
    }

    @PostMapping("/person")
    public Person create(@RequestBody Person person) {
        return this.personRepository.save(person);
    }
}

