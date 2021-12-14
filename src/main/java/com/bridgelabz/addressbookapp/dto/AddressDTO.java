package com.bridgelabz.addressbookapp.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class AddressDTO {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[a-zA_Z]{2,}",message = "Name should start with capital letter " +
            "and should name minimum 3 letters")
    private String name;
    @NotNull
    private String address;
    @NotNull
    @Min(value = 3,message = "City name should be minimum 3 letters")
    private String city;
    @NotNull
    @Pattern(regexp = "^[a-zA-Z\\s-]{3,}+$",message = "State should not contain numbers")
    private String state;
    @NotNull
    @Pattern(regexp = "^[986]{1}[0-9]{9}$",message = "Phone Number should contain 10 digits" +
            " and start with either 9,8 or 6")
    private String phoneNumber;
    @NotNull
    @Pattern(regexp = "^[0-9]{6}",message = "Zip should contain 6 digits")
    private String zip;
}
