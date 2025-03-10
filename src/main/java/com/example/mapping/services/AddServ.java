package com.example.mapping.services;

import com.example.mapping.entities.Address;

import java.util.Optional;

public interface AddServ {
    Address save(Address address);
    Optional<Address> findById(Long id);
}
