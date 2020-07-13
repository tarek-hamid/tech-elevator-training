package com.techelevator;

public class KataFizzBuzz {

    private int num;

    public KataFizzBuzz() {
    }

    public String fizzBuzz(int num){
        if (num % 3 == 0){
            return "Fizz.";
        } else if (num % 5 == 0) {
            return "Buzz.";
        }
        return null;
    }

}
