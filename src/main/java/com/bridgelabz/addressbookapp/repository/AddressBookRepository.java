package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
public interface AddressBookRepository extends JpaRepository<Address,Integer> {
}
