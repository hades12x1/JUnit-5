package com.junit;

import com.junit.mockito_demo.DaoDemo;
import com.junit.mockito_demo.ServiceDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class ServiceDemoTest {

    @Test
    void getTicket_ValidIndexAndNotMatchValueLucky_OK() {
        int index = 1;
        DaoDemo daoDemo = Mockito.mock(DaoDemo.class);
        Mockito.when(daoDemo.getData(index)).thenReturn("Nothing");

        ServiceDemo serviceDemo = new ServiceDemo();
        serviceDemo.setDaoDemo(daoDemo);

        List<String> tickets = serviceDemo.getTicket(index);
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, tickets.size()),
                () -> Assertions.assertEquals("Nothing", tickets.get(0))
        );
    }

    @ParameterizedTest(name = "#{index} - Run test with index ticket={0}")
    @ValueSource(ints = {-1, 999})
    void getTicket_InvalidIndex_ThrowIllegalArgumentException(int index) {
        DaoDemo daoDemo = Mockito.mock(DaoDemo.class);
        Mockito.when(daoDemo.getData(index)).thenThrow(IllegalArgumentException.class);

        ServiceDemo serviceDemo = new ServiceDemo();
        serviceDemo.setDaoDemo(daoDemo);

        Assertions.assertThrows(IllegalArgumentException.class, () -> serviceDemo.getTicket(index));
    }

    @Test
    void getTicket_IsLuckyTicket_OK() {
        int index = -1;
        List<String> luckyTickets = Arrays.asList("999$", "888$");
        DaoDemo daoDemo = Mockito.mock(DaoDemo.class);
        Mockito.when(daoDemo.getData(index)).thenReturn("LUCKY");
        Mockito.when(daoDemo.getListLucky()).thenReturn(luckyTickets);

        ServiceDemo serviceDemo = new ServiceDemo();
        serviceDemo.setDaoDemo(daoDemo);

        Assertions.assertEquals(luckyTickets, serviceDemo.getTicket(index));
    }
}
