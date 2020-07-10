package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Lucky13Test {

    private Lucky13 test;
    int[] falseArray = {0, 1, 2};
    int[] trueArray = {2, 4, 5};
    int[] anotherTrueArray = {-1, -2, -3};


    @Before
    public void setUp() throws Exception {
        test = new Lucky13();
    }

    @Test
    public void getLucky() {
        assertEquals(true, test.getLucky(trueArray));
        assertEquals(false, test.getLucky(falseArray));
        assertEquals(true, test.getLucky(anotherTrueArray));
    }
}