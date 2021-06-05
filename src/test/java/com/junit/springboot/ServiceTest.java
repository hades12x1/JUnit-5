package com.junit.springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {

    @Mock
    private Dao dao;

    @InjectMocks
    private ServiceImpl service;

    @Test
    void getBanner_NullBannerId_ThrowIllegalArgumentException() {
        IllegalArgumentException illegalArgumentEx = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.getBanner(null)
        );
        // Todo validate details...
    }


}
