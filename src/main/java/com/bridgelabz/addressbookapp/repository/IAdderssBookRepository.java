package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository implementation of different functions, methods, and other
 * related dependent data types to enable persistence in web
 */
public interface IAdderssBookRepository extends JpaRepository<AddressbookData,Integer> {
}
