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

//
//    @Test
//    public void totalPriceWithFiveSetMax() {
//        assertEquals("51.60", test.getCost(new int[]{2, 2, 2, 1, 1}));
//    }

//    @Test
//    public void totalPriceWithFourSetMax() {
//        assertEquals("33.60", test.getCost(new int[]{1, 1, 1, 1, 1}));
//        assertEquals("25.60", test.getCost(new int[]{1, 1, 1, 1, 0}));
//        assertEquals("20.40", test.getCost(new int[]{1, 1, 1, 0, 0}));
//        assertEquals("14.40", test.getCost(new int[]{1, 1, 0, 0, 0}));
//        assertEquals("8.00", test.getCost(new int[]{1, 0, 0, 0, 0}));
//    }

    @Test
    public void bestPrice() {
        assertEquals("51.20",test.getCost(new int[] {2, 2, 2, 1, 1}));
        assertEquals("21.60",test.getCost(new int[]{1, 1, 1, 0, 0}));
        assertEquals("30.00", test.getCost(new int[]{1, 1, 1, 1, 1}));
        assertEquals("68.00", test.getCost(new int[]{2, 3, 2, 2, 2}));
        assertEquals("8.00", test.getCost(new int[]{1, 0, 0, 0, 0}));
    }
}
