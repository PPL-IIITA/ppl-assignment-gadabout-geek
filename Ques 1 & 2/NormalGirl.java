package Girls;

import Utils.Constants;

public class NormalGirl/*! \brief A type of Girl
    *
    *class with the attributes to describe a Normal Girl
    */{
    /**name of girl*/
    private String name;
    /** attraction of girl*/
    private int attr;
    /** maintenance of Girl*/
    private int mainCost;
    /** intelligence of girl*/
    private int intl;
    /** type of girl*/
    public final Constants.GIRL_TYPE TYPE = Constants.GIRL_TYPE.NORMAL;
    /** criteria of girl*/
    private Constants.CRITERION criterion;
    /** whether commited or not*/
    private boolean commited;
     /** happiness of girl*/
    private double happiness;

    public NormalGirl(String name, int attr, int mainCost, int intl, Constants.CRITERION criterion, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        this.name = name;
        this.attr = attr;
        this.mainCost = mainCost;
        this.intl = intl;
        this.criterion = criterion;
        this.commited = commited;
        this.happiness = happiness;
    }

    public NormalGirl(){/**Default Constructor */
        
    }
   
    public String getName() {/**Getter (Accessor) for @param name */
        return name;
    }

    public void setName(String name) {/**Setter (Mutator) for @param name*/
        this.name = name;
    }

    public int getAttr() {/**Getter (Accessor) for @param attr*/
        return attr;
    }

    public void setAttr(int attr) {/**Setter (Mutator) for @param attr*/
        this.attr = attr;
    }

    public int getMainCost() {/**Getter (Accessor) for @param mainCost*/
        return mainCost;
    }

    public void setMainCost(int mainCost) {/**Setter (Mutator) for @param mainCost*/
        this.mainCost = mainCost;
    }

    public int getIntl() {/**Getter (Accessor) for @param intl*/
        return intl;
    }

    public void setIntl(int intl) {/**Setter (Mutator) for @param intl*/
        this.intl = intl;
    }

    public Constants.CRITERION getCriterion() {/**Getter (Accessor) for @param criterion*/
        return criterion;
    }

    public void setCriterion(Constants.CRITERION criterion) {/**Setter (Mutator) for @param criterion*/
        this.criterion = criterion;
    }

    public boolean isCommited() {/**Getter (Accessor) for @param commited*/
        return commited;
    }

    public void setCommited(boolean commited) {/**Setter (Mutator) for @param commited*/
        this.commited = commited;
    }

    public double getHappiness() {/**Getter (Accessor) for @param happiness*/
        return happiness;
    }

    public void setHappiness(double happiness) {/**Setter (Mutator) for @param happiness*/
        this.happiness = happiness;
    } 
}
