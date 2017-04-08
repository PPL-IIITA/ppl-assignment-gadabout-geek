package Gifts;
public class Gift implements Comparable<Gift>/*! \brief A type of Gift
    *
    *class with the attributes to describe a Luxury Gift
    */{
/** value of gift*/
    private int value;
    /**price of gift*/
    private int price;

    public Gift(){

    }
    public int compareTo(Gift g){
        return this.price - g.getPrice();
    }

    public Gift(int value, int price){
        this.value = value;
        this.price = price;
    }

    public int getValue() {
        /**getter (accessor) of value of gift*/
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