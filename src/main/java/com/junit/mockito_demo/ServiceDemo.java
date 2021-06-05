package com.junit.mockito_demo;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class ServiceDemo {
    private DaoDemo daoDemo;

    public List<String> getTicket(int index) {
        String data = daoDemo.getData(index);
        if("LUCKY".equals(data)) {
            return daoDemo.getListLucky();
        }
        return Collections.singletonList(data);
    }
}
