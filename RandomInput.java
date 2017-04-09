package Utils;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RandomInput {

	private static final String FILENAME = "Utils/input.xml";
	private static String anyCriteria(){
		ArrayList<String> s = new ArrayList<String>();
		s.add("MOST_ATTRACTIVE");
		s.add("MOST_INTELLIGENT");
		s.add("MOST_RICH");
		return s.get((new Random()).nextInt(3));
	}
	public static void generate(){

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			Random r = new Random();
			String content="<?xml version=\"1.0\" encoding=\"UTF-8\"?><main>";
			for(int i = 0; i < 1000; i++){
				content += "<boy type=\""+r.nextInt(3)+"\">\n\t<name>boy"+i+"</name>\n\t<intl>"+r.nextInt(10)+"</intl>\n\t<budget>"+r.nextInt(2000)+"</budget>\n\t<attr>"+r.nextInt(10)+"</attr>\n\t<minAttr>"+r.nextInt(10)+"</minAttr>\n\t<commited>false</commited>\n\t<happiness>0</happiness>\n</boy>\n";
			}
			for(int i = 0; i < 100; i++){
				content += "<girl type=\""+r.nextInt(3)+"\">\n\t<name>girl"+i+"</name>\n\t<intl>"+r.nextInt(10)+"</intl>\n\t<mainCost>"+r.nextInt(2000)+"</mainCost>\n\t<attr>"+r.nextInt(10)+"</attr>\n\t<commited>false</commited>\n\t<criterion>"+anyCriteria()+"</criterion>\n\t<happiness>0</happiness>\n</girl>\n";
			}
			for(int i = 0; i < 100; i++){
				content += "<gift type=\""+r.nextInt(3)+"\">\n\t<price>"+r.nextInt(300)+"</price>\n\t<value>"+r.nextInt(10)+"</value>\n</gift>\n";
			}
			content += "</main>";
			fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write(content);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}