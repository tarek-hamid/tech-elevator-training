package com.techelevator.shoppingcart;

public class ShoppingCart {

	public ShoppingCart(){

    }

    int totalNumberOfItems = 0;
	double totalAmountOwed = 0.0;

    public int getTotalNumberOfItems() {
        return totalNumberOfItems;
    }

    public double getTotalAmountOwed() {
        return totalAmountOwed;
    }

    public double getAveragePricePerItem() {
        if (totalNumberOfItems == 0){
            return 0.00;
        } else {
            return totalAmountOwed / totalNumberOfItems;
        }
    }

    public void addItems(int numberOfItems, double pricePerItem){
        totalNumberOfItems = numberOfItems;
        totalAmountOwed = pricePerItem * numberOfItems;
    }

    public void empty(){
        totalNumberOfItems = 0;
        totalAmountOwed = 0;
    }


}
