package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.deduction;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION, defaultImpl = HomeAddressDto.class)
@JsonSubTypes({
    @Type(HomeAddressDto.class),
    @Type(OfficeAddressDto.class)
})
public interface Address {

}
