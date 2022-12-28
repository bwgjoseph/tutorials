package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.enums;

public record HomeAddressDto(String street, String postalCode, String unit) implements Address {}
