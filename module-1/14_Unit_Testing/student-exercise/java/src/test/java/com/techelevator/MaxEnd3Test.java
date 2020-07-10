package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxEnd3Test {

    private MaxEnd3 test;
    int[] firstTestArray = {3, 4, 3};
    int[] firstResultArray = {3, 3, 3};
    int[] secondTestArray = {4, 5, 1};
    int[] secondResultArray = {4, 4, 4};
    int[] thirdTestArray = {4, 10, 9};
    int[] thirdResultArray = {9, 9, 9};

    @Before
    public void setUp() throws Exception {
        test = new MaxEnd3();
    }

    @Test
    public void makeArray() {
        assertArrayEquals(firstResultArray, test.makeArray(firstTestArray));
        assertArrayEquals(secondResultArray, test.makeArray(secondTestArray));
        assertArrayEquals(thirdResultArray, test.makeArray(thirdTestArray));
    }
}