package Main;
import Boys.*;
import Girls.*;
import Utils.*;
import Gifts.*;
import java.util.*;

public class Main/*! \brief Main Class
    *
    *The Driver Class
    */{
	public static void main(String[] args) {/**Main Function*/
		ArrayList<Boy> boys = new ArrayList<Boy> ();
		ArrayList<Girl> girls = new ArrayList<Girl> ();
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		ArrayList<Relationship> relationships = new ArrayList<Relationship>();
		InputReader reader  = new InputReader();
		Helper helper = new Helper();

		reader.readInputBoys(boys);
		reader.readInputGirls(girls);
		reader.readInputGifts(gifts);

		int randomNum;
		randomNum = ((new Random()).nextInt());
		if(randomNum%2 == 0){
			System.out.println("Generating Couples using Technique in Ques 1");
			relationships = helper.formCouple(boys, girls);
		} 
		else{
			System.out.println("Generating Couples using Technique in Ques 5");
			relationships = helper.formCoupleModified(boys, girls);	
		}
		
		
		helper.startGifting(relationships, gifts);
		helper.printKbest(relationships, 5);
		System.out.print("\n\n"+randomNum+"\n\n");
	}
}