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

import java.util.ArrayList;
import java.util.List;

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
    void givenaddressDTO_WhenAdded_ShouldResponseEntity() {
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

    @Test
    void givenaddressDTO_WhenDeleted_ShouldResponseEntity() {
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

    @Test
    void givenAddressBookDtos_WhenaddedInRepository_ShouldReturnAddressBook() {
        List<AddressDTO> addressDTOList=new ArrayList<>();
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName("Lokesh");
        addressDTO.setAddress("Richie street");
        addressDTO.setCity("Ambur");
        addressDTO.setState("TamilNadu");
        addressDTO.setZip("635808");
        addressDTO.setPhoneNumber("9876543210");
        addressDTOList.add(addressDTO);
        AddressDTO addressDTO1 = new AddressDTO();
        addressDTO1.setName("Toby");
        addressDTO1.setAddress("Richie street");
        addressDTO1.setCity("Ambur");
        addressDTO1.setState("TamilNadu");
        addressDTO1.setZip("635808");
        addressDTO1.setPhoneNumber("9876543210");
        addressDTOList.add(addressDTO1);

        when(service.getallAddress()).thenReturn(addressDTOList);
        List<AddressDTO> addressDTOs = controller.getallAddress();
        for (int i = 0; i < addressDTOs.size(); i++) {
            Assertions.assertEquals(addressDTOList.get(i).getName(), addressDTOs.get(i).getName());
            Assertions.assertEquals(addressDTOList.get(i).getAddress(), addressDTOs.get(i).getAddress());
            Assertions.assertEquals(addressDTOList.get(i).getCity(), addressDTOs.get(i).getCity());
            Assertions.assertEquals(addressDTOList.get(i).getState(), addressDTOs.get(i).getState());
            Assertions.assertEquals(addressDTOList.get(i).getPhoneNumber(), addressDTOs.get(i).getPhoneNumber());
            Assertions.assertEquals(addressDTOList.get(i).getZip(), addressDTOs.get(i).getZip());
        }


    }
}
