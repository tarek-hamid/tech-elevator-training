package com.techelevator.data;

import com.techelevator.entity.Transaction;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class TransactionDaoFile implements TransactionDao {

    private Map<Integer, List<Transaction>> transactions;

    public TransactionDaoFile(){}

    @Override
   public  Map<Integer, List<Transaction>> loadTransactions() throws Exception {
        return loadTransactions("transactionData.csv", ",");
    }

    @Override
    public  Map<Integer, List<Transaction>> loadTransactions(
            String fileName, String delimiter) throws Exception {

        transactions = new LinkedHashMap<>();

        Scanner scanner = new Scanner( new File(fileName) );
        while (scanner.hasNextLine()){
            String[] tokens = scanner.nextLine().split(delimiter);
            int customerId = Integer.parseInt(tokens[4]);
            int transId = Integer.parseInt(tokens[3]);
            LocalDate transDate = getLocalDate(tokens[1]);
            BigDecimal amount = new BigDecimal(Double.parseDouble(tokens[2]));
            Transaction transaction = new Transaction(
                    transId, transDate, amount, tokens[0] ); // description
            addTransaction(customerId, transaction);
        }
        scanner.close();
        return transactions;
    }

    public void addTransaction (int id, Transaction transaction) {
        List<Transaction> list = transactions.get(id);
        if (list == null){
            list = new ArrayList<>();
        }
        list.add(transaction);
        transactions.put(id, list);
    }

    private LocalDate getLocalDate(String dateStr){
        String[] tokens = dateStr.split("-");
        return LocalDate.of(
                Integer.parseInt(tokens[0]), // year
                Integer.parseInt(tokens[1]), // month
                Integer.parseInt(tokens[2]) ); // day
    }
}
