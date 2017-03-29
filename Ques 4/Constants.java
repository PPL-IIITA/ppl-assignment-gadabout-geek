package Utils;
public class Constants/*! \brief Class created for defining Constants
    *
    *Contains all constants regarding types of girls, boys, gifts and criteria a girl chooses
    */{
    public static enum GIRL_TYPE{/**enum of girl type*/
        CHOOSY(0),
        NORMAL(1),
        DESPERATE(2);
        
        public int type;
        GIRL_TYPE(int type){
            this.type = type;
        }
        public static GIRL_TYPE fromType(int t){
            for (GIRL_TYPE a : GIRL_TYPE.values()) {
                    if (a.type == t) {
                        return a;
                    }
                }
            return null;
        }
    }
    
    public static enum BOY_TYPE{/**enum of boy type*/
        MISER(0),
        GENEROUS(1),
        GEEK(2);
        
        public int type;
        BOY_TYPE(int type){
            this.type = type;
        }

        public static BOY_TYPE fromType(int t){
            for (BOY_TYPE a : BOY_TYPE.values()) {
                    if (a.type == t) {
                        return a;
                    }
                }
            return null;
        }
    }
    
    public static enum GIFT_TYPE{/**enum of gift type*/
        UTILITY(0),
        LUXURY(1),
        ESSENTIAL(2);
        
        public int type;
        GIFT_TYPE(int type){
            this.type = type;
        }
        public static GIFT_TYPE fromType(int t){
            for (GIFT_TYPE a : GIFT_TYPE.values()) {
                    if (a.type == t) {
                        return a;
                    }
                }
            return null;
        }
    }
    
    public static enum CRITERION{/**criteria of choosing*/
        MOST_INTELLIGENT(0),
        MOST_RICH(1),
        MOST_ATTRACTIVE(2);
        
        int value;
        CRITERION(int type){
            this.value = value;
        }
    }
    
}
