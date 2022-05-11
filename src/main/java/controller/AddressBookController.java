package controller;

import dto.AddressbookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addBook")
public class AddressBookController {
    /**
     * Various Http methods
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity<String> getAddressbookData() {
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }

    @GetMapping("/get/{personId}")
    public ResponseEntity<String> getAddressbookData(@PathVariable(value = "personId") int personId) {
        return new ResponseEntity<String>("Get Call Success for id: " + personId, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        return new ResponseEntity<String>("Created Employee Payroll Data for: " + addressbookDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        return new ResponseEntity<String>("Updated Employee Payroll Data for: " + addressbookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{personId}")
    public ResponseEntity<String> deleteAddressbookData(@PathVariable("personId") int personId) {
        return new ResponseEntity<String>("Delete Call Success for id: " + personId, HttpStatus.OK);
    }

}