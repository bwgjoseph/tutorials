package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.name;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("home")
public record HomeAddressDto(String street, String postalCode, String unit) implements Address {}
