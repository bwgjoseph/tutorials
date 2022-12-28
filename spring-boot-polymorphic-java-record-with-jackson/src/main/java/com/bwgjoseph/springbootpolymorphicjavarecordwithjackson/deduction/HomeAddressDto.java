package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.deduction;

public record HomeAddressDto(String street, String postalCode, String unit) implements Address {}
