package BankingApplication;

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
}
