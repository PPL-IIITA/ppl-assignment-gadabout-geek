package Boys;

import java.util.*;
import Utils.*;

public class GeekBoy extends Boy/*! \brief A type of Boy
    *
    *class with the attributes to describe a Geek boy
    */{
    /** type of boy*/
    public final Constants.BOY_TYPE TYPE = Constants.BOY_TYPE.GEEK;
    
    public GeekBoy(String name, int attr, int budget, int intl, int minAttr, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        super(name, attr, budget, intl, minAttr ,commited, happiness);
    }

    public GeekBoy(){/**Default Constructor */
    }

    public double calHappiness(Relationship r){/**Function which on passing his relationship variable returns the happiness*/
        double t = new Double(""+r.getGirl().getIntl());
        this.setHappiness(t);
        return t;
    }
}
