package com.techelevator;

public class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }

    public CheckingAccount(String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }

    // withdraw	If the balance falls below $0, a $10 overdraft fee is also withdrawn from the account.
    // withdraw	Checking account can't be overdrawn by $100.00 or more. If a withdrawal request leaves the account $100 or more overdrawn, it fails and the balance remains the same.


    @Override
    public int withdraw(int amountToWithdraw) {
        if (amountToWithdraw - super.getBalance() >= 100) {
            return super.getBalance();
        } else if(super.getBalance() < 0){
            super.withdraw(10);
            return super.withdraw(amountToWithdraw);
        } else {
            return super.withdraw(amountToWithdraw);
        }

    }
}
