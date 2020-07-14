package com.techelevator.biz;

import com.techelevator.data.CustomerDao;
import com.techelevator.data.TransactionDao;
import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;
import com.techelevator.exceptions.TransactionManagerCreateException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionManager {

    private CustomerDao customerDao;

    private TransactionDao transactionDao;

    private Map<Integer, List<Transaction>> transactions;

    public TransactionManager(
            CustomerDao customerDao,
            TransactionDao transactionDao) throws Exception {
        this(customerDao, transactionDao, transactionDao.loadTransactions());
    }

    public TransactionManager(
            CustomerDao customerDao,
            TransactionDao transactionDao,
            Map<Integer, List<Transaction>> transactions)
            throws TransactionManagerCreateException {

        if (customerDao == null || transactionDao == null){
            throw new TransactionManagerCreateException(
                    "Must have valid customer and transaction DAO objects.");
        }
        this.customerDao = customerDao;
        this.transactionDao = transactionDao;
        this.transactions = transactions;
    }

    public void add(Customer customer, Transaction transaction){
        transactionDao.addTransaction(customer.getId(), transaction);
    }

    public List<Transaction> getCustomerTransactions(Customer customer){
        List<Transaction> result = transactions.get(customer.getId());
        if (result == null){
            result = new ArrayList<>();
        }
        return result;
    }

    public int getCustomersWithTransactionsSize(){
        return transactions.size();
    }

    public BigDecimal getCustomersTotalTransactionAmount(Customer customer){
        BigDecimal total = BigDecimal.ZERO;
        total.setScale(2);
        for (Transaction value : getCustomerTransactions(customer)){
            total = total.add(value.getAmount());
        }
        return total;
    }
}
