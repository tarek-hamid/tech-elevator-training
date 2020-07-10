package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FrontTimesTest {

    private FrontTimes test;

    @Before
    public void setUp() throws Exception {
        test = new FrontTimes();
    }

    @Test
    public void generateString() {
        // Check for blank input
        assertEquals("", test.generateString("", 3));
        // Check if other tests are normal
        assertEquals("ChoChoCho", test.generateString("Chocolate", 3));
        assertEquals("TAR", test.generateString("TAREK", 1));
        assertEquals("", test.generateString("TECHCONNECT", 0));
    }
}