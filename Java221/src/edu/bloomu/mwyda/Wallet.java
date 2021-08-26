package edu.bloomu.mwyda;


import static edu.bloomu.mwyda.Currency.*;
import java.util.Locale;

/**
 * @author Michael Wyda
 */

public class Wallet {

    int numCurrencies = 10;
    int[] currencies;

    Currency[] currencyValues = {PENNY,NICKEL,DIME,QUARTER,DOLLAR,FIVE,TEN,TWENTY,FIFTY,HUNDRED};

    public Wallet(){
        currencies = new int[numCurrencies];
    }

    /**
     * Helper method that finds the location that the specified currency is at.
     */
    private int findCurrencySlot(Currency currencyToBeAdded)
    {
        switch (currencyToBeAdded.name.toLowerCase(Locale.ROOT)) {
            case "penny" -> {
                return 0;
            }
            case "nickel" -> {
                return 1;
            }
            case "dime" -> {
                return 2;
            }
            case "quarter" -> {
                return 3;
            }
            case "one" -> {
                return 4;
            }
            case "five" -> {
                return 5;
            }
            case "ten" -> {
                return 6;
            }
            case "twenty" -> {
                return 7;
            }
            case "fifty" -> {
                return 8;
            }
            case "hundred" -> {
                return 9;
            }
        }
        return 10;
    }

    /**
     * Adds the specified amount of the given Currency to the wallet.
     */
    public void addCurrency(Currency currencyToBeAdded, int amount) {

        int location = findCurrencySlot(currencyToBeAdded);
        if(location < numCurrencies)
        {
            currencies[location] += amount;
        }
    }

    /**
     * Removes the specified amount of the given Currency to the wallet.
     */
    public void subtractCurrency(Currency currencyToBeAdded, int amount) {

        int location = findCurrencySlot(currencyToBeAdded);
        if(location < numCurrencies && amount <= currencies[location])
        {
            currencies[location] -= amount;
        }
    }

    /**
     * Displays the amount of each currency in the wallet in descending value order.
     */
    public String displayWallet() {
        String output = "Your wallet contains:\n";
        for(int i=numCurrencies-1; i>=0; i--)
        {
            if(currencies[i] > 0)
            {
                output += String.format("%d %ss\n",currencies[i],currencyValues[i].getName());
            }
        }
        return output;
    }

    /**
     * Returns the current balance of the wallet.
     *
     */
    public double getBalance() {
        double balance = 0;
        for(int i=0;i<numCurrencies;i++)
        {
            balance += currencies[i] * currencyValues[i].value.getBalance();
        }
        return balance;
    }

    @Override
    public String toString() {
        return displayWallet() + "\n" + String.format("Your wallet's total balance is: $%.2f.",getBalance());
    }

    /**
     * Overrides the toString method to display the contents of the wallet.
     */


    public static void main(String[] args) {
        Currency penny = new Currency(new Money(.01), "penny");
        System.out.println(penny);

        Wallet wallet = new Wallet();
        wallet.addCurrency(penny, 4);

        System.out.println(wallet.displayWallet());
        System.out.println(wallet.getBalance());

        wallet.addCurrency(TEN,2);
        wallet.subtractCurrency(penny,1);

        System.out.println(wallet.displayWallet());
        System.out.println(wallet.getBalance());

        wallet.addCurrency(TWENTY, 1);
        wallet.addCurrency(NICKEL, 6);
        System.out.println(wallet);
    }

}

