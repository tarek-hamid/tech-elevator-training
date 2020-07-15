package com.techelevator.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Customer extends Person {

    /**
     * unique id we generate for all customers
     */
    private int id;

    private LocalDate birthDate;

    public Customer(){
        this(null, null, 0);
    }

    public Customer(String firstName, String lastName, int id) {
        this(firstName, lastName, null, id, null);
    }

    public Customer(String firstName, String lastName, String email, int id, LocalDate birthDate) {
        super(firstName, lastName, email);
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return id == customer.id &&
                Objects.equals(birthDate, customer.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, birthDate);
    }
}
