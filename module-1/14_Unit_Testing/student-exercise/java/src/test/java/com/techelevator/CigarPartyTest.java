package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CigarPartyTest {

    private CigarParty test;

    @Before
    public void setUp() throws Exception {
        test = new CigarParty();
    }

    @Test
    public void test_output_when_weekend_is_true() {
        // Test if there is no upper bound of cigars during weekend
        assertEquals(true, test.haveParty(61, true));

        // Test regular outputs during weekend
        assertEquals(false, test.haveParty(39, true));

    }

    @Test
    public void test_output_when_weekend_is_false() {
        // Test outputs if it isn't weekend (edge cases)
        assertEquals(false, test.haveParty(61, false));
        assertEquals(true, test.haveParty(40, false));
    }




}