package Main;
import Boys.*;
import Girls.*;
import java.io.*;
import Utils.*;
import Gifts.*;
import java.util.*;

public class Ques6/*! \brief Main Class for Ques 6
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

		int choice = r.nextInt(30); //Generating t days

		ArrayList<Integer> markingsOfTheMonth = new ArrayList<Integer>();//markingsOfTheMonth is an arraylist having 0's and 1's denoting to perform the scene on the particular day of not.

		for(int i = 0; i < 30; i++){
			markingsOfTheMonth.add(0);
		}
		for(int i = 0; i < choice; i++){
			markingsOfTheMonth.set(r.nextInt(30), 1); //randomly selecting t days
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
