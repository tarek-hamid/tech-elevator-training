package com.techelevator;

import org.junit.Before;
import org.junit.Test;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WordCountTest {

    private WordCount test;
    Map<String, Integer> outputDictionary = new HashMap<>();
    String[] populatedString = {"Tarek", "Tech", "Elevator", "Tarek"};
    String[] nullString = {};


    @Before
    public void setUp() throws Exception {
        test = new WordCount();
    }

    @Test
    public void checkPopulatedString() {
        outputDictionary.put("Tarek", 2);
        outputDictionary.put("Tech", 1);
        outputDictionary.put("Elevator", 1);
        assertEquals(outputDictionary, test.getCount(populatedString));
    }

    @Test
    public void checkNullString() {
        assertEquals(outputDictionary, test.getCount(nullString));
    }


}