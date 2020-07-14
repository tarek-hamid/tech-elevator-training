package com.techelevator;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KataPotter {

    public KataPotter() {
    }

    public String getCost(int[] books) {

        int[] noMoreBooks = {0, 0, 0, 0, 0};
        int[] tempArray = books.clone();
        int[] tempArray2 = books.clone();

        DecimalFormat df = new DecimalFormat("0.00");
        double runningCostFiveSetMax = 0;
        double runningCostFourSetMax = 0;
        int bookCount = 0;
        int bookCount2 = 0;


        // For loop using maximum set 5
        while (!Arrays.equals(tempArray, noMoreBooks)) {
            for (int i = 0; i < tempArray.length; i++) {
                if (tempArray[i] != 0) {
                    bookCount++;
                    tempArray[i]--;
                }
                if (bookCount == 5) {
                    runningCostFiveSetMax += (8 * 5 * 0.75);
                    bookCount = 0;
                }
            }

            if (bookCount == 4) {
                runningCostFiveSetMax += (8 * 4 * 0.80);
                bookCount = 0;
            } else if (bookCount == 3) {
                runningCostFiveSetMax += (8 * 3 * 0.90);
                bookCount = 0;
            } else if (bookCount == 2) {
                runningCostFiveSetMax += (8 * 2 * 0.95);
                bookCount = 0;
            } else if (bookCount == 1) {
                runningCostFiveSetMax += 8;
                bookCount = 0;
            }
        }

        // For loop using max set 4
        while (!Arrays.equals(tempArray2, noMoreBooks)) {
            for (int i = 0; i < tempArray2.length; i++) {
                if (tempArray2[i] != 0) {
                    bookCount2++;
                    tempArray2[i]--;
                }
                if (bookCount2 == 4) {
                    runningCostFourSetMax += (8 * 4 * 0.80);
                    bookCount2 = 0;
                }
            }
        }
            if (bookCount2 == 3) {
                runningCostFourSetMax += (8 * 3 * 0.90);
                bookCount = 0;
            } else if (bookCount2 == 2) {
                runningCostFourSetMax += (8 * 2 * 0.95);
                bookCount = 0;
            } else if (bookCount2 == 1) {
                runningCostFourSetMax += 8;
                bookCount = 0;
            }
            String bestPrice = df.format(Math.min(runningCostFiveSetMax, runningCostFourSetMax));
            return bestPrice;
    }
}

