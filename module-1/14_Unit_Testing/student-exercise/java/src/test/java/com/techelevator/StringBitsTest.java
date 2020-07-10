package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringBitsTest {

    private StringBits test;

    @Before
    public void setUp() throws Exception {
        test = new StringBits();
    }

    @Test
    public void checkForNullInput() {
        assertEquals("", test.getBits(null));
    }

    @Test
    public void checkForRegularOutput() {
        assertEquals("H", test.getBits("He"));
        assertEquals("HloWrd", test.getBits("Hello World"));
    }


}