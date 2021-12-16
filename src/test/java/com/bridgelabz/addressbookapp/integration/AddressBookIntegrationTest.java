package com.bridgelabz.addressbookapp.integration;

import com.bridgelabz.addressbookapp.controller.AddressBookController;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.services.AddressBookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest(AddressBookController.class)
public class AddressBookIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AddressBookService addressBookService;
    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void getAllAddressTest() throws Exception {
        when(addressBookService.getallAddress()).thenReturn(new ArrayList<>());
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/addressbook/getall"))
                .andExpect(status().isOk());
    }

    @Test
    void addAddressTest() throws Exception{
        when(addressBookService.addAddress(any())).thenReturn("success");
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setName("Lokesh");
        addressDTO.setAddress("Richie street");
        addressDTO.setCity("Ambur");
        addressDTO.setState("TamilNadu");
        addressDTO.setZip("635808");
        addressDTO.setPhoneNumber("9876543210");
        String jsonRequest = objectMapper.writeValueAsString(addressDTO);
        when(addressBookService.addAddress(any())).thenReturn("success");
        mockMvc.perform(MockMvcRequestBuilders.post("/addressbook/create")
                        .content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}
