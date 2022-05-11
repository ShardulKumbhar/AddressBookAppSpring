package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class AddressbookData {

    private int personId;
    private String name;
    private String city;
    private String state;
    private String zipCode;
    private String phNumber;
    private String email;

    public AddressbookData(int personId, AddressbookDTO addressbookDTO) {
        this.personId = personId;
        this.name = addressbookDTO.name;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zipCode = addressbookDTO.zipCode;
        this.phNumber = addressbookDTO.phNumber;
        this.email = addressbookDTO.email;
    }
}
