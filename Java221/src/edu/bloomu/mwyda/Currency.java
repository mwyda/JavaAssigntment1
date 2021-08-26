package edu.bloomu.mwyda;

/**
 * An immutable Currency that contains a value and a name.
 *
 * @author Michael Wyda
 */

public class Currency {

    final static Currency PENNY = new Currency(new Money(.01),"penny");
    final static Currency NICKEL = new Currency(new Money(.05),"nickel");
    final static Currency DIME = new Currency(new Money(.1),"dime");
    final static Currency QUARTER = new Currency(new Money(.25),"quarter");
    final static Currency DOLLAR = new Currency(new Money(1),"dollar");
    final static Currency FIVE = new Currency(new Money(5),"five");
    final static Currency TEN = new Currency(new Money(10),"ten");
    final static Currency TWENTY = new Currency(new Money(20),"twenty");
    final static Currency FIFTY = new Currency(new Money(50),"fifty");
    final static Currency HUNDRED = new Currency(new Money(100),"hundred");

    final Money value;
    final String name;

    public Currency(Money value, String name)
    {
        if(value.balance > 0) {
            this.value = value;
            this.name = name;
        }
        else
        {
            this.value = new Money(0);
            this.name = null;
        }
    }

    /**
     * Returns the value of the currency.
     */
    public Money getValue() {
        return value;
    }

    /**
     * Returns the name of the currency.
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Currency name: %s\nCurrency value: $%.2f",getName(),getValue().getBalance());
    }
}
