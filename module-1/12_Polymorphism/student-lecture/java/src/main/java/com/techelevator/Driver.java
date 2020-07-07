package com.techelevator;

import com.techelevator.entity.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        Customer cust1 = new Customer("David", "david@myco.com", LocalDate.now());
        System.out.println(cust1);

//        Scanner scanner = new Scanner(System.in);
//        Customer cust1 = new Customer();
//
//        System.out.println("Please enter your name: ");
//        cust1.setName( scanner.nextLine() );
//
//        System.out.println("Please enter your email: ");
//        cust1.setEmail( scanner.nextLine() );
//
//        System.out.println(cust1.toString());

//        System.out.println("nextId = " + Customer.getNextId());

//        List<Customer> customerList = new ArrayList<>();
//        customerList.add(new Customer("Deon", "deon@myco.com"));
//        customerList.add(new Customer("Gabe", "gabe@myco.com"));
//        customerList.add(new Customer("Elana", "elana@myco.com"));
//
//        Customer cust1 = new Customer("David", "dv@myco.com");
//        System.out.println(cust1.toString());
//        System.out.println("Name is " + cust1.getName());
//
//        Customer cust2 = new Customer("Tara", "tv@myco.com");
//        System.out.println(cust2.toString());


//        for (Customer value : customerList){
//            System.out.println(value.toString());
//        }
    }
}
