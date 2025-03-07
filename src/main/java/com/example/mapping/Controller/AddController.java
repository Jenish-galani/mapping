package com.example.mapping.Controller;

import com.example.mapping.Entities.Address;
import com.example.mapping.Services.AddServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

