package com.odde.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testFizzBuzz(){
        assertEquals("1", FizzBuzz.report(1));
        assertEquals("Fizz", FizzBuzz.report(3));
        assertEquals("Buzz", FizzBuzz.report(5));
        assertEquals("FizzBuzz", FizzBuzz.report(15));
        assertEquals("FizzBuzz", FizzBuzz.report(30));
        assertEquals("31", FizzBuzz.report(31));
    }
}
