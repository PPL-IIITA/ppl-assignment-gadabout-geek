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
	public ArrayList<Relationship> formCoupleModified(ArrayList<Boy> boys, ArrayList<Girl> girls){/** a function which takes arguments as Lists of all boys and all girls @param miserBoyList, @param generousBoyList, @param geekBoyList, @param choosyGirlList, @param normalGirlList, @param desperateGirlList*/
		ArrayList<Relationship> relList = new ArrayList<Relationship> ();
		Relationship rel;
        int i, j;
        i = 0;
        j = 0;
        for(int count = 0; i < boys.size() && j < girls.size(); count++){
            if(count%2 == 0){
                Boy singleboy = null;
                while(i < boys.size()){
                    if(boys.get(i).isCommited() == false){
                        singleboy = boys.get(i);
                        break;
                    }
                    i++;
                }
                if(singleboy == null){
                    break;
                }
                rel = setRelationship(singleboy, girls);
                if(rel != null){
                    relList.add(rel);
                    singleboy.setCommited(true);
                    boys.set(i, singleboy);
                }
                else{
                    i++;
                }
            }
            else{
                Girl singlegirl = null;
                while(j < girls.size()){
                    if(girls.get(j).isCommited() == false){
                        singlegirl = girls.get(j);
                        break;
                    }
                    j++;
                }
                if(singlegirl == null){
                    break;
                }
                rel = setRelationship(singlegirl, boys);
                if(rel != null){
                    relList.add(rel);
                    singlegirl.setCommited(true);
                    girls.set(j, singlegirl);
                }
                else{
                    j++;
                }
            }
        }
		return relList;
	}

    public Relationship setRelationship(Boy boy, ArrayList<Girl> girls){

        Relationship rel = null;
        Girl g = new Girl();
        g.setMainCost(0);
        g.setAttr(0);
        int index=-1;
        for(int i = 0; i < girls.size(); i++){
            if(girls.get(i).getMainCost() < boy.getBudget() && girls.get(i).isCommited() == false){
                if(g.getAttr() < girls.get(i).getAttr()){
                    g = girls.get(i);
                    index = i;
                }
            }
        }
        if(index == -1){
            return null;
        }
        rel = new Relationship();
        rel.setGirl(g);
        rel.setBoy(boy);
        g.setCommited(true);
        girls.set(index, g);
        logger.log.info("Boy = "+boy.getName()+" and Girl = "+g.getName()+"\n\n");
        return rel;
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
        logger.log.info("Girl = "+girl.getName()+" and Boy = "+boy.getName()+"\n\n");
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
                logger.log.info("Boy "+ relationships.get(i).getBoy().getName() + " gifts Gift of Price "+ gifts.get(j).getPrice() + "\n and value "+gifts.get(j).getValue()+" to Girl "+relationships.get(i).getGirl().getName()+"\n\n");
            }
        }
	}

	public void printKbest(ArrayList<Relationship> relationships, int k){/**function which prints k most happy and compatible couple*/
		Collections.sort(relationships);
		for(int i = 0; i < k; i++){
			System.out.println(i+1+"th happy is boy = "+relationships.get(i).getBoy().getName()+ "and girl = "+relationships.get(i).getGirl().getName()+"\n");
		}
	}
}