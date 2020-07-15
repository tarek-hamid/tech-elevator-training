package com.techelevator.console;

import com.techelevator.biz.TransactionManager;
import com.techelevator.data.CustomerDao;
import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;

public class Client {

    private TransactionManager manager;

    private CustomerDao customerDao;

    public Client(TransactionManager manager, CustomerDao customerDao) {
        this.manager = manager;
        this.customerDao = customerDao;

    }

    public void startClient() {

        Customer cust1 = customerDao.getCustomer(1);
        if (cust1 == null){
            System.out.println("Error: customer not found!");
            System.exit(1);
        }
        System.out.println(cust1.getFirstName() + " " + cust1.getLastName());
        for (Transaction value : manager.getCustomerTransactions(cust1)){
            System.out.println(value);
        }
        System.out.println("Total transaction amount: " +
                manager.getCustomersTotalTransactionAmount(cust1));

    }
}
