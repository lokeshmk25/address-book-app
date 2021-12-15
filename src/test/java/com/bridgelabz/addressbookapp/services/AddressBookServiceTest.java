package com.bridgelabz.addressbookapp.services;


import com.bridgelabz.addressbookapp.builder.AddressBookBuilder;
import com.bridgelabz.addressbookapp.controller.AddressBookController;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressBookServiceTest {

    @InjectMocks
    private AddressBookService service;
    @Mock
    private AddressBookController controller;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private AddressBookBuilder builder;
    @Mock
    private AddressBookRepository addressBookRepository;

    @Test
    void givengetallAddressMethod_WhenCalled_ShouldReturnListOfAddressbook() {
        List<Address> addressList=new ArrayList<>();
        Address address = new Address();
        address.setName("Lokesh");
        address.setAddress("Richie street");
        address.setCity("Vellore");
        address.setState("TamilNadu");
        address.setPhoneNumber("9876543210");
        address.setZip("635808");
        address.setCreatedOn(LocalDateTime.now());
        address.setUpdatedOn(LocalDateTime.now());
        addressList.add(address);
        Address address1 = new Address();
        address1.setName("Sage");
        address1.setAddress("Richie street");
        address1.setCity("Vellore");
        address1.setState("TamilNadu");
        address1.setPhoneNumber("9876543210");
        address1.setZip("635808");
        address1.setCreatedOn(LocalDateTime.now());
        address1.setUpdatedOn(LocalDateTime.now());
        addressList.add(address1);

        List<AddressDTO> addressDTOList=new ArrayList<>();
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName("Sage");
        addressDTO.setAddress("Richie street");
        addressDTO.setCity("Vellore");
        addressDTO.setState("TamilNadu");
        addressDTO.setPhoneNumber("9876543210");
        addressDTO.setZip("635808");
        addressDTOList.add(addressDTO);
        AddressDTO addressDTO1 = new AddressDTO();
        addressDTO1.setName("Lokesh");
        addressDTO1.setAddress("Richie street");
        addressDTO1.setCity("Vellore");
        addressDTO1.setState("TamilNadu");
        addressDTO1.setPhoneNumber("9876543210");
        addressDTO1.setZip("635808");
        addressDTOList.add(addressDTO1);

        when(addressBookRepository.findAll()).thenReturn(addressList);
        when(modelMapper.map(addressList.get(0), AddressDTO.class)).thenReturn(addressDTO);
        when(modelMapper.map(addressList.get(1), AddressDTO.class)).thenReturn(addressDTO1);
        List<AddressDTO> getallAddress = service.getallAddress();
        Assertions.assertEquals(2,getallAddress.size());
        Assertions.assertEquals(addressDTOList,getallAddress);

    }
}
