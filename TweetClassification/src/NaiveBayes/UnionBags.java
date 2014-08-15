package NaiveBayes;

/***
 *  Union all five bags , and construct bag_total which contains all words from wiki dataset
 *  
 */

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

public class UnionBags {
	
	
	
	private long total_words;
	
	private static final String input1 = "data_preprocess/words/bag_culture.txt";
	private static final String input2 = "data_preprocess/words/bag_business.txt";
	private static final String input3 = "data_preprocess/words/bag_politics.txt";
	private static final String input4 = "data_preprocess/words/bag_sports.txt";
	private static final String input5 = "data_preprocess/words/bag_science.txt";
	
	private static final String output = "data_preprocess/words/bag_total.txt";
	
	private static final String input6 = "data_preprocess/test05_p";
	
	private static final String output6 = "data_preprocess/test08";
	
	
	public UnionBags(){
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
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
			
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
		/*	BufferedReader reader = new BufferedReader(new FileReader(new File(input6)));
			
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
			
		} */
		
		
		
		
	
	
	
	
	

