package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.exception.AddressBookException;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.repository.IAdderssBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

import java.util.List;

@Service
@Slf4j
public class AddressBookServiceImpl implements IAddressBookService {

    @Autowired
    private IAdderssBookRepository addressBookRepository;
    @Override
    public AddressbookData createAddressbooData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = new AddressbookData(addressbookDTO);
        log.debug("Person Data: "+addressbookData.toString());
        return addressBookRepository.save(addressbookData);
    }

    @Override
    public List<AddressbookData> getAddressbookData() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressbookData getAddressbookDataById(int personId) {
        log.info("Getting AddressBook Data By ID");
        return addressBookRepository.findById(personId)
                .orElseThrow(() -> new AddressBookException(("Person WIth personId "+personId+" does not exist." )));
    }

    @Override
    public AddressbookData updateAddressbookData(int personId,@Valid AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = this.getAddressbookDataById((personId));
        addressbookData.updateAddressBookData(addressbookDTO);
        return addressBookRepository.save(addressbookData);
    }

    @Override
    public void deleteAddressbooData(int personId) {
       AddressbookData addressbookData = this.getAddressbookDataById(personId);
       addressBookRepository.delete(addressbookData);
        }
}

