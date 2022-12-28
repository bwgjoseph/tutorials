package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.enums;

public record OfficeAddressDto(String building, String street, String postalCode, String unit) implements Address {}
