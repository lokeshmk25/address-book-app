package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.services.AddressBookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class AddressBookControllerTest {
    @InjectMocks
    private AddressBookController controller;
    @Mock
    private AddressBookService service;

    @Test
    void givenGreetingsMethodCalled_ShouldReturnResponseEntity() {
        String message="Welcome to AddressBook application";
        String greetings = controller.greetings();
        Assertions.assertEquals(message,greetings);
    }
}
