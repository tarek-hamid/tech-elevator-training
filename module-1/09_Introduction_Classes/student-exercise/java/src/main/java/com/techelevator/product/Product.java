package com.techelevator.product;

public class Product {

	public Product(){

    }

    private String name;
	private double price;
	private double weightInOunces;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWeightInOunces(double weightInOunces){
        this.weightInOunces = weightInOunces;
    }

    public double getPrice() {
        return price;
    }

    public double getWeightInOunces() {
        return weightInOunces;
    }

    public String getName(){
        return name;
    }


}
