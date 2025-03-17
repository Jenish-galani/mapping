package com.example.mapping.entities;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class JwtRequest {
    private String name;
    private String password;
}
