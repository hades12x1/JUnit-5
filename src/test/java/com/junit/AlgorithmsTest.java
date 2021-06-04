package com.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AlgorithmsTest {
    private final Algorithms algorithms = new Algorithms();

    @BeforeAll
    static void setup() {
        System.out.println("Settup...");
    }

    @AfterAll
    static void clear() {
        System.out.println("Clear data....");
    }

    @BeforeEach
    void runBeforeEachTest() {
        System.out.println("Run before earch Testcase.");
    }

    @Test
    @DisplayName("Checking for small numbers")
    void checkFactorialForSmallNumbers() {
       Assertions.assertAll(
                () -> Assertions.assertEquals(1, algorithms.factorial(0)),
                () -> Assertions.assertEquals(6, algorithms.factorial(3)),
                () -> Assertions.assertEquals(24, algorithms.factorial(4))
        );
        Assertions.assertTrue(algorithms.factorial(50) < 0);
    }

    @Test
    void checkExceptionForNegativeArg() {
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, () -> algorithms.fact(-1));
        Assertions.assertEquals("Argument must be positive", ex.getMessage());
    }

    @Test
    @Disabled("Disable until demo")
    void timeoutExceeded() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(200));
    }

    @ParameterizedTest(name = "{0} is prime and less than 20")
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19})
    void valueIsPrime(int arg) {
        assertTrue(Algorithms.isPrime(arg));
    }

    @Test
    @Order(3)
    void testOrder3() {
        System.out.println("testOrder3");
    }

    @Test
    @Order(2)
    void testOrder2() {
        System.out.println("testOrder2");
    }

    @Test
    @Order(4)
    void testOrder4() {
        System.out.println("testOrder4");
    }
}
