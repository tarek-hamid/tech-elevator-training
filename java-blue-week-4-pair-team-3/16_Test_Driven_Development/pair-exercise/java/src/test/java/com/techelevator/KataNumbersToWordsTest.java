package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class KataNumbersToWordsTest {

    private KataNumbersToWords test;

    @Before
    public void setUp() throws Exception {
        test = new KataNumbersToWords();
    }

    @Test
    public void singleDigitTest() {
        assertEquals("zero", test.NumbersToWords(0));
        assertEquals("nineteen", test.NumbersToWords(19));
    }

    @Test
    public void tensHundredsTest() {
        assertEquals("eighty-one", test.NumbersToWords(81));
        assertEquals("forty-six", test.NumbersToWords(46));
        assertEquals("one hundred forty-five", test.NumbersToWords(145));
    }


}
