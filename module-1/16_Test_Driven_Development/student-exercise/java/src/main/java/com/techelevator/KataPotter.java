package com.techelevator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class KataPotter {

    public KataPotter() {
    }

    public String getCost(int[] books){

        int[] noMoreBooks = {0, 0, 0, 0, 0};

        DecimalFormat df = new DecimalFormat("#.00");
        double totalPrice = 0;
        int bookCount = 0;


        // Create two for loops, one to test with sets of 5, one to test with sets of 4.
        for(int i = 0; i < books.length; i++){
            if (books[i] > 0){
                bookCount += 1;
                books[i] -= 1;
            }
        }

        if (bookCount == 5) {
            totalPrice += (8 * 5 * 0.75);
            bookCount = 0;
        } else if (bookCount == 4) {
            totalPrice += (8 * 4 * 0.80);
            bookCount = 0;
        } else if (bookCount == 3) {
            totalPrice += (8 * 3 * 0.85);
        } else if (bookCount == 2) {
            totalPrice += (8 * 2 * 0.90);
        } else {
            totalPrice += 8;
        }

        return df.format(totalPrice);
    }

}
