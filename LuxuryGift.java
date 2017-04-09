package Gifts;
public class LuxuryGift/*! \brief A type of Gift
    *
    *class with the attributes to describe a Luxury Gift
    */{
/** value of gift*/
    private int value;
    /**price of gift*/
    private int price;
    /**rating of gift*/
    private int rating;
    /**difficulty of gift*/
    private int difficulty;
    public int getValue() {
        /**getter (accessor) of value of gift*/
        return value;
    }
    public LuxuryGift(){/**default constructor*/
        
    }

    public void setValue(int value) {/**setter (Mutator) of value*/
        this.value = value;
    }

    public LuxuryGift(int value, int price, int rating, int difficulty) {/** parameterized constructor*/
        this.value = value;
        this.price = price;
        this.rating = rating;
        this.difficulty = difficulty;
    }

    public int getPrice() {/**getter of price*/
        return price;
        
    }

    public void setPrice(int price) {/**setter of price*/
        this.price = price;
    }
}