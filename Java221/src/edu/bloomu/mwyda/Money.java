package edu.bloomu.mwyda;

/**
 * Stores money and can add or take away from the balance.
 *
 * @author Michael Wyda
 */

public class Money {

    double balance;

    /**
     * Constructor to create a Money object
     */
    public Money(double balance) {
        this.balance = balance;
    }

    /**
     * Adds the amount to the balance of money.
     */
    public void gainMoney(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
        }
    }

    /**
     * Subtracts the amount from the balance of money.
     */
    public void spendMoney(double amount)
    {
        if(amount > 0)
        {
            balance -= amount;
        }
    }

    /**
     * Returns the current balance of money.
     */
    public double getBalance() {return balance;}

    @Override
    public String toString() {
        return String.format("Your current balance is: $%.2f",getBalance());
    }

    public static void main(String[] args) {
        Money myMoney = new Money(123.45);
        System.out.println(myMoney);
        myMoney.gainMoney(1.20);
        System.out.println(myMoney);
        myMoney.spendMoney(5.43);
        System.out.println(myMoney);
    }


}
