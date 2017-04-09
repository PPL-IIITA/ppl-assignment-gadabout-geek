package Utils;

import Boys.*;
import Gifts.*;
import Girls.*;
import Utils.*;
import java.util.*;

public class Gifter extends GiftSelector/*! \brief Child class of GiftSelector having the default way of gifting method
    *
    *class which maintains the gift transitions of every relationship
    */{
	
	public Gifter(Relationship relationship){/**Parameterized constructor for @param relationship*/
		super(relationship);
	}

	public Gifter(){/*default constructor*/

	}

	public void gift(ArrayList<Gift> totalGifts){/**Function on giving the total list of gifts as parameter, sets the gift basket accordingly for respective couple*/ 
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		ArrayList<Gift> sortedGifts = new ArrayList<Gift>(totalGifts);
		Collections.sort(sortedGifts);
		int sum = 0;
		if(relationship.getBoy() instanceof MiserBoy){
			for(int i = 0; i < sortedGifts.size(); i++){
				if(sum < relationship.getGirl().getMainCost()){
					gifts.add(sortedGifts.get(i));
					sum += sortedGifts.get(i).getPrice();
				}
				else
					break;
			}
		}
		else if(relationship.getBoy() instanceof GenerousBoy){
			for(int i =0; i < sortedGifts.size(); i++){
				if(sum + sortedGifts.get(i).getPrice() <= relationship.getBoy().getBudget()){
					gifts.add(sortedGifts.get(i));
					sum += sortedGifts.get(i).getPrice();
				}
				else
					break;
			}
		}
		else if(relationship.getBoy() instanceof GeekBoy){
			int i;
			for(i = 0; i < sortedGifts.size(); i++){
				if(sum < relationship.getGirl().getMainCost()){
					gifts.add(sortedGifts.get(i));
					sum += sortedGifts.get(i).getPrice();
				}
				else
					break;
			}
			for(; i < sortedGifts.size(); i++){
				if(sortedGifts.get(i) instanceof LuxuryGift && sum + sortedGifts.get(i).getPrice() < relationship.getBoy().getBudget()){
					gifts.add(sortedGifts.get(i));
				}
			}
		}
		relationship.setGifts(gifts);
	}
}