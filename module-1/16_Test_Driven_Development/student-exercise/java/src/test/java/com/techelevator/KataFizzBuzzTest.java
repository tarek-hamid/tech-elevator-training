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

}
