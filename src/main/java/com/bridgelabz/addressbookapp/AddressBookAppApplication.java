package com.bridgelabz.addressbookapp;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Purpose - To simulate Address book application
 *
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 */
@SpringBootApplication
@EnableEncryptableProperties
@Slf4j
public class AddressBookAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressBookAppApplication.class, args);
        log.info("Welcome to address book application");
    }
}
