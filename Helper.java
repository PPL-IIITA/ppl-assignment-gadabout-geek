package Utils;

import java.util.*;
import Boys.*;
import Girls.*;
import Gifts.*;
import Utils.*;

public class Helper/*! \brief A Utility class created to Help in forming couples, and start gifting
		    *
		    *class created to Help in forming couples, and start gifting and various task to perform in different questions
		    */{
			    /**object of logger utility*/
			    public MyLogger logger;
			    public Helper(){/*default constructor*/
				    try{
					    logger = new MyLogger();
				    }catch(Exception e){
					    e.printStackTrace();
				    }
			    }
			    public ArrayList<Relationship> formCouple(ArrayList<Boy> boys, ArrayList<Girl> girls){/** a function which takes arguments as Lists of all boys and all girls @param boys, @param girls and return the @param relationship arraylist*/
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
			    public ArrayList<Relationship> formCoupleModified(ArrayList<Boy> boys, ArrayList<Girl> girls){/** another function for another couple formation technique which takes arguments as Lists of all boys and all girls @param boys, @param girls and return the @param relationship arraylist*/
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
			    public Relationship setRelationship(Girl girl, ArrayList<Boy> boys){/**overloaded function to assign relationship @param girl with total boys Available*/
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
                public Relationship setRelationship(Boy boy, ArrayList<Girl> girls){/**overloaded function to assign relationship @param boy with total girls Available*/
                    
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

			    private boolean getCommited__(Boy boy, ArrayList<Boy> boys){/**overloaded get the respective @param boy 's status from total boys*/
				    for(int i = 0; i < boys.size(); i++){
					    if(boys.get(i).getName().equals(boy.getName())){
						    return boys.get(i).isCommited();
					    }
				    }
				    return false;
			    }

			    private void setCommited__(Boy boy, ArrayList<Boy> boys, boolean b){/**overloaded set the respective @param boy 's status from total boys*/
				    for(int i = 0; i < boys.size(); i++){
					    if(boys.get(i).getName().equals(boy.getName())){
						    Boy btemp = boys.get(i);
						    btemp.setCommited(b);
						    boys.set(i, btemp);
						    break;
					    }
				    }
			    }

			    private void setCommited__(Girl girl, ArrayList<Girl> girls, boolean b){/**overloaded set the respective @param girl's status from total girls*/
				    for(int i = 0; i < girls.size(); i++){
					    if(girls.get(i).getName().equals(girl.getName())){
						    Girl btemp = girls.get(i);
						    btemp.setCommited(b);
						    girls.set(i, btemp);
						    break;
					    }
				    }
			    }

			    public void breakup(ArrayList<Relationship> relationships, ArrayList<Boy> boys, ArrayList<Girl> girls, int k){/**function to perform breakup having less than @param k happiness*/
				    ArrayList<Relationship> r = new ArrayList<Relationship>(relationships);
				    ArrayList<Relationship> brkrel = new ArrayList<Relationship>();
				    if(r.size() <= 0){
					    return;
				    }
				    Collections.sort(r);
				    for(int i = 0; i < k; i++){
					    logger.log.info("Girl = "+r.get(i).getGirl().getName()+" Breaks up with "+r.get(i).getBoy().getName()+"\n\n");
					    brkrel.add(r.get(i));
					    brkrel.get(i).getBoy().setCommited(false);
					    setCommited__(brkrel.get(i).getBoy(), boys, false);
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
                public void printKbest(ArrayList<Relationship> relationships, int k){/**function which prints k most happy and compatible couple*/
					Collections.sort(relationships);
					for(int i = 0; i < k; i++){
						System.out.println(i+1+"th happy is boy = "+relationships.get(i).getBoy().getName()+ "and girl = "+relationships.get(i).getGirl().getName()+"\n");
					}
				}
		    }
