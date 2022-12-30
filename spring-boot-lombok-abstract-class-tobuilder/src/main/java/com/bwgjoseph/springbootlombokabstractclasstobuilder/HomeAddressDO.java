package com.bwgjoseph.springbootlombokabstractclasstobuilder;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class HomeAddressDO extends AddressDO {
    private boolean isRental;
}
