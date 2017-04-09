package Girls;

import Utils.*;
import java.util.*;
import Gifts.*;

public class ChoosyGirl extends Girl/*! \brief A type of Girl
    *
    *class with the attributes to describe a Choosy Girl
    */
 {   
    /** type of girl*/
    public final Constants.GIRL_TYPE TYPE = Constants.GIRL_TYPE.CHOOSY;
    
    public ChoosyGirl(String name, int attr, int mainCost, int intl, Constants.CRITERION criterion, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        super(name, attr, mainCost, intl, criterion, commited, happiness);
    }
    
    public ChoosyGirl(){/**Default Constructor */
        
    }

    public double calHappiness(Relationship r){/**Overriden Function which on passing her relationship variable returns the happiness*/
        ArrayList<Gift> gifts = r.getGifts();
        int sum = 0;
        for(int i = 0; i < gifts.size(); i++){
            sum += gifts.get(i).getPrice();
            if(gifts.get(i) instanceof LuxuryGift){
                sum += gifts.get(i).getPrice();
            }
        }
        double t = Math.log(sum - this.getMainCost());
        this.setHappiness(t);
        return t;
    }
}
