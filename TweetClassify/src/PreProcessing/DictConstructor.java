package PreProcessing;

// this file will generate the topic specific dictionary

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.process.CoreLabelTokenFactory;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.process.PTBTokenizer;



/* Preprocessing each word in a file
 * 
 * 
 */

public class DictConstructor {
	
	// path of the input file
	private static final String input = "data_preprocess/apache_mahout/culture.txt";
	// path of the intermediary file
	private static final String temp = "data_preprocess/words/bag_temp.csv";
	// path of the output file
	private static final String output = "data_preprocess/words/bag_culture.txt";
	
	// speical characters , we want to keep in the words
	private static final String[] sp_characters = {"'","%","$","+","-","&","."};
	
	// words that we want to skip (length more than two)
	// keep mine and so on, us because of polysemy
	private static final String[] skip_words = {
		"the","a","an","and","then","but","so","yes","no","not"
		,"this","that","these","those","here","there"
		,"you","your","yours","she","her","hers","him","his","he","i","we","me"
		,"they","them","their","theirs","our","ours"
		,"what","when","where","how","why","which","while"
		,"whatever","whenever","wherever","however","whether","either","neither","too","to"
		,"can","could","should","have","has","had","must","let"
		,"would","were","was","am","is","are","be","do","done","did","does"
		,"in","on"
		,"until","til","let","with","by","about","for","if","from"};
	
	// end of sentence symbols
	private static final String[] eos = {".","!","?","\n"};
	
	/*public static void main(String[] args){
		
		PreProcessor pp = new PreProcessor();
		
		try {
			// reader and writer
			
			BufferedReader reader1 = new BufferedReader(new FileReader(new File(input)));
			BufferedWriter writer1 = new BufferedWriter(new FileWriter(new File(temp)));
				
			String line = null;
			// tokenization
			// string array list for saving all words, allow duplicates
			ArrayList<String> al = new ArrayList<String>();
			// string hashset for saving all words, not allow duplicates
			HashSet hs = new HashSet();
					
			// tweet preprocessing
			while ((line = reader1.readLine()) != null){
				
				String[] t2 = line.split(" ");
				
				for (int i = 0; i < t2.length; i++){
					
					String word = t2[i];
					
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
			
			
			pp.cleanToken(reader2,writer2);
			writer2.close();
			System.out.println(output + " done");
			
			
		
		}
		catch (IOException e){
			System.err.print(e);
		}
		
		
		
		
		
	}*/

}
