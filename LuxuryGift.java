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

    public int getRating(){/**getter for Rating*/
        return rating;
    }

    public void setDifficulty(int difficulty){/**setter for Difficulty*/
        this.difficulty = difficulty;
    }

    public int getDifficulty(){/**getter for Difficulty*/
        return difficulty;
    }

    public void setRating(int rating){/*setter for Rating*/
        this.rating = rating;
    }
}