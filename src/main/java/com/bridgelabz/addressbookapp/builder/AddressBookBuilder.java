package com.bridgelabz.addressbookapp.builder;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressBookBuilder {
    @Autowired
    private ModelMapper modelMapper;

    public Address buildAddressEntity(AddressDTO addressDto, Address address) {
        modelMapper.map(addressDto, address);
        return address;
    }
}
