package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import java.util.List;

public interface IAddressBookService {
    List<AddressbookData> getAddressbookData();

    AddressbookData getAddressbookDataById(int personId);

    AddressbookData createAddressbooData(AddressbookDTO addressbookDTO);

    AddressbookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO);

    void deleteAddressbooData(int personId);

    AddressbookData getContactByName(String name);

    List<AddressbookData> getByCity(String city);

    List<AddressbookData> getByState(String state);

    List<AddressbookData> getByName(String zipCode);

    List<AddressbookData> getByZipCode(String zipCode);

    List<AddressbookData> getByEmail(String email);

    List<AddressbookData> getByNumber(String phNumber);

    List<AddressbookData> sortByCity();
}
