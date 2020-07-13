package com.techelevator.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Customer extends Person { // Customer is a Person inherits all fields and methods of Person class
    /*
        Define fields of the class - usually set their scope to private (only the methods in this class)

        P I E - 3 general principals of OO language
     */
    private static int nextId = 1;

    public static int getNextId(){
        return nextId;
    }

    public static void setNextId(int nextId) {
        Customer.nextId = nextId;
    }

    private int id; // unique id we generate for all customers

    private LocalDate birthDate;

    public Customer(){
        this(null, null, null);
    }

    public Customer(String name, String email, LocalDate birthDate) {
        super(name, email); // call to Person constructor... must be the first line!
        this.id = nextId;
        nextId++;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public LocalDate getBirthDate() {

        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        // if the birthDate is more than 150 years ago I will NOT set it
        this.birthDate = birthDate;
    }

    public int getAge(){
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Customer{" + " : " + super.toString() +
                " id=" + id +
                ", birthDate=" + birthDate +
                '}';
    }
}
