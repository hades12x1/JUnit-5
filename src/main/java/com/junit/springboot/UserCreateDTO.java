package com.junit.springboot;

import lombok.Data;

@Data
public class UserCreateDTO {
    private Long id;
    private String email;
    private String password;
}
