package Main;
import Boys.*;
import Girls.*;
import java.io.*;
import Utils.*;
import Gifts.*;
import java.util.*;

public class Ques8/*! \brief Main Class for Ques 8
    *
    *The Driver Class
    */{
	public static void main(String[] args) throws IOException{/**Main Function*/
		File file = new File("Log/log.xml");
        FileWriter fw = new FileWriter(file);
        fw.write("");
        fw.close();
		RandomInput randomInput = new RandomInput();
		randomInput.generate();
		ArrayList<Boy> boys = new ArrayList<Boy> ();
		ArrayList<Girl> girls = new ArrayList<Girl> ();
		ArrayList<Gift> gifts = new ArrayList<Gift>();
		ArrayList<Relationship> relationships = new ArrayList<Relationship>();
		InputReader reader  = new InputReader();
		Helper helper = new Helper();

		reader.readInputBoys(boys);
		reader.readInputGirls(girls);
		reader.readInputGifts(gifts);
		relationships = helper.formCouple(boys, girls);


		int choice = new Random().nextInt(2);//choice = 1 for new technique and choice = 0 for old, fixing its value will lead to choosing specific technique


		if(choice == 0){
			helper.startGifting(relationships, gifts);
			System.out.print("\nGifting using the old Technique\n");
		}
		else{

			//just adding the new GiftSelector for new Gift Allocation

			for(int i = 0; i < relationships.size(); i++){
				GifterModified g = new GifterModified(relationships.get(i));
				relationships.get(i).setGifter(g);
			}
			helper.startGifting(relationships, gifts);
			System.out.print("\nGifting using the new Technique\n");
		}
		
	}
}
