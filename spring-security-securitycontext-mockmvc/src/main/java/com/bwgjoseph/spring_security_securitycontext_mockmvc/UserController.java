package com.bwgjoseph.spring_security_securitycontext_mockmvc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@PathVariable String name) {
        return this.userRepository.save(new User(null, name));
    }
}
