package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.entities.Employee;
import com.example.mapping.repositories.AddressRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AddressServiceImplTests {
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void addressFindById() {
        Long testId = 1L;
        Optional<Address> address = addressRepository.findById(testId);
        assertTrue(address.isPresent(), "Address with id : " + testId + "should exist");
    }
}
