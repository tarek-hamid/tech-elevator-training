package com.techelevator;

import com.techelevator.biz.TransactionManager;
import com.techelevator.console.Client;
import com.techelevator.data.CustomerDao;
import com.techelevator.data.CustomerDaoFile;
import com.techelevator.data.TransactionDao;
import com.techelevator.data.TransactionDaoFile;
import com.techelevator.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Driver {

    public static void main(String[] args){

        CustomerDao customerDao = null;
        TransactionManager manager = null;
        try {
            customerDao = new CustomerDaoFile("customerData.csv", ",");

            manager = new TransactionManager(customerDao, new TransactionDaoFile());

        } catch (Exception ex){
            // Do something useful here!
            System.out.println("Error: " + ex.getMessage());
            System.exit(1);
        }
        Client client = new Client(manager, customerDao);
        client.startClient();
    }
}
