package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.dto.AddressbookDTO;
import com.bridgelabz.addressbookapp.dto.ResponseDTO;
import com.bridgelabz.addressbookapp.model.AddressbookData;
import com.bridgelabz.addressbookapp.service.IAddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {


    /**
     * Autowiring to Interface
     */
    @Autowired
    IAddressBookService addressbooService;

    /**
     * HTTP Method to create Data
     * http://localhost:8080/addressBook/create
     * @param addressbookDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        log.debug("AddressBook DTO: "+addressbookDTO.toString());
        AddressbookData addressbookData = addressbooService.createAddressbooData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data successfully ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method to get All data
     * http://localhost:8080/addressBook/get
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        List<AddressbookData> addressbookDataList = addressbooService.getAddressbookData();
        ResponseDTO responseDTO = new ResponseDTO("Get call success", addressbookDataList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * HTTP Request to Get Data by ID
     * http://localhost:8080/addressBook/get/1
     * @param personId
     * @return
     */
    @GetMapping("/get/{personId}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable(value = "personId") int personId) {
        AddressbookData addressbookData = addressbooService.getAddressbookDataById(personId);
        ResponseDTO responseDTO = new ResponseDTO("Get Call Success for id is successfully", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Http Method to update data by ID
     * http://localhost:8080/addressBook/update/1
     * @param personId
     * @param addressbookDTO
     * @return
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId,@Valid @RequestBody AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = addressbooService.updateAddressbookData(personId, addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll data successfully ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Http Method to delete data by ID
     * http://localhost:8080/addressBook/delete/1
     * @param personId
     * @return
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbooService.deleteAddressbooData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", "person id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
