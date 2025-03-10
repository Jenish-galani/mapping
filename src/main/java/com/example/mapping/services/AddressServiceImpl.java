package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{
    @Autowired
    private AddressRepository addRepo;

    @Override
    public Address save(Address address) {
        return addRepo.save(address);
    }

    @Override
    public Optional<Address> findById(Long id) {
        return addRepo.findById(id);
    }
}

