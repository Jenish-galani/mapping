package com.example.mapping.repositories;

import com.example.mapping.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddRepo extends JpaRepository<Address, Long> {
}