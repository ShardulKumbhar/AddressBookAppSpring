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
public interface IAdderssBookRepository extends JpaRepository<AddressbookData,Integer> {

    @Query(value = "SELECT * FROM Contacts WHERE CITY = :city", nativeQuery = true)
    public List<AddressbookData> getByCity(@Param(value = "city") String city);
}
