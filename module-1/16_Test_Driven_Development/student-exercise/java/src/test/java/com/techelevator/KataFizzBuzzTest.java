package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataFizzBuzzTest {

    private KataFizzBuzz test;

    @Before
    public void setUp() throws Exception {
        test = new KataFizzBuzz();
    }

    @Test
    public void isDivisibleByThree() {
        assertEquals("Fizz.", test.fizzBuzz(9));
    }

    @Test
    public void isDivisibleByFive() {
        assertEquals("Buzz.", test.fizzBuzz(10));
    }

    @Test
    public void isDivisibleByFiveAndThree() {
        assertEquals("FizzBuzz.", test.fizzBuzz(15));
    }

    @Test
    public void convertToStringOneToHundred() {
        assertEquals("83", test.fizzBuzz(83));
    }

    @Test
    public void convertToEmptyString() {
        assertEquals("", test.fizzBuzz(150));
    }

    @Test
    public void divisibleOrContainsThreeAndFive() {
        assertEquals("", test.fizzBuzz(350));
    }





}
