package com.techelevator.Entities;

import java.math.BigDecimal;

public class Chip extends VendingMachineItem {
    public Chip(int quantity, String slotNumber, String itemName, String snack, BigDecimal price) {
        super(quantity, slotNumber, itemName, snack, price);
    }

    @Override
    public String getMessage() {
        return "Crunch Crunch, Yum!";
    }

}
