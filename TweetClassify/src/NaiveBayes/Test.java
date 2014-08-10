package NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import PreProcessing.DataStructure;
import PreProcessing.PreProcessor;

public class Test {
	
	// total words : 19012956
	
	private long total_words;
	
	// business words: 	2314802 hashset size: 109764
	// culture words : 	5516333	hashset size: 244896
	// politics words: 	2338477	hashset size: 115319
	// science words : 	7864152	hashset size: 268368
	// sports words : 	979192	hashset size: 52810
	
	
	private static final String input1 = "data_preprocess/words/bag_culture.txt";
	private static final String input2 = "data_preprocess/words/bag_business.txt";
	private static final String input3 = "data_preprocess/words/bag_politics.txt";
	private static final String input4 = "data_preprocess/words/bag_sports.txt";
	private static final String input5 = "data_preprocess/words/bag_science.txt";
	
	private static final String output = "data_preprocess/words/bag_total.txt";
	
	private static final String input6 = "data_preprocess/test05_p";
	
	private static final String output6 = "data_preprocess/test08";
	
	
	public static void main(String[] args){
		
		try {
			
			/*BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = null;
			
			BufferedReader reader = new BufferedReader(new FileReader(new File(input1)));
			
			while ((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			reader = new BufferedReader(new FileReader(new File(input2)));
			
			while ((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			reader = new BufferedReader(new FileReader(new File(input3)));
			
			while ((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			reader = new BufferedReader(new FileReader(new File(input4)));
			
			while ((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			reader = new BufferedReader(new FileReader(new File(input5)));
			
			while ((line = reader.readLine()) != null){
				writer.write(line);
				writer.newLine();
			}
			
			writer.close();*/
			
			BufferedReader reader = new BufferedReader(new FileReader(new File(input6)));
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output6)));
			
			String line = null;
			
			PreProcessor p = new PreProcessor();
			
			while ((line = reader.readLine()) != null){
				String tweet = line.split("\t")[1];
				
				String[] tokens = tweet.split(" ");
				for (String t : tokens){
					if(p.cleanSkip(t)){
						writer.write(t + " ");
					}
					
				}
				
				writer.newLine();
				
			}
			
			writer.close();
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	

}
