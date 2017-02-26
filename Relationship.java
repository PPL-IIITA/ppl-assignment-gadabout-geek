package Utils;

import java.util.*;
import Boys.*;
import Gifts.*;
import Girls.*;
import Utils.*;

public class Relationship implements Comparable<Relationship>/*! \brief A class for every Relationship
    *
    *relationship between which boy and which girl and gifting
    */{

    /**object of miserboy*/
    private MiserBoy miserBoy;
    /**object of generousboy*/
    private GenerousBoy generousBoy;
    /**object of geekBoy*/
    private GeekBoy geekBoy;
    /**object of normal girl*/
    private NormalGirl normalGirl;
    /**object of desperate girl*/
    private DesperateGirl desperateGirl;
    /**object of choosygirl*/
    private ChoosyGirl choosyGirl;
    private int index;
    /**object of logger utility*/
    public MyLogger logger;
    /*happiness of couple*/
    private double happiness;
    /*compatibility of couple*/
    private double compatibility;
    /**gifting utility object*/
    private Gifter gifter;

    public int compareTo(Relationship r){/**comparator for sorting*/
        Double d = new Double(""+(this.happiness - r.getHappiness()));
        return d.intValue();
    }
    public MiserBoy getMiserBoy() {/**getter*/
        return miserBoy;
    }

    public Gifter getGifter(){/**getter*/
        return gifter;
    }

    public void setMiserBoy(MiserBoy miserBoy) {/**setter*/
        this.miserBoy = miserBoy;
    }

    public GenerousBoy getGenerousBoy() {/**getter*/
        return generousBoy;
    }

    public void setGenerousBoy(GenerousBoy generousBoy) {/**setter*/
        this.generousBoy = generousBoy;
    }

    public GeekBoy getGeekBoy() {/**getter*/
        return geekBoy;
    }

    public void setGeekBoy(GeekBoy geekBoy) {/**setter*/
        this.geekBoy = geekBoy;
    }

    public NormalGirl getNormalGirl() {/**getter*/
        return normalGirl;
    }

    public void setNormalGirl(NormalGirl normalGirl) {/**setter*/
        this.normalGirl = normalGirl;
    }

    public DesperateGirl getDesperateGirl() {/**getter*/
        return desperateGirl;
    }

    public void setDesperateGirl(DesperateGirl desperateGirl) {/**setter*/
        this.desperateGirl = desperateGirl;
    }

    public ChoosyGirl getChoosyGirl() {/**getter*/
        return choosyGirl;
    }

    public void setChoosyGirl(ChoosyGirl choosyGirl) {/**setter*/
        this.choosyGirl = choosyGirl;
    }

    public double getHappiness(){/**getter*/
        return happiness;
    }

    public double getCompatibility(){/**getter*/
        return compatibility;
    }

    public void setHappiness(double f){/**setter*/
        this.happiness = f;
    }
    public void setCompatibility(double f){/**setter*/
        compatibility = f;
    }

    public Relationship(){/**defualt constructor*/
        miserBoy = null;
        try{
            logger = new MyLogger();
        }catch(Exception e){
            e.printStackTrace();
        }
        generousBoy = null;
        geekBoy = null;
        normalGirl = null;
        choosyGirl = null;
        desperateGirl = null;
    }

    public void calculate(ArrayList<EssentialGift> egs, ArrayList<UtilityGift> ugs, ArrayList<LuxuryGift> lgs){/**to calculate and assign happiness and compatibility*/
        gifter = new Gifter(this, egs, ugs, lgs);
        this.setHappiness(gifter.getHappiness());
        this.setCompatibility(gifter.getCompatibility());
    }

    public Relationship setRelationship(ChoosyGirl girl, ArrayList<MiserBoy> miserBoyList, ArrayList<GeekBoy> geekBoyList, ArrayList<GenerousBoy> generousBoyList){/**overloaded function to assign relationship if @param girl is choosy with @param geekBoyList, @param generousBoyList, @param miserBoyList*/
        MiserBoy msrB = new MiserBoy();
        GeekBoy gkkB = new GeekBoy();
        GenerousBoy genB = new GenerousBoy();
        initiate(msrB, gkkB, genB);
        int flag = 0;
        switch(girl.getCriterion()){
            case MOST_INTELLIGENT:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getIntl() > msrB.getIntl() && miserBoyList.get(i).getMinAttr() <= girl.getAttr()  && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setIntl(msrB.getIntl());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getIntl() > gkkB.getIntl() && geekBoyList.get(i).getMinAttr() <= girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setIntl(gkkB.getIntl());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getIntl() > genB.getIntl() && generousBoyList.get(i).getMinAttr() <= girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.choosyGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+msrB.getName()+"\n\n");
                }
                else if(flag == 2){
                    this.choosyGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+gkkB.getName()+"\n\n");
                }
                else if(flag == 3){
                    this.choosyGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+genB.getName()+"\n\n");
                }
            break;

            case MOST_RICH:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getBudget() > msrB.getBudget() && miserBoyList.get(i).getMinAttr() < girl.getAttr()  && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setBudget(msrB.getBudget());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getBudget() > gkkB.getBudget() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setBudget(gkkB.getBudget());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getBudget() > genB.getBudget() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.choosyGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;

                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+msrB.getName()+"\n\n");
                }
                else if(flag == 2){
                    this.choosyGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+gkkB.getName()+"\n\n");
                }
                else if(flag == 3){
                    this.choosyGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);                  
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+genB.getName()+"\n\n");
                }

            break;

            case MOST_ATTRACTIVE:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getAttr() > msrB.getAttr() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setAttr(msrB.getAttr());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getAttr() > gkkB.getAttr() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setAttr(gkkB.getAttr());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getAttr() > genB.getAttr() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.choosyGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+msrB.getName()+"\n\n");
                }
                else if(flag == 2){
                    this.choosyGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+gkkB.getName()+"\n\n");
                }
                else if(flag == 3){
                    this.choosyGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" and Boy = "+genB.getName()+"\n\n");
                }

            break;

        }
        return this;
    }
    public Relationship setRelationship(NormalGirl girl, ArrayList<MiserBoy> miserBoyList, ArrayList<GeekBoy> geekBoyList, ArrayList<GenerousBoy> generousBoyList){/**overloaded function to assign relationship if @param girl is normal with @param geekBoyList, @param generousBoyList, @param miserBoyList*/
        MiserBoy msrB = new MiserBoy();
        GeekBoy gkkB = new GeekBoy();
        GenerousBoy genB = new GenerousBoy();
        initiate(msrB, gkkB, genB);
        int flag = 0;
        switch(girl.getCriterion()){
            case MOST_INTELLIGENT:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getIntl() > msrB.getIntl() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setIntl(msrB.getIntl());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getIntl() > gkkB.getIntl() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setIntl(gkkB.getIntl());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getIntl() > genB.getIntl() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.normalGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.normalGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.normalGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }
            break;

            case MOST_RICH:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getBudget() > msrB.getBudget() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setBudget(msrB.getBudget());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getBudget() > gkkB.getBudget() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setBudget(gkkB.getBudget());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getBudget() > genB.getBudget() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.normalGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.normalGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.normalGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }

            break;

            case MOST_ATTRACTIVE:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getAttr() > msrB.getAttr() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setAttr(msrB.getAttr());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getAttr() > gkkB.getAttr() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setAttr(gkkB.getAttr());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getAttr() > genB.getAttr() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.normalGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.normalGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.normalGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }

            break;

        }
        return this;
    }

    public Relationship setRelationship(DesperateGirl girl, ArrayList<MiserBoy> miserBoyList, ArrayList<GeekBoy> geekBoyList, ArrayList<GenerousBoy> generousBoyList){/**overloaded function to assign relationship if @param girl is desperate with @param geekBoyList, @param generousBoyList, @param miserBoyList*/
        MiserBoy msrB = new MiserBoy();
        GeekBoy gkkB = new GeekBoy();
        GenerousBoy genB = new GenerousBoy();
        initiate(msrB, gkkB, genB);
        int flag = 0;
        switch(girl.getCriterion()){
            case MOST_INTELLIGENT:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getIntl() > msrB.getIntl() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setIntl(msrB.getIntl());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getIntl() > gkkB.getIntl() && geekBoyList.get(i).getMinAttr() < girl.getAttr()  && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setIntl(gkkB.getIntl());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getIntl() > genB.getIntl() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.desperateGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.desperateGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.desperateGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }
            break;

            case MOST_RICH:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getBudget() > msrB.getBudget() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setBudget(msrB.getBudget());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getBudget() > gkkB.getBudget() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setBudget(gkkB.getBudget());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getBudget() > genB.getBudget() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.desperateGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.desperateGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.desperateGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }

            break;

            case MOST_ATTRACTIVE:
                for(int i = 0; i < miserBoyList.size(); i++){
                    if(miserBoyList.get(i).getAttr() > msrB.getAttr() && miserBoyList.get(i).getAttr() < girl.getAttr() && miserBoyList.get(i).isCommited() == false){
                        msrB = miserBoyList.get(i);
                        flag = 1;
                        index = i;
                    }
                }
                gkkB.setAttr(msrB.getAttr());
                for(int i = 0; i < geekBoyList.size(); i++){
                    if(geekBoyList.get(i).getAttr() > gkkB.getAttr() && geekBoyList.get(i).getMinAttr() < girl.getAttr() && geekBoyList.get(i).isCommited() == false){
                        gkkB = geekBoyList.get(i);
                        flag = 2;
                        index = i;
                    }
                }
                genB.setAttr(gkkB.getAttr());
                for(int i = 0; i < generousBoyList.size(); i++){
                    if(generousBoyList.get(i).getAttr() > genB.getAttr() && generousBoyList.get(i).getMinAttr() < girl.getAttr() && generousBoyList.get(i).isCommited() == false){
                        genB = generousBoyList.get(i);
                        flag = 3;
                        index = i;
                    }
                }
                if(flag == 0){
                    return null;
                }
                else if(flag == 1){
                    this.desperateGirl = girl;
                    msrB.setCommited(true);
                    miserBoyList.set(index, msrB);
                    this.miserBoy = msrB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+msrB.getName());
                }
                else if(flag == 2){
                    this.desperateGirl = girl;
                    gkkB.setCommited(true);
                    geekBoyList.set(index, gkkB);
                    this.geekBoy = gkkB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+gkkB.getName());
                }
                else if(flag == 3){
                    this.desperateGirl = girl;
                    genB.setCommited(true);
                    generousBoyList.set(index, genB);
                    this.generousBoy = genB;
                    logger.log.info("Girl = "+girl.getName()+" Boy = "+genB.getName());
                }

            break;

        }
        return this;
    }


    private void initiate(MiserBoy msrB, GeekBoy gkkB, GenerousBoy genB){/**to initialize*/
        msrB.setAttr(0);
        msrB.setBudget(0);
        msrB.setIntl(0);
        msrB.setMinAttr(0);
        gkkB.setAttr(0);
        gkkB.setBudget(0);
        gkkB.setIntl(0);
        gkkB.setMinAttr(0);
        genB.setAttr(0);
        genB.setBudget(0);
        genB.setIntl(0);
        genB.setMinAttr(0);

    }
}