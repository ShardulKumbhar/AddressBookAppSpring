package com.bridgelabz.addressbookapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class AddressbookAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(AddressbookAppApplication.class, args);
		System.out.println("***********Welcome to Addressbook App*************");
		log.info("AddressBook app started");
	}

}
