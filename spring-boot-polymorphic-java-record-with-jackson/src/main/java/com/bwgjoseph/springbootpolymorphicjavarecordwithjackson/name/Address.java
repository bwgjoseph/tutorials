package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.name;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
@JsonSubTypes({
    @Type(value = HomeAddressDto.class, name = "home"),
    @Type(value = OfficeAddressDto.class, name = "office")
})
public interface Address {

}
