package com.techelevator.data;

import com.techelevator.entity.Customer;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

public class CustomerDaoFile implements CustomerDao {

    private Set<Customer> customers;

    public CustomerDaoFile(String fileName, String delimiter) throws Exception{
        loadCustomers(fileName, delimiter);
    }

    @Override
    public void loadCustomers(String fileName, String delimiter) throws Exception {

        customers = new HashSet<>();
        Scanner scanner = new Scanner( new File(fileName) );
        while (scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(delimiter);
            customers.add( new Customer(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
        }
        scanner.close();
    }

    @Override
    public Customer getCustomer(int id) {
        Customer customer = null;
        for (Customer value : customers){
            if (value.getId() == id){
                return value;
            }
        }
        return customer;
    }

    @Override
    public Customer add(Customer customer) {
        return null;
    }
}
