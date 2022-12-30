package com.bwgjoseph.springbootlombokabstractclasstobuilder;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder(toBuilder = true)
public abstract class AddressDO {
    // Force subclasses to implement this method
    public abstract AddressDOBuilder<?, ?> toBuilder();

    private String id;
    private String street;
    private String postalCode;
    private String unit;
}
