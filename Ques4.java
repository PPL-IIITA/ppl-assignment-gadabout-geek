package Main;
import Boys.*;
import Girls.*;
import Utils.*;
import Gifts.*;
import java.io.*;
import java.util.*;

public class Ques4/*! \brief Main Class for Ques 4
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
		
		helper.startGifting(relationships, gifts);

		int k = new Random().nextInt(10); //random value of k is generated, we can assign any value of k here which should be less than size of relationship Arraylist, generally k < 10 works efficiently.
		
		helper.breakup(relationships, boys, girls,k);
	}
}
