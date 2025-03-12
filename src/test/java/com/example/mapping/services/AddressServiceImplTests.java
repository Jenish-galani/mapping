package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.repositories.AddressRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceImplTests {
    @Mock
    private AddressRepository addRepo;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Test
    public void findByIdTest() {
        Optional<Address> address = Optional.of(new Address());
        when(addRepo.findById(1L)).thenReturn(address);
        Optional<Address> result = addressService.findById(1L);
        assertEquals(address, result);
    }

    @Test
    public void saveTest() {
        Address address = new Address();
        address.setAddressId(1L);


        when(addRepo.save(address)).thenReturn(address);  // Mock repository save method

        Address savedAddress = addressService.save(address);  // Call actual service method

        assertNotNull(savedAddress);  // Ensure the object is not null
        assertEquals(1L, savedAddress.getAddressId());  // Validate saved data
    }
}
