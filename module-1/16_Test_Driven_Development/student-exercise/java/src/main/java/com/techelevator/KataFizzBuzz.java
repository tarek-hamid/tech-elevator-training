package com.techelevator;

public class KataFizzBuzz {

    private int num;

    public KataFizzBuzz() {
    }

    public String fizzBuzz(int num){
        if (num % 3 == 0 && num % 5 == 0){
            return "FizzBuzz.";
        } else if (num % 3 == 0){
            return "Fizz.";
        } else if (num % 5 == 0) {
            return "Buzz.";
        } else if (num < 100) {
            return Integer.toString(num);
        }
        return null;
    }

}
