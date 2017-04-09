package Gifts;
public class Gift implements Comparable<Gift>/*! Parent class of All types of Gifts
    *
    *class which every type of gifts extends and this has all the common attributes
    */{
/** value of gift*/
    private int value;
    /**price of gift*/
    private int price;

    public Gift(){/**default constructor*/

    }
    public int compareTo(Gift g){/**comparator function to sort according to price*/
        return this.price - g.getPrice();
    }

    public Gift(int price, int value){/**parameterized constructor for @param price and @param value*/
        this.value = value;
        this.price = price;
    }

    public int getValue() {  /**getter (accessor) of value of gift*/
        return value;
    }

    public void setValue(int value) {/**setter (Mutator) of value*/
        this.value = value;
    }

    public int getPrice() {/**getter of price*/
        return price;
    }

    public void setPrice(int price) {/**setter of price*/
        this.price = price;
    }
}