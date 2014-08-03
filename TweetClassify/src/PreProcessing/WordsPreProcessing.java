package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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

public class WordsPreProcessing {
	// file is encoded in ASCII
	private static final Charset charset = Charset.forName("US-ASCII");
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
		,"can","could","should","have","has","had","must"
		,"would","were","was","am","is","are","be","do","done","did","does"
		,"in","on"
		,"until","til","let","with","by","about","for","if","from"};
	
	// end of sentence symbols
	private static final String[] eos = {".","!","?","\n"};
	
	
	public static void username(String username){
		
	}
	
	public static void hashtag(String hashtag){
		
	}
	
	public static void smiley(String smiley){
		
	}
	
	public static void main(String[] args){
		
		try {
			// reader and writer
			BufferedReader reader1 = Files.newBufferedReader(Paths.get(input),charset);
			BufferedWriter writer1 = Files.newBufferedWriter(Paths.get(temp),charset);
				
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
					
					// extract hashtags, leave hashtag label
					if (word.contains("#")){
						hashtag(word);
						word = word.replaceAll("[#]\\d*", "#");
					}
					
					// remove @username and RT@username
					if (word.startsWith("RT") || word.contains("@")){
						username(word);
						continue;
					}
					//remove url
					String url = "http://.*|www\\..*|.*\\.com";
					
					String[] words_url = word.split(url);
					if (words_url.length > 0 ){
						word = words_url[0];
					}
					else if (word.matches(url)){
						word = word.replaceAll(url, "");
					}
					// same char sequence with a length more than 3, combine them into one
					/*String same_char_sequence = "(.)\1\1\1+";
					
					Pattern sequencePattern = Pattern.compile(same_char_sequence);
					Matcher sequenceMatcher = sequencePattern.matcher(word);
					
					while (sequenceMatcher.find()){
						String sequence = sequenceMatcher.group(1);
						String single = sequence.substring(0,1);
						word = word.replace(sequence,single);
						
					}*/
					// commend block above not work
					
					// remove parentheses
					word = word.replaceAll("[()\\[\\]{}<>]", "");
					
					// remove all digits word
					if (word.matches("\\d*")){
						continue;
					}
					
					// remove '.* 
					String[] temp2 = word.split("['].*");
					if (temp2.length > 0){
						word = temp2[0];
					}
					
					writer1.write(word+" ");	
					
				}
				writer1.newLine();
			}
			writer1.close();	
			
			BufferedReader reader2 = Files.newBufferedReader(Paths.get(temp),charset);
			BufferedWriter writer2 = Files.newBufferedWriter(Paths.get(output),charset);
			
			// tokenizer by token
			PTBTokenizer ptbt = new PTBTokenizer(reader2,new CoreLabelTokenFactory(),"");
				for (CoreLabel label; ptbt.hasNext();){
					label = (CoreLabel) ptbt.next();
					String word = label.toString();
					
					// convert the upper case letter in the first word of a sentence into lower case
					/*boolean endOfSentence = false;
					for (String s : eos){
						if (word.equals(s)){
							endOfSentence = true;
						}
					}
					
					if (endOfSentence){
						word = ((CoreLabel) ptbt.next()).toString();
						if (!(word.substring(1).matches(".*[A-Z]+.*"))){
							String fl = (word.substring(0, 1)).toLowerCase();
							word.replaceFirst("[A-Z]", fl);
						}
					}*/
					// the commented block is not working
					
					
					// skip certain words
					boolean skip = false;
					
					String[] cap_skip_words = new String[skip_words.length];
					
					for (int i = 0; i < skip_words.length; i++){
						cap_skip_words[i] = (skip_words[i].substring(0,1).toUpperCase())
								 + skip_words[i].substring(1); 
						
						if (word.equals(skip_words[i])){
							skip = true;
						}
					}
					
					for (String s : cap_skip_words){
						if (word.equals(s)){
							skip = true;
						}
					}
					
					if (skip){
						continue;
					}
					
					
					// concatenate the word and its successors if they all start with uppercase
					if (word.matches("[A-Z].*")){
						try {
					
							String successor = ((CoreLabel) ptbt.peek()).toString();
						
							while (successor.matches("[A-Z].*")){
								word += ((CoreLabel) ptbt.next()).toString();
								successor = ((CoreLabel) ptbt.peek()).toString();
							}
						}
						catch (NoSuchElementException e){
							
						}
					}
					
					// remove # in hashtag
					if (word.contains("#")){
						word = word.replaceAll("[#]\\d*", "");
					}
					
					// remove words length less than 3
					if ( word.length() < 3){
						continue;
					}
					// remove 're, n't
					if (word.length() == 3 && word.contains("'")){
						continue;
					}
					// remove all symbol word (might be smiley)
					if (!word.matches(".*[A-Za-z0-9]+.*")){
						smiley(word);
						continue;
					}
					
					
					writer2.write(word + " ");
				}
				writer2.close();
		
		}
		catch (IOException e){
			System.err.print(e);
		}
		
		
	}

}
