package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * JpaRepository implementation of different functions, methods, and other
 * related dependent data types to enable persistence in web
 */
public interface IAdderssBookRepository extends JpaRepository<AddressbookData, Integer> {

    /**
     * Custom query to search the table for an addressBook Records record to search by
     * city | name| state |phone number | zip code |
     * sort by city
     */
    @Query(value = "SELECT * FROM Contacts WHERE CITY = :city", nativeQuery = true)
    public List<AddressbookData> getByCity(@Param(value = "city") String city);

    @Query(value = "SELECT * FROM Contacts WHERE State = :state", nativeQuery = true)
    public List<AddressbookData> getByState(@Param(value = "state") String state);

    @Query(value = "SELECT * FROM Contacts WHERE Name = :name", nativeQuery = true)
    public List<AddressbookData> getByName(@Param(value = "name") String name);

    @Query(value = "SELECT * FROM Contacts WHERE zip_code = :zipCode", nativeQuery = true)
    public List<AddressbookData> getByZipCode(@Param(value = "zipCode") String zipCode);

    @Query(value = "SELECT * FROM Contacts WHERE email_id = :email", nativeQuery = true)
    public List<AddressbookData> getByEmail(@Param(value = "email") String email);

    @Query(value = "SELECT * FROM Contacts WHERE phone_number = :phNumber", nativeQuery = true)
    public List<AddressbookData> getByNumber(@Param(value = "phNumber") String phNumber);

    @Query(value = "SELECT * FROM Contacts ORDER BY city", nativeQuery = true)
    public List<AddressbookData> sortByCity();
}
