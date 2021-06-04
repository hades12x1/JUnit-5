package com.junit.springboot;

interface ServiceInterface {
    UserStatusDTO createAccount(UserCreateDTO userCreateDTO);

    String getBanner(Long banner);
}
