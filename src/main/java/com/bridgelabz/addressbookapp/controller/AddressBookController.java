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

@RestController
@RequestMapping("/addressBook")
@Slf4j
public class AddressBookController {


    /**
     * Autowiring to Interface
     */
    @Autowired
    IAddressBookService addressbooService;

    /**
     * This method will call the service layer to insert a new record into the database.
     * It will return an error message if is has Exception
     * HTTP Method to create Data
     * http://localhost:8080/addressBook/create
     *
     * @param addressbookDTO
     * @return
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        log.debug("AddressBook DTO: " + addressbookDTO.toString());
        AddressbookData addressbookData = addressbooService.createAddressbooData(addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created Employee Payroll Data successfully ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * HTTP Method to get All data
     * http://localhost:8080/addressBook/get
     *
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
     *
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
     *
     * @param personId
     * @param addressbookDTO
     * @return
     */
    @PutMapping("/update/{personId}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@PathVariable int personId, @Valid @RequestBody AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = addressbooService.updateAddressbookData(personId, addressbookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated Employee Payroll data successfully ", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Http Method to delete data by ID
     * http://localhost:8080/addressBook/delete/1
     *
     * @param personId
     * @return
     */
    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("personId") int personId) {
        addressbooService.deleteAddressbooData(personId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted data successfully", "person id: " + personId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }


    /***************************************Custom query **************************************************/
    /************** Search by ******* Cit | state | name | zipCode |email | phoneNumber | SortbyCity ********/


    /**
     * htttp method to get by city name
     * http://localhost:8080/addressBook/get/city/pune
     *
     * @param city
     * @return
     */
    @GetMapping("/get/city/{city}")
    public ResponseEntity<ResponseDTO> getByCity(@PathVariable("city") String city) {
        List<AddressbookData> addressbookData = addressbooService.getByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get call by city success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to get by state name
     * http://localhost:8080/addressBook/get/state/karnatak
     *
     * @param state
     * @return
     */
    @GetMapping("/get/state/{state}")
    public ResponseEntity<ResponseDTO> getByState(@PathVariable("state") String state) {
        List<AddressbookData> addressbookData = addressbooService.getByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get call by state success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to get by state name
     * http://localhost:8080/addressBook/get/name/name
     *
     * @param name
     * @return
     */
    @GetMapping("/get/name/{name}")
    public ResponseEntity<ResponseDTO> getByName(@PathVariable("name") String name) {
        List<AddressbookData> addressbookData = addressbooService.getByName(name);
        ResponseDTO responseDTO = new ResponseDTO("Get call by Name success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to get by zipCode
     *
     * @param zipCode
     * @return
     */
    @GetMapping("/get/zipCode/{zipCode}")
    public ResponseEntity<ResponseDTO> getByZipCode(@PathVariable("zipCode") String zipCode) {
        List<AddressbookData> addressbookData = addressbooService.getByZipCode(zipCode);
        ResponseDTO responseDTO = new ResponseDTO("Get call by zipcode success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to get by email
     *
     * @param email
     * @return
     */
    @GetMapping("/get/email/{email}")
    public ResponseEntity<ResponseDTO> getByEmail(@PathVariable("email") String email) {
        List<AddressbookData> addressbookData = addressbooService.getByEmail(email);
        ResponseDTO responseDTO = new ResponseDTO("Get call by email success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to get by phone number
     *
     * @param phNumber
     * @return
     */
    @GetMapping("/get/number/{phNumber}")
    public ResponseEntity<ResponseDTO> getByNumber(@PathVariable("phNumber") String phNumber) {
        List<AddressbookData> addressbookData = addressbooService.getByNumber(phNumber);
        ResponseDTO responseDTO = new ResponseDTO("Get call by phone number success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * htttp method to sort by city
     *
     * @return
     */
    @GetMapping("/get/city")
    public ResponseEntity<ResponseDTO> sortByCity() {
        List<AddressbookData> addressbookData = addressbooService.sortByCity();
        ResponseDTO responseDTO = new ResponseDTO("Sorted by city name  success", addressbookData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
