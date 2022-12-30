package com.bwgjoseph.springbootlombokabstractclasstobuilder;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder(toBuilder = true)
public class OfficeAddressDO extends AddressDO {
    private String building;
}
