package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonStartTest {

    private NonStart test;

    @Before
    public void setUp() throws Exception {
        test = new NonStart();
    }

    @Test
    public void getPartialStringEmptyString() {
        assertEquals("ello", test.getPartialString("", "Hello"));
        assertEquals("each", test.getPartialString("Peach", ""));
    }

    @Test
    public void getPartialStringNonEmptyStrings() {
        assertEquals("orldello", test.getPartialString("World", "Hello"));
        assertEquals("eachpple", test.getPartialString("Peach", "Apple"));
    }
}