package com.techelevator.entity;

public class Bike implements Movable {

    private int noOfWheels;

    public Bike(){

    }

    public Bike(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public int getNoOfWheels() {
        return noOfWheels;
    }

    public void setNoOfWheels(int noOfWheels) {
        this.noOfWheels = noOfWheels;
    }

    public String startMoving(){
        return "Bike is started...";
    }

    public String move(){
        return "Bike is moving";
    }

    public String stopMoving(){
        return "Bike is stopped";
    }
}
