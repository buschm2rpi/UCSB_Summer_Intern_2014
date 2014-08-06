package NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import PreProcessing.DataStructure;

public class Test {
	
	// total words : 19012956
	
	private long total_words;
	
	// culture words : 	5516333
	// business words: 	2314802
	// politics words: 	2338477
	// science words : 	7864152
	// sports words : 	979192
	
	private long topic_words;
	
	private double pck;
	
	private double pxck;
	
	private Map<String,Integer> mp;
	
	public Test(String input, String output,String flag){
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			DataStructure ds = new DataStructure(reader, writer, flag);
			
			mp = ds.getWordCount();
			
			topic_words = ds.getTotal();
			
			
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	

}
