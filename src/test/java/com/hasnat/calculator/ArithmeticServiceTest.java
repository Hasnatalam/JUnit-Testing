package com.hasnat.calculator;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) // To allow non-static @BeforeAll/@AfterAll
class ArithmeticServiceTest {

    private ArithmeticService service;

    @BeforeAll
    void beforeAllTests() {
        System.out.println("Running before all test methods.");
    }

    @AfterAll
    void afterAllTests() {
        System.out.println("All tests finished.");
    }

    @BeforeEach
    void setUp() {
        service = new ArithmeticService();
        System.out.println("Setup before each test");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Clean up after each test");
    }

    @Test
    @DisplayName("Test Addition")
    void testAdd() {
        assertEquals(7, service.add(3, 4));
    }

    @Test
    @DisplayName("Test Subtraction")
    void testSubtract() {
        assertEquals(2, service.subtract(5, 3));
    }

    @Test
    @DisplayName("Test Multiplication")
    void testMultiply() {
        assertEquals(20, service.multiply(4, 5));
    }

    @Test
    @DisplayName("Test Division")
    void testDivide() {
        assertEquals(2.0, service.divide(10, 5));
    }

    @Test
    @DisplayName("Test Division by Zero")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> service.divide(10, 0));
    }

    @Test
    @DisplayName("% Test Modulus")
    void testModulus() {
        assertEquals(1, service.modulus(10, 3));
    }

    @Test
    @DisplayName("Test Modulus by Zero")
    void testModulusByZero() {
        assertThrows(ArithmeticException.class, () -> service.modulus(10, 0));
    }

    @Test
    @Disabled("This test is temporarily disabled")
    @DisplayName("Disabled Test Example")
    void disabledTest() {
        assertEquals(100, service.add(50, 50));
    }
}
