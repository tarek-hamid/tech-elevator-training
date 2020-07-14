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
    public void totalPriceWithOneSetOfFive() {
        assertEquals("30.00", test.getCost(new int[]{1, 1, 1, 1, 1}));
    }

    @Test
    public void totalPriceWithOneSetOfFour() {
        assertEquals("25.60", test.getCost(new int[]{1, 1, 1, 1, 0}));
    }
    

    @Test
    public void totalPriceWithOneSetOfThree() {
        assertEquals("20.40", test.getCost(new int[]{1, 1, 1, 0, 0}));
    }

    @Test
    public void totalPriceWithOneSetOfTwo() {
        assertEquals("14.40", test.getCost(new int[]{1, 1, 0, 0, 0}));
    }

    @Test
    public void totalPriceWithOneSetOfOne() {
        assertEquals("8.00", test.getCost(new int[]{1, 0, 0, 0, 0}));
    }
}
