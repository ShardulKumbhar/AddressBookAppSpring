package com.bridgelabz.addressbookapp.dto;




import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public @Data class AddressbookDTO {

    @NotNull(message = "ERROR: Name cannot be null!!!")
    @NotEmpty(message = "ERROR: Name cannot be empty!")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid name!")
    public String name;
    @NotNull(message = "ERROR: Please Enter The City!!!")
    @NotEmpty(message = "ERROR: City Cannot be empty!!!!")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid City(i,e. Start with Capital Letter)!")
    public  String city;
    @NotNull(message = "ERROR: Please Enter The State!!!")
    @NotEmpty(message = "ERROR: State Cannot be empty!!!!")
    @Pattern(regexp = "^([A-Z][a-zA-Z]{2,}[ ]?)+$", message = "ERROR: Please enter a valid State(i,e. Start with Capital Letter)!")
    public  String state;
    @NotNull(message = "ERROR: ZipCode Cannot be null!!")
    @Min(value = 100000, message = "ERROR: Please enter 6 Zip Code")
    public  String zipCode;

    @NotNull(message = "ERROR: phone number cannot be null!!")
    @Min(value = 1000000000, message = "ERROR: Please enter 10 digit number")
    public String phNumber;
    @NotNull(message = "ERROR: Please Enter The Email!!!")
    @NotEmpty(message = "ERROR: Email Cannot be empty!!!!")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "ERROR: Please enter a valid Email-Id(i,e. com.chandra@gmail.com)!")
    public String email;
}
