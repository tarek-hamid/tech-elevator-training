package com.techelevator.company;

public class Company {

	public Company(){
    }

    private String name;
    private int numberOfEmployees;
    private double revenue;
    private double expenses;

    public String getName(){
        return name;
    }

    public int getNumberOfEmployees() {
        return this.numberOfEmployees;
    }

    public double getRevenue() {
        return this.revenue;
    }

    public double getExpenses() {
        return this.expenses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }


    public String getCompanySize(){
        if(numberOfEmployees < 51){
            return "small";
        } else if (numberOfEmployees < 251 && numberOfEmployees > 50) {
            return "medium";
        } else {
            return "large";
        }
    }

    public double getProfit(){
        return getRevenue()-getExpenses();
    }
}
