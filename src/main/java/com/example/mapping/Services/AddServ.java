package com.example.mapping.Services;

import com.example.mapping.Entities.Address;
import com.example.mapping.Repositories.AddRepo;
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

