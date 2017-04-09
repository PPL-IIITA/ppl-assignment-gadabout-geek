package Utils;

import Boys.*;
import java.util.*;
import Gifts.*;
import Girls.*;
import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class InputReader/*! \brief A utility to Read the input
    *
    *class which reads the xml input file
    */{
	public InputReader(){ /**defualt constructor*/
	}
	public void readInputBoys(ArrayList<Boy> boys){/**function to read all input Boys in List @param boys as it is collection of references of Parent class Boy*/
		try{
			File f = new File("./Utils/input.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			doc.getDocumentElement().normalize();
			NodeList list = doc.getElementsByTagName("boy");
			for(int i = 0; i < list.getLength(); i++){
				Node nb = list.item(i);
				if (nb.getNodeType() == Node.ELEMENT_NODE){
					Element n = (Element)nb;
					Constants.BOY_TYPE type = Constants.BOY_TYPE.fromType(Integer.parseInt(n.getAttribute("type")));
					if(type == Constants.BOY_TYPE.MISER){
						MiserBoy boy = new MiserBoy(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("budget").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("minAttr").item(0).getTextContent()),
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						boys.add(boy);
					}
					else if(type == Constants.BOY_TYPE.GENEROUS){
						GenerousBoy boy = new GenerousBoy(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("budget").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("minAttr").item(0).getTextContent()),
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						boys.add(boy);
					}
					else if(type == Constants.BOY_TYPE.GEEK){
						GeekBoy boy = new GeekBoy(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("budget").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("minAttr").item(0).getTextContent()),
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						boys.add(boy);
					}
				}
			}

		}catch(Exception e){
		}
	}
	public void readInputGirls(ArrayList<Girl> girls){/**function to read all input Girls in List @param girls as girls being collection of Parent Class Girl's references*/
		try{
			File f = new File("./Utils/input.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			doc.getDocumentElement().normalize();
			NodeList list = doc.getElementsByTagName("girl");
			for(int i = 0; i < list.getLength(); i++){
				Node nb = list.item(i);
				if (nb.getNodeType() == Node.ELEMENT_NODE){
					Element n = (Element)nb;
					Constants.GIRL_TYPE type = Constants.GIRL_TYPE.fromType(Integer.parseInt(n.getAttribute("type")));
					if(type == Constants.GIRL_TYPE.CHOOSY){
						Constants.CRITERION c = Constants.CRITERION.valueOf(n.getElementsByTagName("criterion").item(0).getTextContent());
						ChoosyGirl girl = new ChoosyGirl(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("mainCost").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													c,
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						girls.add(girl);
					}
					else if(type == Constants.GIRL_TYPE.NORMAL){
						Constants.CRITERION c = Constants.CRITERION.valueOf(n.getElementsByTagName("criterion").item(0).getTextContent());
						NormalGirl girl = new NormalGirl(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("mainCost").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													c,
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						girls.add(girl);
					}
					else if(type == Constants.GIRL_TYPE.DESPERATE){
						Constants.CRITERION c = Constants.CRITERION.valueOf(n.getElementsByTagName("criterion").item(0).getTextContent());
						DesperateGirl girl = new DesperateGirl(n.getElementsByTagName("name").item(0).getTextContent(),
													Integer.parseInt(n.getElementsByTagName("attr").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("mainCost").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("intl").item(0).getTextContent()),
													c,
													Boolean.parseBoolean(n.getElementsByTagName("commited").item(0).getTextContent()),
													Double.parseDouble(n.getElementsByTagName("happiness").item(0).getTextContent()));
						girls.add(girl);
					}
				}
			}

		}catch(Exception e){
		}
	}
	public void readInputGifts(ArrayList<Gift> gifts){/**function to read all gifts in @param gifts as it being the Collection of parent class references*/
		try{
			File f = new File("./Utils/input.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(f);
			doc.getDocumentElement().normalize();
			NodeList list = doc.getElementsByTagName("gift");
			for(int i = 0; i < list.getLength(); i++){
				Node nb = list.item(i);
				if (nb.getNodeType() == Node.ELEMENT_NODE){
					Element n = (Element)nb;
					Constants.GIFT_TYPE type = Constants.GIFT_TYPE.fromType(Integer.parseInt(n.getAttribute("type")));
					if(type == Constants.GIFT_TYPE.UTILITY){
						UtilityGift gift = new UtilityGift(
													Integer.parseInt(n.getElementsByTagName("price").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("value").item(0).getTextContent()),
													0,0);
						gifts.add(gift);
					}
					if(type == Constants.GIFT_TYPE.ESSENTIAL){
						EssentialGift gift = new EssentialGift(
													Integer.parseInt(n.getElementsByTagName("price").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("value").item(0).getTextContent())
													);
						gifts.add(gift);
					}
					if(type == Constants.GIFT_TYPE.LUXURY){
						LuxuryGift gift = new LuxuryGift(
													Integer.parseInt(n.getElementsByTagName("price").item(0).getTextContent()),
													Integer.parseInt(n.getElementsByTagName("value").item(0).getTextContent()),
													0,0);
						gifts.add(gift);
					}
				}
			}

		}catch(Exception e){
		}
	}
}
