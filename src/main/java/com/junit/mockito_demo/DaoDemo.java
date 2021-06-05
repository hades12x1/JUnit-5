package com.junit.mockito_demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DaoDemo {

    private final List<String> DATA = Arrays.asList("10$", "300$", "50$", "100$", "LUCKY");

    public String getData(int index) {
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            System.out.println("Error sleep method...");
        }
        if(index < 0 || index >= DATA.size()) {
            throw new IllegalArgumentException("Invalid param...");
        }
        return DATA.get(index);
    }

    public List<String> getListLucky() {
        int indexLucky = DATA.indexOf("LUCKY");
        if(indexLucky == 0) {
            return Collections.singletonList(DATA.get(1));
        }
        if(indexLucky == DATA.size() - 1) {
            return Collections.singletonList(DATA.get(DATA.size() - 2));
        }
        return Arrays.asList(DATA.get(indexLucky -1), DATA.get(indexLucky + 1));
    }
}
