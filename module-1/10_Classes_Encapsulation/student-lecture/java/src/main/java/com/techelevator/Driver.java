package com.techelevator;

import com.techelevator.entity.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Customer cust1 = new Customer();

        System.out.println("Please enter your name: ");
        cust1.setName( scanner.nextLine() );

        System.out.println("Please enter your email: ");
        cust1.setEmail( scanner.nextLine() );

        System.out.println("Customer is " + cust1.getName() + " " + cust1.getEmail());

        List<Customer> customerList = new ArrayList<>();
        customerList.add(new Customer("Deon", "deon@myco.com"));
        customerList.add(new Customer("Gabe", "gabe@myco.com"));
        customerList.add(new Customer("Elana", "elana@myco.com"));

        for (Customer value : customerList){
            System.out.println("Customer is " + value.getName() + " " + value.getEmail());
        }
    }
}
