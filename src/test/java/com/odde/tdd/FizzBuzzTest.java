package com.odde.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {
    @Test
    public void testNormalNumbers() {
        assertEquals("1", new FizzBuzz().play(1) );
    }

    @Test
    public void testMultiplesOf3() {
        assertEquals(FizzBuzz.FIZZ, new FizzBuzz().play(3));
    }

    @Test
    public void testMultiplesOf5() {
        assertEquals(FizzBuzz.BUZZ, new FizzBuzz().play(5));
    }

    @Test
    public void testMultiplesOf15() {
        assertEquals(FizzBuzz.FIZZ_BUZZ, new FizzBuzz().play(15));
    }
}
