package com.bridgelabz.addressbookapp.services;

import com.bridgelabz.addressbookapp.builder.AddressBookBuilder;
import com.bridgelabz.addressbookapp.dto.AddressDTO;
import com.bridgelabz.addressbookapp.entity.Address;
import com.bridgelabz.addressbookapp.repository.AddressBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
@Service
public class AddressBookService {
    private static final String DATA_ADDED_SUCCESSFULLY = "Data added to address book";
    private static final String ADDRESS_UPDATED_SUCCESSFULLY = "Address book data updated successfully";
    private static final String ADDRESS_DELETED_SUCCESSFULLY = "Address deleted successfully";
    @Autowired
    private AddressBookRepository repository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private AddressBookBuilder addressBookBuilder;

    public List<AddressDTO> getallAddress() {
        return repository.findAll().stream()
                .map(addressBookData -> {
                    return modelMapper.map(addressBookData, AddressDTO.class);
                })
                .collect(Collectors.toList());
    }

    public String addAddress(AddressDTO addressDTO) {
        Address address = modelMapper.map(addressDTO, Address.class);
        repository.save(address);
        return DATA_ADDED_SUCCESSFULLY;

    }

    public Address findId(int Id) {
        return repository.findById(Id).orElseThrow(EntityNotFoundException::new);
    }
    public String updateAddress(int id,AddressDTO addressDTO){
        Address address = findId(id);
        Address buildAddressEntity = addressBookBuilder.buildAddressEntity(addressDTO, address);
        repository.save(buildAddressEntity);
        return ADDRESS_UPDATED_SUCCESSFULLY;

    }
    public String deleteAddress(int id){
        Address address = findId(id);
        repository.delete(address);
        return ADDRESS_DELETED_SUCCESSFULLY;
    }
}
