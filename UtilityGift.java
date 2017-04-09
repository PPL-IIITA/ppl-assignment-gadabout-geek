package Gifts;
public class UtilityGift/*! \brief A type of Gift
    *
    *class with the attributes to describe a Utility Gift
    */{
    /** will contain gift value*/
    private int value;
    /**price of gift*/
    private int price;
    /**utility class of gift*/
    private int utilityclass;
    /**utility value of gift*/
    private int utilityvalue;

    public int getValue() {/**getter of value*/
        return value;
    }
    public UtilityGift(){/**Default Constructor*/
        
    }
    public UtilityGift(int price, int value, int utilityvalue, int utilityclass) {/**parameterized constructor*/
        this.value = value;
        this.price = price;
        this.utilityclass = utilityclass;
        this.utilityvalue = utilityvalue;
    }

    public void setValue(int value) {/**setter of value*/
        this.value = value;
    }

    public int getPrice() {/**getter of price*/
        return price;
    }

    public void setPrice(int price) {/**setter of price*/
        this.price = price;
    }
}