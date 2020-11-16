package com.techelevator.Entities;

import java.math.BigDecimal;

public class Gum extends VendingMachineItem {
    public Gum(int quantity, String slotNumber, String itemName, String snack, BigDecimal price) {
        super(quantity, slotNumber, itemName, snack, price);
    }

    @Override
    public String getMessage() {
        return "Chew Chew, Yum!";
    }

}

