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
	public ArrayList<Relationship> formCouple(ArrayList<MiserBoy> miserBoyList, ArrayList<GenerousBoy> generousBoyList, ArrayList<GeekBoy> geekBoyList, ArrayList<ChoosyGirl> choosyGirlList, ArrayList<NormalGirl> normalGirlList, ArrayList<DesperateGirl> desperateGirlList){/** a function which takes arguments as Lists of all boys and all girls @param miserBoyList, @param generousBoyList, @param geekBoyList, @param choosyGirlList, @param normalGirlList, @param desperateGirlList*/
		ArrayList<Relationship> relList = new ArrayList<Relationship> ();
		Relationship rel;
		for(int i = 0; i < choosyGirlList.size(); i++){
			rel = new Relationship();
			if(choosyGirlList.get(i).isCommited() == true){
				continue;
			}
			rel = rel.setRelationship(choosyGirlList.get(i), miserBoyList, geekBoyList, generousBoyList);
			if(rel != null){
				relList.add(rel);
				ChoosyGirl g = choosyGirlList.get(i);
				g.setCommited(true);
				choosyGirlList.set(i, g);
			}
		}
		
		for(int i = 0; i < normalGirlList.size(); i++){
			rel = new Relationship();
			if(normalGirlList.get(i).isCommited() == true){
				continue;
			}
			rel = rel.setRelationship(normalGirlList.get(i), miserBoyList, geekBoyList, generousBoyList);
			if(rel != null){
				relList.add(rel);
				NormalGirl g = normalGirlList.get(i);
				g.setCommited(true);
				normalGirlList.set(i, g);
			}
		}
		
		for(int i = 0; i < desperateGirlList.size(); i++){
			rel = new Relationship();
			if(desperateGirlList.get(i).isCommited() == true){
				continue;
			}
			rel = rel.setRelationship(desperateGirlList.get(i), miserBoyList, geekBoyList, generousBoyList);
			if(rel != null){
				relList.add(rel);
				DesperateGirl g = desperateGirlList.get(i);
				g.setCommited(true);
				desperateGirlList.set(i, g);
			}
		}
		return relList;
	}
	public void startGifting(ArrayList<Relationship> relationships, ArrayList<EssentialGift> list1, ArrayList<UtilityGift> list2, ArrayList<LuxuryGift> list3){/**Function which will initiate gifting to each relationship*/
		for(int i = 0 ;i < relationships.size(); i++){
			Relationship rel = relationships.get(i);
			rel.calculate(list1, list2, list3);
			relationships.set(i, rel);
		}
	}

	public void printKbest(ArrayList<Relationship> relationships, int k){/**function which prints k most happy and compatible couple*/
		Collections.sort(relationships);
		for(int i = 0; i < k; i++){
			System.out.println(i+1+"th happy is boy = "+relationships.get(i).getGifter().getFrom()+ "and girl = "+relationships.get(i).getGifter().getFrom()+"\n");
		}
	}
}