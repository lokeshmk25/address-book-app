package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<Address,Integer> {
}
