package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class KataPotter {

    // Methodology : evaluate all possibilities and store in Map the best one

    private int[] books;

    public KataPotter() {
    }

    public int getCost(int[] books){
        this.books = books;
        int cost = 0;
        for (Integer book: books){
            cost += (book * 8);
        }
        return cost;
    }

}
