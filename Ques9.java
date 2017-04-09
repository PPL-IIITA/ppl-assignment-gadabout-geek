package Main;
import Boys.*;
import Girls.*;
import Utils.*;
import Gifts.*;
import java.io.*;
import java.util.*;

public class Ques3/*! \brief Main Class
    *
    *The Driver Class
    */{
	public static void main(String[] args) throws IOException{/**Main Function*/
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
    }
}
