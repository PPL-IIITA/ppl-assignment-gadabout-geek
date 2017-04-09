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
		ArrayList<MiserBoy> miserBoy = new ArrayList<MiserBoy> ();
		ArrayList<GenerousBoy> generousBoy = new ArrayList<GenerousBoy> ();
		ArrayList<GeekBoy> geekBoy = new ArrayList<GeekBoy> ();
		ArrayList<NormalGirl> normalGirl = new ArrayList<NormalGirl> ();
		ArrayList<DesperateGirl> desperateGirl = new ArrayList<DesperateGirl> ();
		ArrayList<ChoosyGirl> choosyGirl = new ArrayList<ChoosyGirl> ();
		ArrayList<Relationship> relationships = new ArrayList<Relationship>();
		InputReader reader  = new InputReader();
		reader.readInputBoys(miserBoy, generousBoy, geekBoy);
		reader.readInputGirls(choosyGirl, normalGirl, desperateGirl);
		Helper helper =  new Helper();
		relationships = helper.formCouple(miserBoy, generousBoy, geekBoy, choosyGirl, normalGirl, desperateGirl);
		ArrayList<EssentialGift> egs = new ArrayList<EssentialGift>();
		ArrayList<UtilityGift> ugs = new ArrayList<UtilityGift>();
		ArrayList<LuxuryGift> lgs = new ArrayList<LuxuryGift>();
		reader.readInputGifts(egs, ugs, lgs);
		helper.startGifting(relationships, egs, ugs, lgs);
		helper.printKbest(relationships, 5);
	}
}