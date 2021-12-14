package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressBookService {
       @Autowired
      private AddressBookRepository repository;
       @Autowired
      private ModelMapper modelMapper;
}
