    package Boys;

    import Utils.Constants;

    public class MiserBoy/*! \brief A type of Boy
    *
    *class with the attributes to describe a Miser Boy
    */{
        /**name of boy*/
        private String name;
        /** attraction of boy*/
        private int attr;
        /** budget of boy*/
        private int budget;
        /** intelligence of boy*/
        private int intl;
        /** min attraction required by boy*/
        private int minAttr;
        /** type of boy*/
        public final Constants.BOY_TYPE TYPE = Constants.BOY_TYPE.MISER;
        /** whether commited or not*/
        private boolean commited;
        /** happiness of boy*/
        private double happiness;

        public MiserBoy(String name, int attr, int budget, int intl, int minAttr, boolean commited, double happiness) {/**Parameterized Constructor to initialize the data members*/
        this.name = name;
        this.attr = attr;
        this.budget = budget;
        this.intl = intl;
        this.minAttr = minAttr;
        this.commited = commited;
        this.happiness = happiness;
        }

        public MiserBoy(){/**Default Constructor */
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
        
        public int getBudget() {/**Getter (Accessor) for @param budget*/
            return budget;
        }
        
        public void setBudget(int budget) {/**Setter (Mutator) for @param budget*/
            this.budget = budget;
        }
        
        public int getIntl() {/**Getter (Accessor) for @param intl*/
            return intl;
        }
        
        public void setIntl(int intl) {/**Setter (Mutator) for @param intl*/
            this.intl = intl;
        }
        
        public int getMinAttr() {/**Getter(Accessor) for @param minAttr*/
            return minAttr;
        }
        
        public void setMinAttr(int minAttr) {/**Setter(Mutator) for @param minAttr*/
            this.minAttr = minAttr;
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
