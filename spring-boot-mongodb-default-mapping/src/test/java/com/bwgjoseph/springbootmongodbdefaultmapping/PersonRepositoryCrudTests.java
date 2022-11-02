package com.bwgjoseph.springbootmongodbdefaultmapping;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
class PersonRepositoryCrudTests {
    @Autowired
    private PersonRepository repository;

    @Test
    void createEmptyObjectWithBuilder() {
        Person toCreate = Person.builder().name(null).build();
        Person created = this.repository.save(toCreate);

        Assertions.assertThat(created.getName()).isNull();
        Assertions.assertThat(created.getAge()).isZero();
        Assertions.assertThat(created.getHeight()).isZero();
        Assertions.assertThat(created.isAdult()).isFalse();
        Assertions.assertThat(created.getAddress()).isNull();
        Assertions.assertThat(created.getHobbies()).isEmpty();
        Assertions.assertThat(created.getAddresses()).isEmpty();
    }

    @Test
    void createEmptyObjectWithDefaultConstructor() {
        Person toCreate = new Person();
        Person created = this.repository.save(toCreate);

        Assertions.assertThat(created.getName()).isEmpty();
        Assertions.assertThat(created.getAge()).isZero();
        Assertions.assertThat(created.getHeight()).isZero();
        Assertions.assertThat(created.isAdult()).isFalse();
        Assertions.assertThat(created.getAddress()).isNull();
        Assertions.assertThat(created.getHobbies()).isEmpty();
        Assertions.assertThat(created.getAddresses()).isEmpty();
    }
}
