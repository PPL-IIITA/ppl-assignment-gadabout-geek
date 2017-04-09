package Main;
import Boys.*;
import Girls.*;
import Utils.*;
import Gifts.*;
import java.io.*;
import java.util.*;

public class Ques5/*! \brief Main Class
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

		int randomNum;
		String s;
		randomNum = ((new Random()).nextInt());
		if(randomNum%2 == 0){
			relationships = helper.formCouple(boys, girls);
			s="Generated Couples using Technique in Ques 1";
		} 
		else{
			relationships = helper.formCoupleModified(boys, girls);	
			s="Generated Couples using Technique in Ques 5";
		}
		
        int k = new Random().nextInt(10);
		helper.startGifting(relationships, gifts);
		helper.printKbest(relationships, k);
		
		System.out.print(s+"\n");
	}
}
