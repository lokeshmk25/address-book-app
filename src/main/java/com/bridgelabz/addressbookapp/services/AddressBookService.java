package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
       @Autowired
      private AddressBookRepository repository;
       @Autowired
      private ModelMapper modelMapper;

       public List<AddressDTO> getallAddress(){
           return repository.findAll().stream()
                   .map(addressBookData -> {
                       return modelMapper.map(addressBookData, AddressDTO.class);
                   })
                   .collect(Collectors.toList());
       }
}
