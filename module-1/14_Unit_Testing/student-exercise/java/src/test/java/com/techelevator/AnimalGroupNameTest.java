package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalGroupNameTest {

    private AnimalGroupName test;

    @Before
    public void setUp() throws Exception {
        test = new AnimalGroupName();
    }

    @Test
    public void case_Sensitivity_Test() {

        // Test for case sensitivity
        assertEquals("Herd", test.getHerd("elephant"));
        assertEquals("Herd", test.getHerd("ELEPHANT"));
    }

    @Test
    public void null_Output_Test() {

        // Test for null output
        assertEquals("unknown", test.getHerd("tiger"));
    }

    @Test
    public void correct_Herd_Output() {

        // Test for correct herd output
        assertEquals("Tower", test.getHerd("giraffe"));
        assertEquals("Pack", test.getHerd("dog"));
    }


}