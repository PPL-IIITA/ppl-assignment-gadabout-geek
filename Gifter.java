package Utils;

import Boys.*;
import Gifts.*;
import Girls.*;
import Utils.*;
import java.util.*;

public class Gifter/*! \brief Class as a utility in gifting
    *
    *class which maintains the gift transitions of every relationship
    */{
	/**relationship of which, gifting is maintained*/
	private Relationship relationship;
	/**gift from whom*/
	private String fromwhom;
	/**gift to whom*/
	private String towhom;
	/**list of essential gifts*/
	private ArrayList<EssentialGift> egs;
	/**list of utility gifts*/
	private ArrayList<UtilityGift> ugs;
	/**list of luxury gifts*/
	private ArrayList<LuxuryGift> lgs;
	class GiftBasket implements Comparable<GiftBasket>{/**nested class to maintain all the gift given*/
		public int value;
		public int price;
		public int type;
		public int compareTo(GiftBasket g){
			return this.price - g.price;
		}
	}

	public String getFrom(){/**getter of the name of who is gifting*/
		return fromwhom;
	}
	public String getTo(){/**setter of the name of who is gifting*/
		return towhom;
	}
	/**list of all the gifts given*/
	public ArrayList<GiftBasket> giftBasket;
	/**list of all the gifts available*/
	public ArrayList<GiftBasket> giftShop;
	public Gifter(Relationship relationship, ArrayList<EssentialGift> egs, ArrayList<UtilityGift> ugs, ArrayList<LuxuryGift> lgs){/**parameterized constructor*/
		this.relationship = relationship;
		this.egs = egs;
		this.ugs = ugs;
		this.lgs = lgs;
		this.giftBasket = new ArrayList<GiftBasket>();
		this.giftShop = new ArrayList<GiftBasket>();
		allocate();
	}
	public double getHappiness(){/**getter (accessor) which also calculates @param happiness*/
		int sum = 0;
		double f = 0;
		if(relationship.getMiserBoy() != null){
			fromwhom = relationship.getMiserBoy().getName();
			if(relationship.getChoosyGirl() != null){
				towhom = relationship.getChoosyGirl().getName();
				fill(giftBasket, relationship.getChoosyGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).value;
					if(giftBasket.get(i).type == 2){
						sum+=giftBasket.get(i).value;
					}
				}
				int temp = sum - relationship.getChoosyGirl().getMainCost();
				f = Math.log(temp);
			}
			else if(relationship.getNormalGirl() != null){
				towhom = relationship.getNormalGirl().getName();
				fill(giftBasket, relationship.getNormalGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price+giftBasket.get(i).value;
				}							
				sum-=relationship.getNormalGirl().getMainCost();
				f = sum;

			}
			else if(relationship.getDesperateGirl() != null){

				towhom = relationship.getDesperateGirl().getName();
				fill(giftBasket, relationship.getDesperateGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price;
				}
				f = Math.exp(sum);
			}
			int t = relationship.getMiserBoy().getBudget() - sum;
			f+= t;
			return f;
		}
		else if(relationship.getGeekBoy() != null){
			fromwhom = relationship.getGeekBoy().getName();
			int intl = 0;
			if(relationship.getChoosyGirl() != null){
				towhom = relationship.getChoosyGirl().getName();
				fill(giftBasket, relationship.getChoosyGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).value;
					if(giftBasket.get(i).type == 2){
						sum+=giftBasket.get(i).value;
					}
				}
				int temp = sum - relationship.getChoosyGirl().getMainCost();
				f = Math.log(temp);
				intl = relationship.getChoosyGirl().getIntl();
			}
			else if(relationship.getNormalGirl() != null){
				towhom = relationship.getNormalGirl().getName();
				fill(giftBasket, relationship.getNormalGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price+giftBasket.get(i).value;
				}
				sum-=relationship.getNormalGirl().getMainCost();
				f = sum;
				intl = relationship.getChoosyGirl().getIntl();
			}
			else if(relationship.getDesperateGirl() != null){
				towhom = relationship.getDesperateGirl().getName();
				fill(giftBasket, relationship.getDesperateGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price;
				}
				f = Math.exp(sum);

				intl = relationship.getChoosyGirl().getIntl();
			}
			int t = intl;
			f+= t;
			return f;
		}
		if(relationship.getGenerousBoy() != null){
			fromwhom = relationship.getGenerousBoy().getName();
			if(relationship.getChoosyGirl() != null){
				towhom = relationship.getChoosyGirl().getName();
				fill(giftBasket, relationship.getChoosyGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).value;
					if(giftBasket.get(i).type == 2){
						sum+=giftBasket.get(i).value;
					}
				}
				int temp = sum - relationship.getChoosyGirl().getMainCost();
				f = Math.log(temp);
			}
			else if(relationship.getNormalGirl() != null){
				towhom = relationship.getNormalGirl().getName();
				fill(giftBasket, relationship.getNormalGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price+giftBasket.get(i).value;
				}
				sum-=relationship.getNormalGirl().getMainCost();
				f = sum;
			}
			else if(relationship.getDesperateGirl() != null){
				towhom = relationship.getDesperateGirl().getName();
				fill(giftBasket, relationship.getDesperateGirl().getMainCost());
				for(int i = 0; i < giftBasket.size();i++){
					sum+=giftBasket.get(i).price;
				}
				f = Math.exp(sum);
			}
			return 2*f;
		}
		return f;
	}

	public void fill(ArrayList<GiftBasket> giftBasket, int total){/**to fill in all the gifts according to the requirement*/
		int sum = 0;
		for(int i = 0; sum <= total && i < giftShop.size(); i++){
			giftBasket.add(giftShop.get(i));
			sum+=giftShop.get(i).value;
			relationship.logger.log.info("Gifts: Boy = "+ fromwhom+ " to Girl = "+towhom+ " \nof price = "+giftShop.get(i).price+ " \nand of value = "+giftShop.get(i).value+"\n\n");
		}
	}

	public double getCompatibility(){/**returns compatibility of couple*/
		return 0;
	}
	public void allocate(){
		int j = 0;
		for(int i = 0; i < egs.size(); i++){
			GiftBasket g = new GiftBasket();
			g.value = egs.get(i).getValue();
			g.price = egs.get(i).getPrice();
			g.type = 0;
			giftShop.add(j, g);
			j++;
		}
		for(int i = 0; i < ugs.size(); i++){
			GiftBasket g = new GiftBasket();
			g.value = ugs.get(i).getValue();
			g.price = ugs.get(i).getPrice();
			g.type = 1;
			giftShop.add(j, g);
			j++;
		}
		for(int i = 0; i < lgs.size(); i++){
			GiftBasket g = new GiftBasket();
			g.value = lgs.get(i).getValue();
			g.price = lgs.get(i).getPrice();
			g.type = 3;
			giftShop.add(j, g);
			j++;
		}
		Collections.sort(giftShop);
	}
}