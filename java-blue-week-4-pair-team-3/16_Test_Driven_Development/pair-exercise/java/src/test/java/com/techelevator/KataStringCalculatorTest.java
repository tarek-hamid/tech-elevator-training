package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataStringCalculatorTest {

    private KataStringCalculator kataStringCalculator;

    @Before
    public void setUp() throws Exception {
        kataStringCalculator = new KataStringCalculator();
    }

    @Test
    public void addTest() {
        assertEquals(0, kataStringCalculator.add(""));
        assertEquals(5, kataStringCalculator.add("2,3"));
        assertEquals(60, kataStringCalculator.add("10,20,30"));
        assertEquals(80, kataStringCalculator.add("10,50\n20"));
        //assertEquals(13, kataStringCalculator.add("//!\n4!9"));
    }
}
