package Utils;

import Boys.*;
import Gifts.*;
import Girls.*;
import Utils.*;
import java.util.*;

public class GifterModified extends GiftSelector/*! \brief Child class of GiftSelector having the new way of gifting method
    *
    *class which maintains the gift transitions of every relationship of new type specified in Ques 8
    */{
	

	public GifterModified(Relationship relationship){/**Parameterized constructor for @param relationship*/
		super(relationship);
	}

	public GifterModified(){/*default constructor*/

	}

	public void gift(ArrayList<Gift> totalGifts){/**Function on giving the total list of gifts as parameter, sets the gift basket accordingly for respective couple*/ 
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		ArrayList<Gift> sortedGifts = new ArrayList<Gift>(totalGifts);
		Collections.sort(sortedGifts);
		int sum = 0;
		for(int i = 0; i < sortedGifts.size(); i++){
			if(sortedGifts.get(i) instanceof UtilityGift){
				gifts.add(sortedGifts.get(i));
				sum+=sortedGifts.get(i).getPrice();
				sortedGifts.add(i, null);
				break;
			}
		}
		for(int i = 0; i < sortedGifts.size(); i++){
			if(sortedGifts.get(i) instanceof LuxuryGift){
				gifts.add(sortedGifts.get(i));
				sum+=sortedGifts.get(i).getPrice();
				sortedGifts.add(i, null);
				break;
			}
		}
		for(int i = 0; i < sortedGifts.size(); i++){
			if(sortedGifts.get(i) instanceof EssentialGift){
				gifts.add(sortedGifts.get(i));
				sum+=sortedGifts.get(i).getPrice();
				sortedGifts.add(i, null);
				break;
			}
		}
		for(int i = 0; i < sortedGifts.size(); i++){
			if(sortedGifts.get(i) == null){
				continue;
			}
			else if(sum + sortedGifts.get(i).getPrice() <= relationship.getBoy().getBudget()){
				gifts.add(sortedGifts.get(i));
				sum+=sortedGifts.get(i).getPrice();
			}
		}
		relationship.setGifts(gifts);
	}
}