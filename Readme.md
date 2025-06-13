# JUnit  Testing Documentation

## What is JUnit?

JUnit is a popular unit testing framework for Java. It helps you test individual methods to verify correctness, catch bugs early, and support clean code practices.
Getting Started
Add the following Maven dependency to use JUnit  with Spring Boot:

```xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-test</artifactId>
<scope>test</scope>
</dependency>
```


This includes:

• JUnit  (Jupiter)

• Mockito

• Hamcrest

• Spring TestContext

Sample Service Class

Below is a basic arithmetic service class for demonstration:
```Java

package com.hasnat.calculator;

public class ArithmeticService {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed");
        return (double) a / b;
    }

    public int modulus(int a, int b) {
        if (b == 0) throw new ArithmeticException("Modulus by zero not allowed");
        return a % b;
    }
}
```
Test Class
### JUnit  test class for ArithmeticService:
```Java
package com.hasnat.calculator;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
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
    @DisplayName("Test Modulus")
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

```

### Common JUnit Annotations

@Test – Marks a method as a test case. JUnit will execute this method during the test run.

@BeforeEach – Runs before every test method. Used to initialize or reset objects needed for each test.

@AfterEach – Runs after every test method. Used to clean up resources or reset states after each test.

@BeforeAll – Runs once before all test methods in the class. Must be static unless using @TestInstance(PER_CLASS).

@AfterAll – Runs once after all test methods have run. Must be static unless using @TestInstance(PER_CLASS).

@Disabled – Temporarily disables the test method or class. Skipped during execution.

@DisplayName – Adds a custom, human-readable name for the test or test class.

### Common JUnit Assertions

assertEquals(expected, actual) – Checks if two values are equal. Test fails if expected != actual.

assertNotEquals(unexpected, actual) – Checks if two values are not equal. Test fails if unexpected == actual.

assertTrue(condition) – Passes if the condition is true. Used to verify boolean logic.

assertFalse(condition) – Passes if the condition is false. Useful for negative cases.

assertNull(object) – Passes if the object is null. Checks that a variable was not initialized.

assertNotNull(object) – Passes if the object is not null. Ensures a result or object is returned.

assertThrows(Exception.class, () -> {...}) – Asserts that the code block throws the specified exception. Used for error handling tests.