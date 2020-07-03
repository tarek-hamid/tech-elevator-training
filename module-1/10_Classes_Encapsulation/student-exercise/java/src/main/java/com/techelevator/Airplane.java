package com.techelevator;

public class Airplane {

    private String planeNumber;
    private int bookedFirstClassSeats;
    private int availableFirstClassSeats;
    private int totalFirstClassSeats;
    private int bookedCoachSeats;
    private int availableCoachSeats;
    private int totalCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSets){
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSets;
    }

    public int getAvailableCoachSeats() {
        availableCoachSeats = totalCoachSeats - bookedCoachSeats;
        return availableCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        availableFirstClassSeats = totalFirstClassSeats - bookedFirstClassSeats;
        return availableFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSets() {
        return totalCoachSeats;
    }

    public int getTotalFirstClassSets() {
        return totalFirstClassSeats;
    }

    public String getPlaneNumber() {
        return planeNumber;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        if(forFirstClass){
            if (totalFirstClassSeats - bookedFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }

        } else {
            if (totalCoachSeats - bookedCoachSeats >= totalNumberOfSeats){
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            } else {
                return false;
            }
        }
    }

}
