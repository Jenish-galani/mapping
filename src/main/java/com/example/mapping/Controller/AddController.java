package com.example.mapping.Controller;

import com.example.mapping.Entities.Address;
import com.example.mapping.Services.AddServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddController {
    @Autowired
    private AddServ addServ;

    @PostMapping("saveAddress")
    public String save(@RequestBody Address address) {
        addServ.save(address);
        return "Address saved successfully";
    }

    @GetMapping("find/{id}")
    public Optional<Address> findById(@PathVariable Long id) {
        return addServ.findById(id);
    }
}

