package Main;
import Boys.*;
import Girls.*;
import java.io.*;
import Utils.*;
import Gifts.*;
import java.util.*;

public class Ques6/*! \brief Main Class
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
		
		helper.startGifting(relationships, gifts);

		Random r = new Random();
		int choice = r.nextInt(30);
		ArrayList<Integer> markingsOfTheMonth = new ArrayList<Integer>();
		for(int i = 0; i < 30; i++){
			markingsOfTheMonth.add(0);
		}
		for(int i = 0; i < choice; i++){
			markingsOfTheMonth.set(r.nextInt(30), 1);
		}
		for(int i = 0; i < 30; i++){
			if(markingsOfTheMonth.get(i) == 1){
				System.out.print("For Day: "+(i+1)+"\n\n\n\n");
				relationships = helper.formCouple(boys, girls);
				helper.startGifting(relationships, gifts);
				helper.breakup(relationships, boys, girls,choice);
			}
		}
		
	}
}
