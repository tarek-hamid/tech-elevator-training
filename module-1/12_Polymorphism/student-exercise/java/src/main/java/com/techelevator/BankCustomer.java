package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<Accountable>();

    public BankCustomer(){
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Accountable[] getAccounts() {
        return accounts.toArray(new Accountable[0]);
    }

    public void addAccount(Accountable newAccount){
       accounts.add(newAccount);
       accounts.toArray();
    }

    public boolean isVip(){
        int balance = 0;
        for(int i = 0; i < accounts.size(); i++) {
            balance += accounts.get(i).getBalance();
        }
        if (balance >= 25000){
            return true;
        }
        return false;
    }
}
