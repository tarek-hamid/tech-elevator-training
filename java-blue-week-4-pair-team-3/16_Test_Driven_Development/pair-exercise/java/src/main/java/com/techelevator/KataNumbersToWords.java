package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataNumbersToWords {

    private int num;

    public KataNumbersToWords() {
    }

    public String NumbersToWords (int num){
        this.num = num;
        Map<Integer, String> singleDigitNumbers = new HashMap<>();
        singleDigitNumbers.put(0, "zero");
        singleDigitNumbers.put(1, "one");
        singleDigitNumbers.put(2, "two");
        singleDigitNumbers.put(3, "three");
        singleDigitNumbers.put(4, "four");
        singleDigitNumbers.put(5, "five");
        singleDigitNumbers.put(6, "six");
        singleDigitNumbers.put(7, "seven");
        singleDigitNumbers.put(8, "eight");
        singleDigitNumbers.put(9, "nine");
        singleDigitNumbers.put(10, "ten");
        singleDigitNumbers.put(11, "eleven");
        singleDigitNumbers.put(12, "twelve");
        singleDigitNumbers.put(13, "thirteen");
        singleDigitNumbers.put(14, "fourteen");
        singleDigitNumbers.put(15, "fifteen");
        singleDigitNumbers.put(16, "sixteen");
        singleDigitNumbers.put(17, "seventeen");
        singleDigitNumbers.put(18, "eighteen");
        singleDigitNumbers.put(19, "nineteen");

        Map<Integer, String> tensNumbers  = new HashMap<>();
        tensNumbers.put(2, "twenty");
        tensNumbers.put(3, "thirty");
        tensNumbers.put(4, "forty");
        tensNumbers.put(5, "fifty");
        tensNumbers.put(6, "sixty");
        tensNumbers.put(7, "seventy");
        tensNumbers.put(8, "eighty");
        tensNumbers.put(9, "ninety");

        if(num < 20){
            return singleDigitNumbers.get(num);
        } else if (num < 100) {
            int tempNum = num / 10;
            int tempRemainder = num % 10;
            String first = tensNumbers.get(tempNum);
            String second = singleDigitNumbers.get(tempRemainder);
            return first + "-" + second;
        } else if (num < 1000) {
            int hundredsNum = num / 100;
            int tensNum = num % 100 / 10;
            int onesNum = num % 100 % 10;
            String hundreds = singleDigitNumbers.get(hundredsNum);
            String tens = tensNumbers.get(tensNum);
            String ones = singleDigitNumbers.get(onesNum);
            return hundreds + " hundred " + tens + "-" + ones;
        } else if (num < 10000) {

            int hundredsNum = num / 100;
            int tensNum = num % 100 / 10;
            int onesNum = num % 100 % 10;
            String hundreds = singleDigitNumbers.get(hundredsNum);
            String tens = tensNumbers.get(tensNum);
            String ones = singleDigitNumbers.get(onesNum);
            return hundreds + " hundred " + tens + "-" + ones;
        }
        return null;
    }

}
