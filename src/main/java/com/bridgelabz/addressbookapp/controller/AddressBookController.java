package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.services.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping({"","/"})
    public String greetings(){
        return "Welcome to AddressBook application";
    }

    @RequestMapping("/getall")
    public List<AddressDTO> getallAddress(){
        return addressBookService.getallAddress();
    }
}
