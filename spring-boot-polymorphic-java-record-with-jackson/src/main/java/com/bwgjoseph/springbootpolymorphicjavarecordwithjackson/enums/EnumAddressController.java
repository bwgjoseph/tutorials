package com.bwgjoseph.springbootpolymorphicjavarecordwithjackson.enums;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enum/addresses")
public class EnumAddressController {

    @PostMapping()
    public Address create(@RequestBody Address address) {
        if (address instanceof HomeAddressDto) {
            System.out.println("home");
        }

        if (address instanceof OfficeAddressDto) {
            System.out.println("office");
        }

        return address;
    }
}
