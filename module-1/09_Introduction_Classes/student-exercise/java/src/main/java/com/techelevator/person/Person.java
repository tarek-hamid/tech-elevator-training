package com.techelevator.person;

public class Person {

    public Person (){

    }

	private String firstName;
    private String lastName;
    private int age;

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public int getAge(){
        return this.age;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public boolean isAdult(){
        if (age > 17){
            return true;
        }
        return false;
    }

}
