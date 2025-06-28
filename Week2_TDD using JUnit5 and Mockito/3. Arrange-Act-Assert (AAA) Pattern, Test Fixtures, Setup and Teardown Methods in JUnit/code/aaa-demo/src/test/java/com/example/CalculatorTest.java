package com.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        // Arrange: Initialize resources
        calculator = new Calculator();
        System.out.println("Setup before test");
    }

    @AfterEach
    public void tearDown() {
        // Cleanup after test
        System.out.println("Teardown after test");
    }

    @Test
    public void testAddition() {
        // Act
        int result = calculator.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        int result = calculator.subtract(5, 3);

        // Assert
        assertEquals(2, result);
    }
}
