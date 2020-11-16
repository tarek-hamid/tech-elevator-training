package com.techelevator;



public class KataStringCalculator {

    private String numbers;
    //The numbers variable that is passed to the add method accepts a comma-delimited list of numbers that should be added together. The string may contain 0, 1, or 2 numbers. The value returned by the add method is the sum of the numbers provided in the string.

    //If an empty string is provided, 0 should be returned. If a number is provided in the string, then the number should be returned. If two numbers are provided, the sum of the two numbers is returned.
    public KataStringCalculator() {

    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public int add(String numbers) {
        if (numbers.length() == 0) {
            return 0;
        }
        String[] numberArr;
        //if (numbers.substring(0,2).equals("//")) {
        //    String delimeter = numbers.substring(2,3);
        //    String[] tempNumberArr = numbers.split(delimeter);

        //} else {
            numberArr = numbers.split(",|\n");
        //}
        int count = 0;
        for (String num : numberArr) {
            int i = Integer.parseInt(num);
            count += i;
        }
        return count;
    }

}
