package com.techelevator;

public class KataFizzBuzz {

    private int num;

    public KataFizzBuzz() {
    }

    public String fizzBuzz(int num){
        if (num > 100 || num == 0){
            return "";
        } else if ((num % 3 == 0 && num % 5 == 0) || (Integer.toString(num)).contains("3") && Integer.toString(num).contains("5")){
            return "FizzBuzz.";
        } else if ((num % 3 == 0) || (Integer.toString(num)).contains("3")){
            return "Fizz.";
        } else if (num % 5 == 0 || (Integer.toString(num)).contains("5")) {
            return "Buzz.";
        }
        return Integer.toString(num);
    }

}
