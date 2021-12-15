package com.bridgelabz.addressbookapp.builder;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Purpose - To Build Address book Entity
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 */
@Component
public class AddressBookBuilder {
    @Autowired
    private ModelMapper modelMapper;

    /**
     * Purpose - To build address book entity
     *
     * @param addressDto : addressDto is taken as input and mapped to model mapper
     * @param address    : address entity is also taken as input for conversion
     * @return : address entity after converted by model mapper
     */
    public Address buildAddressEntity(AddressDTO addressDto, Address address) {
        modelMapper.map(addressDto, address);
        return address;
    }
}
