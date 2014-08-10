package NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Run {
	
	// test
	private static final String tweet = 
			"loan shouldnt hurting score long isnt being reported late Its most likely helping score";
		
	private static final String input = "data_preprocess/test08";
	
	private static final String output = "data_preprocess/test09_4.csv";
	
	
	public static void main(String[] args){
		
		Classificer c = new Classificer();
		
		ArrayList<String> tweets = new ArrayList<String>();
		
		//c.process(tweet);
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = null;
			
			while ((line = reader.readLine()) != null){
				tweets.add(line);
			}
			
			c.process(tweets,writer);
			
			writer.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
}
