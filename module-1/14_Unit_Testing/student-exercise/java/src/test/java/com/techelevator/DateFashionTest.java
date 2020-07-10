package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateFashionTest {

    private DateFashion test;

    @Before
    public void setUp() throws Exception {
        test = new DateFashion();
    }

    @Test
    public void getATable() {
        // general test outputs, negative numbers not accounted for
        assertEquals(1, test.getATable(5, 5));
        assertEquals(0, test.getATable(8, 2));
        assertEquals(0, test.getATable(10, 0));
        assertEquals(2, test.getATable(8, 4));
    }
}