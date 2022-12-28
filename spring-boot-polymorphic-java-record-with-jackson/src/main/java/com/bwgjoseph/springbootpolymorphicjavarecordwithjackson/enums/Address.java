package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.enums;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
    @Type(value = HomeAddressDto.class, name = "home"),
    @Type(value = OfficeAddressDto.class, name = "office")
})
public interface Address {

}
