package com.techelevator;

import com.techelevator.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args){

        Employee emp1 = new Employee("David", "david@myco.com", 123, "CEO",
                new BigDecimal(100));

        Bike bike1 = new Bike(2);

        Customer cust1 = new Customer("Deon", "deon@myco.com", LocalDate.now());

        List<Movable> moveList = new ArrayList<>();
        moveList.add(emp1);
        moveList.add(bike1);
        for (Movable value : moveList){
            System.out.println(value.startMoving());
        }

        List<Person> people = new ArrayList<>();
        people.add(emp1);
        people.add(cust1);
        for (Person value : people) {
            System.out.println("name: " + value.getName());
            if (value instanceof Employee) {
                System.out.println("role: " + ((Employee)value).getRole());
            }
        }

//        System.out.println("emp1 instanceof Employee: " + (emp1 instanceof Employee));
//        System.out.println("emp1 instanceof Person: " + (emp1 instanceof Person));
//        System.out.println("emp1 instanceof Object: " + (emp1 instanceof Object));
//        System.out.println("emp1 instanceof Movable: " + (emp1 instanceof Movable));
//
//        Customer cust1 = new Customer();
//        System.out.println("cust1 instanceof Movable: " + (cust1 instanceof Movable));

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
