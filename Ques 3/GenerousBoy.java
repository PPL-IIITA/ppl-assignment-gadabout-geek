package Boys;

import Utils.*;
import java.util.*;

public class GenerousBoy extends Boy/*! \brief A type of Boy
    *
    *class with the attributes to describe a Generous Girl
    */
    {
    /** type of boy*/
    public final Constants.BOY_TYPE TYPE = Constants.BOY_TYPE.GENEROUS;
    
    public GenerousBoy(String name, int attr, int budget, int intl, int minAttr, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        super(name, attr, budget, intl, minAttr, commited, happiness);
    }

    public GenerousBoy(){/**Default Constructor */   
    }

    public double calHappiness(Relationship r){
        double t = r.getGirl().getHappiness();
        this.setHappiness(t);
        return t;
    }
}
