package Gifts;
public class LuxuryGift extends Gift/*! \brief A type of Gift
    *
    *class with the attributes to describe a Luxury Gift
    */{
    /**rating of gift*/
    private int rating;
    /**difficulty of gift*/
    private int difficulty;

    public LuxuryGift(){/**default constructor*/
        
    }
    public LuxuryGift(int price, int value, int rating, int difficulty) {/** parameterized constructor*/
        super(price , value);
        this.rating = rating;
        this.difficulty = difficulty;
    }

    public int getRating(){
        return rating;
    }

    public void setDifficulty(int difficulty){
        this.difficulty = difficulty;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setRating(int rating){
        this.rating = rating;
    }
}