package com.bwgjoseph.springbootlombokabstractclasstobuilder;

import org.springframework.stereotype.Service;

@Service
public class AddressService {
    // we can only modify fields that belongs to the abstract class
    public AddressDO createAddress(AddressDO addressDO) {
        addressDO = addressDO.toBuilder().street("modified street").build();
        return addressDO;
    }

    // if we need to manipulate the subclass fields, then we need to cast it first
    public AddressDO createCastAddress(AddressDO addressDO) {
        addressDO = ((HomeAddressDO) addressDO).toBuilder().isRental(false).build();
        return addressDO;
    }
}
