package com.driver;

import java.util.HashMap;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        if(getMinBalance()<5000)
        {
            throw new Exception("Insufficient Balance");
        }
        this.tradeLicenseId = tradeLicenseId;


    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if(!isNumberValid(tradeLicenseId))
        {
            if(!canNumberBeValid(tradeLicenseId))
            {
                throw new Exception("Valid License can not be generated");
            }
        }

    }

    public boolean isNumberValid(String number)
    {
        for(int i=1; i<number.length(); i++)
        {
            if(number.charAt(i)==number.charAt(i-1))
            {
                return false;
            }
        }

        return true;
    }


    public boolean canNumberBeValid(String number)
    {
        int n = number.length();

        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<n; i++)
        {
            hm.put(number.charAt(i),hm.getOrDefault(number.charAt(i),0)+1);
        }

        for(int c: hm.values())
        {
            if(c >1)
            {
                int d = n-c;

                if(d+1 <c)
                {
                   return false;
                }
            }
        }

        return true;
    }
}
