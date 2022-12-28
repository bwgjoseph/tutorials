package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.deduction;

public record OfficeAddressDto(String building, String street, String postalCode, String unit) implements Address {}
