package com.junit.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ServiceImpl implements ServiceInterface {

    @Autowired
    private Dao dao;

    @Override
    public UserStatusDTO createAccount(UserCreateDTO userCreateDTO) {
        boolean existEmail = dao.existEmail(userCreateDTO.getEmail());
        boolean passwordIsValid = this.checkValidPassword(userCreateDTO.getPassword());

        if(existEmail || !passwordIsValid) {
            UserStatusDTO userStatusDTO = new UserStatusDTO();
            userStatusDTO.setEmail(userCreateDTO.getEmail());
            userStatusDTO.setUserId(-999L);
            userStatusDTO.setStatus(0);
            return userStatusDTO;
        }

        Long idRecord = dao.saveAndGetId(userCreateDTO);
        UserStatusDTO userStatusDTO = new UserStatusDTO();
        userStatusDTO.setEmail(userCreateDTO.getEmail());
        userStatusDTO.setUserId(idRecord);
        userStatusDTO.setStatus(1);
        return userStatusDTO;
    }

    @Override
    public String getBanner(Long bannerId) {
        if(bannerId == null || bannerId <= 0) {
            throw new IllegalArgumentException("Banner Id invalid");
        }
        if(bannerId <= 99) {
            return "Good............";
        }
        return "Bad...........";
    }

    public boolean checkValidPassword(String password) {
        List<String> characterSpecific = Arrays.asList("@", "!", "#", "$");
        List<String> number = Arrays.asList("1", "3", "5", "7");

        if(password == null) {
            return false;
        }
        if(password.length() < 8 || password.length() >  30) {
            return false;
        }
        if(this.notContaintCharactorInList(password, characterSpecific)) {
            return false;
        }
        return !this.notContaintCharactorInList(password, number);
    }

    public boolean notContaintCharactorInList(String value, List<String> characters) {
        if(characters == null) {
            return true;
        }
        for(String character: characters) {
            if(value.contains(character)) {
                return false;
            }
        }
        return true;
    }
}
