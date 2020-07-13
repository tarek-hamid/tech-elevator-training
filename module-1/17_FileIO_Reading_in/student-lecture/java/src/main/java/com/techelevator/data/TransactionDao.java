package com.techelevator.data;

import com.techelevator.entity.Customer;
import com.techelevator.entity.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionDao {

    Map<Integer, List<Transaction>> loadTransactions() throws Exception;

    Map<Integer, List<Transaction>> loadTransactions(String fileName, String delimiter) throws Exception;

    public void addTransaction (int id, Transaction transaction);
}
