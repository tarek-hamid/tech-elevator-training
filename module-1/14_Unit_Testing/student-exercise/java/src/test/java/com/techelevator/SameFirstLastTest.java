package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Same;

import static org.junit.Assert.*;

public class SameFirstLastTest {

    int[] trueArray = {1, 3, 1};
    int[] anotherTrueArray = {1};
    int[] anotherFalseArray = {1, 2, 3};


    private SameFirstLast test;

    @Before
    public void setUp() throws Exception {
        test = new SameFirstLast();
    }

    @Test
    public void checkForNullOutput() {
        assertEquals(false, test.isItTheSame(null));
    }

    @Test
    public void checkForLengthOneInput() {
        assertEquals(true, test.isItTheSame(anotherTrueArray));
    }

    @Test
    public void checkForStandardInput() {
        assertEquals(false, test.isItTheSame(anotherFalseArray));
        assertEquals(true, test.isItTheSame(trueArray));
    }


}