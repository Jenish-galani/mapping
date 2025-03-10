package com.example.mapping.services;

import com.example.mapping.entities.Address;
import com.example.mapping.repositories.AddRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.springframework.stereotype.Service;

@Service
public class AddServ {
    @Autowired
    private AddRepo addRepo;

    public Address save(Address address) {
        return addRepo.save(address);
    }
}

