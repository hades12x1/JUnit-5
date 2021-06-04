package com.junit.springboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Dao {

    List<UserCreateDTO> userCreateDTOS = new ArrayList<>();

    List<String> emailRegistered = Arrays.asList(
            "abc@gmail.com",
            "3van9nghin@gmail.com",
            "codota@gmail.com"
    );

    public boolean existEmail(String email) {
        return emailRegistered.contains(email);
    }

    public Long saveAndGetId(UserCreateDTO userCreateDTO) {
        Long idRecord = 1L;
        userCreateDTO.setId(idRecord);
        userCreateDTOS.add(userCreateDTO);
        return idRecord;
    }
}
