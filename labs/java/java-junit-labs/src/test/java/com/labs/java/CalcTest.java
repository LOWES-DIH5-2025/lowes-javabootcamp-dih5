package com.labs.java;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CalcTest {

    @BeforeAll
    public static void initialize() {
        System.out.println("[@BeforeAll] Initializing tests for Calc class");
    }

    @BeforeEach
    public void setup() {
        System.out.println("[@BeforeEach] Setting up before each test");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("[@AfterEach] Cleaning up after each test");
    }

    @AfterAll
    public static void cleanup() {
        System.out.println("[@AfterAll] Cleaning up after tests for Calc class");
    }

    @Test
    public void testAdd() {
        System.out.println("Running testAdd");
        Calc calc = new Calc();
        int result = calc.add(2, 3);
        assertEquals(5, result, "2 + 3 should equal 5");
    }

    @Test
    public void testSubtract() {
        System.out.println("Running testSubtract");
        Calc calc = new Calc();
        int result = calc.subtract(5, 3);
        assertEquals(2, result, "5 - 3 should equal 2");
    }

    @Test
    public void testMultiply() {
        System.out.println("Running testMultiply");
        Calc calc = new Calc();
        int result = calc.multiply(2, 3);
        assertEquals(6, result, "2 * 3 should equal 6");
    }

    @Test
    public void testDivide() {
        System.out.println("Running testDivide");
        Calc calc = new Calc();
        int result = calc.divide(6, 3);
        assertEquals(2, result, "6 / 3 should equal 2");
    }

    @Test
    public void testDivideByZero() {
        System.out.println("Running testDivideByZero");
        Calc calc = new Calc();
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calc.divide(6, 0);
        });
        assertEquals("Division by zero is not allowed", exception.getMessage(), "Division by zero should throw ArithmeticException");
    }
}
