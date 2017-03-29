package Girls;

import Utils.*;
import java.util.*;
import Gifts.*;

public class NormalGirl extends Girl/*! \brief A type of Girl
    *
    *class with the attributes to describe a Normal Girl
    */{
    /** type of girl*/
    public final Constants.GIRL_TYPE TYPE = Constants.GIRL_TYPE.NORMAL;
    
    public NormalGirl(String name, int attr, int mainCost, int intl, Constants.CRITERION criterion, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        super(name, attr, mainCost, intl, criterion, commited, happiness);
    }

    public NormalGirl(){/**Default Constructor */
       
    }

    public double calHappiness(Relationship r){
        ArrayList<Gift> gifts = r.getGifts();
        int sum = 0;
        for(int i = 0; i < gifts.size(); i++){
            sum += gifts.get(i).getPrice();
            sum += gifts.get(i).getValue();
        }
        double t = Math.log(sum - this.getMainCost());
        this.setHappiness(t);
        return t;
    }
}
