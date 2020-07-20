package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class Module1CodingAssessmentTest {

    private TellerMachine test;
    private TellerMachine test2;
    private TellerMachine test3;

    @Before
    public void setUp() throws Exception {
        test = new TellerMachine("TestManufacturer", new BigDecimal("30.00"), new BigDecimal("10.00"));
        test2 = new TellerMachine("TestManufacturer2", new BigDecimal("100.00"), new BigDecimal("60.00"));
        test3 = new TellerMachine("TestManufacturer3", new BigDecimal("230.00"), new BigDecimal("70.00"));
    }

    @Test
    public void testToString() {
        assertEquals("ATM - TestManufacturer - 20.00", test.toString());
        assertEquals("ATM - TestManufacturer2 - 40.00", test2.toString());
        assertEquals("ATM - TestManufacturer3 - 160.00", test3.toString());
    }

    @Test
    public void balanceCalculationTest() {
        assertEquals(new BigDecimal("20.00"), test.getBalance());
        assertEquals(new BigDecimal("40.00"), test2.getBalance());
        assertEquals(new BigDecimal("160.00"), test3.getBalance());
    }

    @Test
    public void validCardNumber() {
        assertEquals(true, test.validCardNumber("5736251429376253"));
        assertEquals(false, test.validCardNumber("5836238373634"));
        assertEquals(true, test.validCardNumber("4452365214785"));
        assertEquals(true, test.validCardNumber("4125987456325647"));
        assertEquals(false, test.validCardNumber("4785987512"));
        assertEquals(true, test.validCardNumber("3457"));
        assertEquals(false, test.validCardNumber("367"));
    }
}