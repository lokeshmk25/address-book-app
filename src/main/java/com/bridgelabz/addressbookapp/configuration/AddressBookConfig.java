package com.bridgelabz.addressbookapp.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LOKESH
 * @version 0.0.1-SNAPSHOT
 * @since 10-12-21
 *
 */
@Configuration
public class AddressBookConfig {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
