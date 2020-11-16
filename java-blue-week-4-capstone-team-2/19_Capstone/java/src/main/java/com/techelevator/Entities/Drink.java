package com.techelevator.Entities;

import java.math.BigDecimal;

public class Drink extends VendingMachineItem {
    public Drink(int quantity, String slotNumber, String itemName, String snack, BigDecimal price) {
        super(quantity, slotNumber, itemName, snack, price);
    }

    @Override
    public String getMessage() {
        return "Glug Glug, Yum!";
    }

}
