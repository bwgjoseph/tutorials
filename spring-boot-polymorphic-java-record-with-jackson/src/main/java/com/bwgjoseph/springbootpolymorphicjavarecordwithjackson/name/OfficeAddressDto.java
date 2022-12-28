package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.name;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("office")
public record OfficeAddressDto(String building, String street, String postalCode, String unit) implements Address {}
