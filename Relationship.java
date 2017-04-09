package Utils;

import java.util.*;
import Boys.*;
import Gifts.*;
import Girls.*;
import Utils.*;

public class Relationship implements Comparable<Relationship>/*! \brief A class for every Relationship
    *
    *relationship between which boy and which girl and gifting
    */{
    private Boy boy;
    private Girl girl;
    /*happiness of couple*/
    private double happiness;
    /*compatibility of couple*/
    private double compatibility;
    private ArrayList<Gift> gifts;

    public ArrayList<Gift> getGifts(){
        return gifts;
    }

    public void setGifts(ArrayList<Gift> gifts){
        this.gifts = gifts;
    }
    
    public Boy getBoy(){/**getter*/
        return boy;
    }

    public Girl getGirl(){/**getter*/
        return girl;
    }

    public void setGirl(Girl girl){/**setter*/
        this.girl = girl;
    }

    public void setBoy(Boy boy){/**setter*/
        this.boy = boy;
    }

    public Relationship(){/**defualt constructor*/
        
    }

    public void gifting(ArrayList<Gift> gifts){
        Gifter gifter = new Gifter(this);
        gifter.gift(gifts);
        calHappiness();
        calCompatibility();
    }

    public int compareTo(Relationship r){/**comparator for sorting*/
        if(this.happiness - r.getHappiness() < 0){
            return 1;
        }
        return 0;
    }

    private void calHappiness(){
       happiness = girl.calHappiness(this);
       happiness += boy.calHappiness(this);
    }

    private void calCompatibility(){

    }

    public double getHappiness(){/**getter*/
        return happiness;
    }

    public double getCompatibility(){/**getter*/
        return compatibility;
    }

    public void setHappiness(double happiness){/**setter*/
        this.happiness = happiness;
    }
    public void setCompatibility(double compatibility){/**setter*/
        this.compatibility = compatibility;
    }
}