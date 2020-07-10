package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Less20Test {

    private Less20 test;

    @Before
    public void setUp() throws Exception {
        test = new Less20();
    }

    @Test
    public void notWithinTwoOfMultipleOf20() {
        // edge cases
        assertEquals(false, test.isLessThanMultipleOf20(17));
        assertEquals(false, test.isLessThanMultipleOf20(23));
    }

    @Test
    public void oneLessThanMultipleOf20() {
        assertEquals(true, test.isLessThanMultipleOf20(39));
        assertEquals(false, test.isLessThanMultipleOf20(37));
    }

    @Test
    public void twoLessThanMultipleOf20() {
        assertEquals(true, test.isLessThanMultipleOf20(38));
        assertEquals(false, test.isLessThanMultipleOf20(36));
    }

}