package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class DataConstruct {
	
	// path of the input file
	private static final String input = "data_preprocess/words/bag_culture.txt";
	// path of the output file
	private static final String output = "data_preprocess/words/bag_culture_d.txt";
	
	/*public static void main(String[] args){
		
		/*try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = "";
			String doc = "";
			
			while ((line = reader.readLine()) != null){
				doc += line; 
				
			}
			
			
			DataStructure dict = new DataStructure(doc);
			
			Map<String,Integer> mp = dict.getWordCount();
			Set<String> keys = dict.getWordSet();
			
			for(String s : keys){
				writer.write(s);
				writer.write("," + mp.get(s));
				writer.newLine();
			}
		writer.close();
		
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	//}
	

}
