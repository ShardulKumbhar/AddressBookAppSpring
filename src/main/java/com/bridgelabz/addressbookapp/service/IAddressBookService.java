package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import dto.AddressbookDTO;

import java.util.List;

public interface IAddressBookService {
    List<AddressbookData> getAddressbookData();

    AddressbookData getAddressbookDataById(int personId);

    AddressbookData createAddressbooData(AddressbookDTO addressbookDTO);

    AddressbookData updateAddressbookData(int personId, AddressbookDTO addressbookDTO);

    void deleteAddressbooData(int personId);
}