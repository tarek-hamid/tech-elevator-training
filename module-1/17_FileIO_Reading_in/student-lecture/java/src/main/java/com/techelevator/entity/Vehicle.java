package com.techelevator.entity;

public abstract class Vehicle implements Movable {

    private int noOfWheels;

    public Vehicle() {

    }

    public Vehicle(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }
}
