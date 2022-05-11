package com.bridgelabz.addressbookapp.model;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "Contacts")
@NoArgsConstructor
public @Data class AddressbookData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "person_id")
    private int personId;

    
    @Column(name = "name")
    private String name;
    private String city;
    private String state;
    private String zipCode;
    @Column(name = "Phone_Number")
    private String phNumber;
    @Column(name = "Email_Id")
    private String email;

    public AddressbookData(AddressbookDTO addressbookDTO) {
        this.updateAddressBookData(addressbookDTO);
    }

    public void updateAddressBookData(AddressbookDTO addressbookDTO) {
        this.personId = personId;
        this.name = addressbookDTO.name;
        this.city = addressbookDTO.city;
        this.state = addressbookDTO.state;
        this.zipCode = addressbookDTO.zipCode;
        this.phNumber = addressbookDTO.phNumber;
        this.email = addressbookDTO.email;
    }
}
