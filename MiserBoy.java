package Boys;

import java.util.*;
import Gifts.*;
import Utils.*;

public class MiserBoy extends Boy/*! \brief A type of Boy
*
*class with the attributes to describe a Miser Boy
*/{
    /** type of boy*/
    public final Constants.BOY_TYPE TYPE = Constants.BOY_TYPE.MISER;
       
    public MiserBoy(String name, int attr, int budget, int intl, int minAttr, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        super(name, attr, budget, intl, minAttr, commited, happiness);
    }

    public MiserBoy(){/**Default Constructor */
        
    }

    public double calHappiness(Relationship r){
    	ArrayList<Gift> gifts = r.getGifts();
    	int sum = 0;
    	for(int i =0; i < gifts.size(); i++){
    		sum+=gifts.get(i).getPrice();
    	}
    	double t = new Double(""+(this.getBudget() - sum));
    	this.setHappiness(t);
    	return t;
    } 
}
