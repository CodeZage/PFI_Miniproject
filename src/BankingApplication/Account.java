package BankingApplication;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Account
{
    private String accountName;
    private char[] accountPassword;
    private double balance;

    public Account(String cAccountName, char[] cAccountPassword)
    {
        accountName = cAccountName;
        accountPassword = cAccountPassword;
        balance = 0;
    }

    public static boolean isAccountUnique(String possibleAccount)
    {
        boolean status = true;

        for (Account account : Main.accounts)
        {
            status = !possibleAccount.equals(account.getAccountName());
        }
        return status;
    }

    public String getAccountName()
    {
        return accountName;
    }

    public char[] getAccountPassword()
    {
        return accountPassword;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposit(String depositAmount)
    {
        if (testInput(depositAmount))
        {
            balance += Double.parseDouble(depositAmount);
        } else JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void withdraw(String withdrawAmount)
    {
        if (testInput(withdrawAmount))
        {
            balance -= Double.parseDouble(withdrawAmount);
        } else JOptionPane.showMessageDialog(null, "Please enter a valid amount", "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void transfer(String transferAmount, Account targetAccount)
    {
        if (testInput(transferAmount))
        {
            this.balance -= Double.parseDouble(transferAmount);
            targetAccount.balance += Double.parseDouble(transferAmount);
        }
    }

    private boolean testInput(String input)
    {
        if (input == null) return true;

        try
        {
            double amount = Double.parseDouble(input);
        } catch (NumberFormatException nfe)
        {
            return false;
        }

        return true;
    }


    @Override
    public String toString()
    {
        return accountName;
    }
}
