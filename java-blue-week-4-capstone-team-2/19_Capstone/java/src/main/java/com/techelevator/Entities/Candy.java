package com.techelevator.Entities;

import java.math.BigDecimal;

public class Candy extends VendingMachineItem {

    public Candy(int quantity, String slotNumber, String itemName, String snack, BigDecimal price) {
        super(quantity, slotNumber, itemName, snack, price);
    }

    @Override
    public String getMessage() {
        return "Munch Munch, Yum!";
    }
}
