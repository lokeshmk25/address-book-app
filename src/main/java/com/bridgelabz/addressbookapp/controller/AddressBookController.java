package com.bridgelabz.addressbookapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/addressbook")
public class AddressBookController {

    @RequestMapping({"","/"})
    public String greetings(){
        return "Welcome to AddressBook application";
    }
}
