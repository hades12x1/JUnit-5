package com.junit.springboot;

import lombok.Data;

@Data
public class UserStatusDTO {
    private String email;
    private Long userId;
    private Integer status;
}
