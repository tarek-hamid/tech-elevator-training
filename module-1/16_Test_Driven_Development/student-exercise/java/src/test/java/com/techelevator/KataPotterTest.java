package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataPotterTest {

    private KataPotter test;

    @Before
    public void setUp() throws Exception {
        test = new KataPotter();
    }

    @Test
    public void eachBookCostsEight() {
        assertEquals(16, test.getCost(new int[]{1, 1}));
        assertEquals(24, test.getCost(new int[]{2, 1}));
    }
}
