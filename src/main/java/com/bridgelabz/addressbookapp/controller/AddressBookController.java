package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.services.AddressBookService;
import com.bridgelabz.addressbookapp.entity.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/addressbook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    @RequestMapping({"","/"})
    public String greetings(){
        return "Welcome to AddressBook application";
    }

    @GetMapping(value = "/getall")
    public List<AddressDTO> getallAddress(){
        return addressBookService.getallAddress();
    }
    @GetMapping(value = "/get/{id}")
    public ResponseEntity getAddress(@PathVariable int id){
        Address addressId = addressBookService.findId(id);
        return new ResponseEntity("Id is Found",addressId,HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity addAddress(@Valid@RequestBody AddressDTO addressDTO){
       String message = addressBookService.addAddress(addressDTO);
       return new ResponseEntity(message,addressDTO,HttpStatus.OK);
    }
}
