package com.techelevator.Entities;

import java.math.BigDecimal;

public abstract class VendingMachineItem {

    // quantity, slot #, description
    // msg unique to each subclass (abstract), getmsg
    // Map <String, VendingMachineItem>

    private int quantity;
    private String slotNumber;
    private String itemName;
    private String snack;
    private BigDecimal price;

    public VendingMachineItem() {
    }

    public VendingMachineItem(int quantity, String slotNumber, String itemName, String snack, BigDecimal price) {
        this.quantity = quantity;
        this.slotNumber = slotNumber;
        this.itemName = itemName;
        this.snack = snack;
        this.price = price;
    }

    public abstract String getMessage();

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity--;
    }

    //    public void decreaseQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public String getSlotNumber() {
        return slotNumber;
    }

    public String getItemName() {
        return itemName;
    }

    public String getSnack() {
        return snack;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return  slotNumber + ", " + itemName + ", (" + quantity + " left), $" + price;
    }
}
