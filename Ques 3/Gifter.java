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
	private Relationship relationship;

	public Gifter(Relationship relationship){
		this.relationship = relationship;
	}

	public Gifter(){

	}

	public void gift(ArrayList<Gift> totalGifts){
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