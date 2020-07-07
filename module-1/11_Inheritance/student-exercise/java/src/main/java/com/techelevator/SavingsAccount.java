package com.techelevator;

public class SavingsAccount extends BankAccount {

    public SavingsAccount (String accountHolderName, String accountNumber){
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount (String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }

    public int withdraw(int amountToWithdraw) {
        if (super.getBalance() > amountToWithdraw) {
            if (super.getBalance() - amountToWithdraw < 150) {
                amountToWithdraw += 2;
            }
            return super.withdraw(amountToWithdraw);
        } else {
            return super.getBalance();
        }
    }

}
