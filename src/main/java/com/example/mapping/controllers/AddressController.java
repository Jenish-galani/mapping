package com.example.mapping.controllers;

import com.example.mapping.entities.Address;
import com.example.mapping.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {
    @Autowired
    private AddressService addServ;

    @PostMapping("saveAddress")
    public Address save(@RequestBody Address address) {
        return addServ.save(address);
    }

    @GetMapping("find/{id}")
    public Optional<Address> findById(@PathVariable Long id) {
        return addServ.findById(id);
    }
}

