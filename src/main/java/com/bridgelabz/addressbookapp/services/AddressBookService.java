package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressBookService {
    private static final String DATA_ADDED_SUCCESSFULLY = "Data added to address book";
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

       public String addAddress(AddressDTO addressDTO){
           Address address = modelMapper.map(addressDTO, Address.class);
           repository.save(address);
           return DATA_ADDED_SUCCESSFULLY;

       }

       public Address findId(int Id){
           return repository.findById(Id).orElseThrow(EntityNotFoundException::new);
       }
}
