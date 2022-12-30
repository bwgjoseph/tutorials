package com.bwgjoseph.springbootlombokabstractclasstobuilder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class AddressServiceTests {
    private AddressService sut = new AddressService();

    @Test
    void testAbstractClassBuilder() {
        HomeAddressDO homeAddressDO = HomeAddressDO.builder()
            .id("12345")
            .street("street")
            .postalCode("55555")
            .isRental(true)
            .build();

        // this method will change street from street to modified street
        AddressDO homeAddress = this.sut.createAddress(homeAddressDO);

        log.info("{}", homeAddress);

        Assertions.assertThat(homeAddress.getStreet()).isEqualTo("modified street");
    }

    @Test
    void testSubclassBuilder() {
        HomeAddressDO homeAddressDO = HomeAddressDO.builder()
            .id("12345")
            .street("street")
            .postalCode("55555")
            .isRental(true)
            .build();

        // this method will change isRental from true to false
        HomeAddressDO homeAddress = (HomeAddressDO) this.sut.createCastAddress(homeAddressDO);

        log.info("{}", homeAddress);

        Assertions.assertThat(homeAddress.isRental()).isFalse();
    }
}
