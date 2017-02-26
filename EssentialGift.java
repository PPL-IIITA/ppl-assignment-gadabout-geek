package Gifts;
public class EssentialGift/*! \brief A type of Gift
    *
    *class with the attributes to describe a Essential
    */{
/** value of gift*/
    private int value;
/**price of gift*/
    private int price;

    public int getValue() {/**Getter (Accessor) for @param value */
        return value;
    }
    public EssentialGift(){/**default constructor*/
        
    }

    public EssentialGift(int price, int value) {/**parameterized constructor*/
        this.value = value;
        this.price = price;
    }

    public void setValue(int value) {/**Setter (Mutator) for @param value*/
        this.value = value;
        
    }

    public int getPrice() {/**Getter (Accessor) for @param price */
        return price;
    }

    public void setPrice(int price) {/**Setter (Mutator) for @param price*/
        this.price = price;
    }
}