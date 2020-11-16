package com.techelevator.Data;

import com.techelevator.Entities.*;
import com.techelevator.VendingMachineCLI;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class ItemMapDao {

    public Map<String, VendingMachineItem> snackMap() {

        Map<String, VendingMachineItem> items = new LinkedHashMap<String, VendingMachineItem>();

        File dataFile = new File("vendingmachine.csv");
        try (Scanner dataInput = new Scanner(dataFile)) {

            while(dataInput.hasNext()){

                String lineOfInput = dataInput.nextLine();
                String[] words = lineOfInput.split("\\|");

                if (words[3].equals("Candy")) {
                    Candy candy = new Candy(5, words[0],
                            words[1], words[3], new BigDecimal(words[2]));
                    items.put(words[0], candy);
                } else if (words[3].equals("Chip")){
                    Chip chip = new Chip(5, words[0], words[1], words[3], new BigDecimal(words[2]));
                    items.put(words[0], chip);
                } else if (words[3].equals("Drink")) {
                    Drink drink = new Drink(5, words[0], words[1], words[3], new BigDecimal(words[2]));
                    items.put(words[0], drink);
                } else {
                    Gum gum = new Gum(5, words[0], words[1], words[3], new BigDecimal(words[2]));
                    items.put(words[0], gum);
                }
            }
        } catch (FileNotFoundException ex){
            System.out.println("File not found;");
        }
        return items;
    }
}
