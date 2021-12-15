package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.entity.ResponseEntity;
import com.bridgelabz.addressbookapp.services.AddressBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {
    @InjectMocks
    private AddressBookController controller;
    @Mock
    private AddressBookService service;

    @Test
    void givenGreetingsMethodCalled_ShouldReturnsuccessMessage() {
        String message="Welcome to AddressBook application";
        String greetings = controller.greetings();
        Assertions.assertEquals(message,greetings);
    }

    @Test
    void givenaddressDTO_WhenAdded_ShouldReturnResponseEntity() {
        String message="Data added to address book";
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName("Lokesh");
        addressDTO.setAddress("Richie street");
        addressDTO.setCity("Ambur");
        addressDTO.setState("TamilNadu");
        addressDTO.setZip("635808");
        addressDTO.setPhoneNumber("9876543210");
        when(service.addAddress(addressDTO)).thenReturn(message);
        ResponseEntity responseEntity = controller.addAddress(addressDTO);
        Assertions.assertEquals(message,responseEntity.getMessage());
        Assertions.assertEquals(addressDTO,responseEntity.getData());
    }
    @Test
    void givenaddressDTO_WhenAdded_ShouldReturnErrorMessage() {
        String message = "Address updated successfully";
        int id =1;
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName("Lokesh");
        addressDTO.setAddress("Richie street");
        addressDTO.setCity("Ambur");
        addressDTO.setState("TamilNadu");
        addressDTO.setZip("635808");
        addressDTO.setPhoneNumber("9876543210");
        when(service.updateAddress(id,addressDTO)).thenReturn(message);
        ResponseEntity responseEntity = controller.updateAddress(id,addressDTO);
        Assertions.assertEquals(message, responseEntity.getMessage());
        Assertions.assertEquals(addressDTO,responseEntity.getData());
    }
    }
