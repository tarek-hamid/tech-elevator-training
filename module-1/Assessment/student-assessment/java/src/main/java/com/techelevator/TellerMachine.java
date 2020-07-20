package com.techelevator;

import java.math.BigDecimal;

public class TellerMachine {

    private String manufacturer;
    private BigDecimal deposits;
    private BigDecimal withdrawals;
    private BigDecimal balance;

    public TellerMachine(String manufacturer, BigDecimal deposits, BigDecimal withdrawals) {
        this.manufacturer = manufacturer;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
        this.balance = deposits.subtract(withdrawals);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public BigDecimal getDeposits() {
        return deposits;
    }

    public BigDecimal getWithdrawals() {
        return withdrawals;
    }

    public BigDecimal getBalance() {
        balance = deposits.subtract(withdrawals);
        return balance;
    }

    @Override
    public String toString() {
        return "ATM - " +
                manufacturer + " - " +
                balance;
    }

    public boolean validCardNumber(String cardNumber){
        char[] stringToCharArray = cardNumber.toCharArray();
        if(stringToCharArray.length == 16 && stringToCharArray[0] == '5') {
            return true;
        } else if ((stringToCharArray.length == 13 || stringToCharArray.length == 16) && stringToCharArray[0] == '4') {
            return true;
        } else if (stringToCharArray[0] == '3' && (stringToCharArray[1] == '4' || stringToCharArray[1] == '7')) {
            return true;
        }
        return false;
    }
}
