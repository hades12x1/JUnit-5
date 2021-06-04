package com.junit.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class ControllerDemo {

    /*
        1. POST http://localhost:8080/account
        Content-Type: application/json
        {
          "email" :"chuyenns@gmail.com",
          "password" : "aaaa33aaaa@"
        }
        ###
        2. GET http://localhost:8080/account/100
    */

    @Autowired
    private ServiceInterface service;

    @PostMapping
    public ResponseEntity<UserStatusDTO> createAccount(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(service.createAccount(userCreateDTO));
    }

    @GetMapping("/{bannerId}")
    public String getBanner(@PathVariable(name = "bannerId") Long bannerId) {
        return service.getBanner(bannerId);
    }
}
