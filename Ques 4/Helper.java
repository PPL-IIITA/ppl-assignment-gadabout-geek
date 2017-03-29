package Utils;

import java.util.*;
import Boys.*;
import Girls.*;
import Gifts.*;
import Utils.*;

public class Helper/*! \brief A Utility class created to Help in forming couples, and start gifting
    *
    *class created to Help in forming couples, and start gifting
    */{
/**object of logger utility*/
    public MyLogger logger;
    public Helper(){
    	try{
            logger = new MyLogger();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	public ArrayList<Relationship> formCouple(ArrayList<Boy> boys, ArrayList<Girl> girls){/** a function which takes arguments as Lists of all boys and all girls @param miserBoyList, @param generousBoyList, @param geekBoyList, @param choosyGirlList, @param normalGirlList, @param desperateGirlList*/
		ArrayList<Relationship> relList = new ArrayList<Relationship> ();
		Relationship rel;
		for(int i = 0; i < girls.size(); i++){
			rel = new Relationship();
			if(girls.get(i).isCommited() == true){
				continue;
			}
			rel = setRelationship(girls.get(i), boys);
			if(rel != null){
				relList.add(rel);
				Girl g = girls.get(i);
				g.setCommited(true);
				girls.set(i, g);
			}
		}
		return relList;
	}

	public Relationship setRelationship(Girl girl, ArrayList<Boy> boys){/**overloaded function to assign relationship if @param girl is choosy with @param geekBoyList, @param generousBoyList, @param miserBoyList*/
        Relationship rel = new Relationship();
        Boy boy = new Boy();
        initiate(boy);
        int index = 0;
        int flag = 0;
        switch(girl.getCriterion()){
            case MOST_INTELLIGENT:
                for(int i = 0; i < boys.size(); i++){
                    if(boys.get(i).getIntl() > boy.getIntl() && boys.get(i).getMinAttr() <= girl.getAttr()  && boys.get(i).isCommited() == false){
                        boy = boys.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    rel.setGirl(girl);
                    boy.setCommited(true);
                    boys.set(index, boy);
                    rel.setBoy(boy);
                }
            break;

            case MOST_RICH:
                for(int i = 0; i < boys.size(); i++){
                    if(boys.get(i).getBudget() > boy.getBudget() && boys.get(i).getMinAttr() < girl.getAttr()  && boys.get(i).isCommited() == false){
                        boy = boys.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    rel.setGirl(girl);
                    boy.setCommited(true);
                    boys.set(index, boy);
                    rel.setBoy(boy);
                }

            break;

            case MOST_ATTRACTIVE:
                for(int i = 0; i < boys.size(); i++){
                    if(boys.get(i).getAttr() > boy.getAttr() && boys.get(i).getMinAttr() < girl.getAttr()  && boys.get(i).isCommited() == false){
                        boy = boys.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    rel.setGirl(girl);
                    boy.setCommited(true);
                    boys.set(index, boy);
                    rel.setBoy(boy);
                }

            break;

        }
        //logger.log.info("Girl = "+girl.getName()+" and Boy = "+boy.getName()+"\n\n");
        return rel;
    }
    
    private void initiate(Boy boy){/**to initialize*/
        boy.setAttr(0);
        boy.setBudget(0);
        boy.setIntl(0);
        boy.setMinAttr(0);
    }

	public void startGifting(ArrayList<Relationship> relationships, ArrayList<Gift> gList){/**Function which will initiate gifting to each relationship*/
		for(int i = 0 ;i < relationships.size(); i++){
			relationships.get(i).gifting(gList);
		}
        for(int i = 0 ;i < relationships.size(); i++){
            ArrayList<Gift> gifts = relationships.get(i).getGifts();
            for(int j = 0; j < gifts.size(); j++){
             //   logger.log.info("Boy "+ relationships.get(i).getBoy().getName() + " gifts Gift of Price "+ gifts.get(j).getPrice() + "\n and value "+gifts.get(j).getValue()+" to Girl "+relationships.get(i).getGirl().getName()+"\n\n");
            }
        }
	}

    private boolean getCommited__(Boy boy, ArrayList<Boy> boys){
        for(int i = 0; i < boys.size(); i++){
            if(boys.get(i).getName().equals(boy.getName())){
                return boys.get(i).isCommited();
            }
        }
        return false;
    }

    private void setCommited__(Boy boy, ArrayList<Boy> boys, boolean b){
        for(int i = 0; i < boys.size(); i++){
            if(boys.get(i).getName().equals(boy.getName())){
                Boy btemp = boys.get(i);
                btemp.setCommited(b);
                boys.set(i, btemp);
                break;
            }
        }
    }

    public void breakup(ArrayList<Relationship> relationships, ArrayList<Boy> boys, int k){
        ArrayList<Relationship> r = new ArrayList<Relationship>(relationships);
        ArrayList<Relationship> brkrel = new ArrayList<Relationship>();
        Collections.sort(r);
        for(int i = 0; i < k; i++){
            logger.log.info("Girl = "+r.get(i).getGirl().getName()+" Breaks up with "+r.get(i).getBoy().getName()+"\n\n");
            brkrel.add(r.get(i));
            brkrel.get(i).getBoy().setCommited(false);
            brkrel.get(i).getGirl().setCommited(false);
        }
        logger.log.info("New Relationships: ");
        for(int i = 0; i < k; i++){ 
            Relationship temp = new Relationship();
            boolean prevBoyStatus = getCommited__(brkrel.get(i).getBoy(), boys);
            if(!prevBoyStatus){
                setCommited__(brkrel.get(i).getBoy(), boys, true);
                temp = setRelationship(brkrel.get(i).getGirl(), boys);
                setCommited__(brkrel.get(i).getBoy(), boys, false);
            }
            else{
                temp = setRelationship(brkrel.get(i).getGirl(), boys);
            }
            logger.log.info("Girl "+temp.getGirl().getName()+" and Boy "+temp.getBoy().getName()+" are into a relationship\n\n");
        }   
    }
}