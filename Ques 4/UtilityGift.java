package Gifts;
public class UtilityGift extends Gift/*! \brief A type of Gift
    *
    *class with the attributes to describe a Utility Gift
    */{
    
    private int utilityclass;
    /**utility value of gift*/
    private int utilityvalue;

    public int getUtilityValue() {
        return utilityvalue;
    }
    public UtilityGift(){/**Default Constructor*/
        
    }
    public UtilityGift(int price, int value, int utilityvalue, int utilityclass) {/**parameterized constructor*/
        super(value, price);
        this.utilityclass = utilityclass;
        this.utilityvalue = utilityvalue;
    }

    public void setUtilityValue(int value) {
        this.utilityvalue = value;
    }

    public int getUtilityClass() {
        return utilityclass;
    }

    public void setUtilityClass(int utilityclass){
        this.utilityclass = utilityclass;
    }
}