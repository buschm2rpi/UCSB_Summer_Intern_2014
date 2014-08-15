package PreProcessing;

/***
this file will generate the topic specific bag (something is similar to a dictionary)
***/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/* Preprocessing each word in a file
 * 
 * 
 */

public class BagConstructor {
	
	
	// path of the intermediary file
	private static final String temp = "data_preprocess/words/bag_temp.csv";
	
	public void Consturct(String tweet){
		PreProcessor pp = new PreProcessor();
		try{
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File(temp)));
		
		String[] t1 = tweet.split(" ");
		
		for (int i = 0; i < t1.length; i++){
			
			String word = t1[i];
			
			// clean words without stanford corenlp
			word = pp.clean(word);
			
			if (word != null){
				writer1.write(word+" ");	
			}
		}
		
		writer1.close();
		
		BufferedReader reader2 = new BufferedReader(new FileReader(new File(temp)));
		
		// clean words with stanford corenlp
		String cleaned = pp.cleanToken(reader2);
					
		System.out.println(cleaned);
		
		
		}
		catch (IOException e){
			System.err.print(e);
		}
		
		
	}
	
		
	
	
	public void Consturct(String input,String output){
		
		// text cleaner, details in PreProcessor comments
		PreProcessor pp = new PreProcessor();
		
		try {
			
			BufferedReader reader1 = new BufferedReader(new FileReader(new File(input)));
			BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File(temp)));
				
			String line = null;
					
			while ((line = reader1.readLine()) != null){
				
				String[] t2 = line.split(" ");
				
				for (int i = 0; i < t2.length; i++){
					
					String word = t2[i];
					
					// clean words without stanford corenlp
					word = pp.clean(word);
					
					if (word != null){
						writer1.write(word+" ");	
					}
				}
				writer1.newLine();
			}
			
			writer1.close();	
			
			
			BufferedReader reader2 = new BufferedReader(new FileReader(new File(temp)));
			BufferedWriter writer2 = new BufferedWriter(new FileWriter(new File(output)));
			
			// clean words with stanford corenlp
			pp.cleanToken(reader2,writer2);
			writer2.close();
			System.out.println(output + " done");
		}
		catch (IOException e){
			System.err.print(e);
		}
		
	}

}
