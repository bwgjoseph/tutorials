package com.bwgjoseph.spring_security_securitycontext_mockmvc;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT * FROM \"USER\" WHERE name = :#{ principal?.username }")
    Optional<User> findByName();
}
