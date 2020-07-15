package com.techelevator;

import com.techelevator.biz.TransactionManager;
import com.techelevator.console.Client;
import com.techelevator.data.CustomerDao;
import com.techelevator.data.CustomerDaoFile;
import com.techelevator.data.TransactionDao;
import com.techelevator.data.TransactionDaoFile;
import com.techelevator.entity.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {

        // use "try with resources" for AutoCloseable classes!!!!!!!
        try (Scanner scanner = new Scanner( new File("customerData.csv") );) {
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }

        }
        // stack catch blocks with subclasses before super classes
        catch (FileNotFoundException ex) {
            System.out.println("do something useful " + ex.getMessage());
            ex.printStackTrace(System.out);
        } // If exception class is an instanceof RuntimeException the catch is optional
        catch (IllegalStateException ex){
            System.out.println("do something useful " + ex.getMessage());
        } finally {
            // executes everytime regardless of what happens in try or catch blocks
            // put work in here that is NOT done by AutoCloseable
        }

//        CustomerDao customerDao = null;
//        TransactionManager manager = null;
//        try {
//            customerDao = new CustomerDaoFile("customerData.csv", ",");
//
//            manager = new TransactionManager(customerDao, new TransactionDaoFile());
//
//        } catch (Exception ex){
//            // Do something useful here!
//            System.out.println("Error: " + ex.getMessage());
//            System.exit(1);
//        }
//        Client client = new Client(manager, customerDao);
//        client.startClient();
    }
}
