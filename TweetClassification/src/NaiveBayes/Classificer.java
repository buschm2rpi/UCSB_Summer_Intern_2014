package NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import PreProcessing.DataStructure;

public class Classificer {
	
	// input path of five topic bag of words
	private static final String input1 = "data_preprocess/words/bag_culture.txt";
	private static final String input2 = "data_preprocess/words/bag_business.txt";
	private static final String input3 = "data_preprocess/words/bag_politics.txt";
	private static final String input4 = "data_preprocess/words/bag_sports.txt";
	private static final String input5 = "data_preprocess/words/bag_science.txt";
	private static final String input0 = "data_preprocess/words/bag_total.txt";
	
	// topic words size , topic vocabulary size and total word size in testing (the way to calculate these on in readme.txt)
	private static final double CultureSize = 5516333;
	private static final double CultureVocabulary = 244896;
	private static final double BusinessSize = 2314802;
	private static final double BusinessVocabulary = 109764;
	private static final double PoliticsSize = 2338477;
	private static final double PoliticsVocabulary = 115319;
	private static final double SportsSize = 979192;
	private static final double SportsVocabulary = 52810;
	private static final double ScienceSize = 7864152;
	private static final double ScienceVocabulary = 268368;
	private static final double total = 19012956;

	// Array for each input path, input0 to input5
	private static String[] inputs = {input0, input1, input2, input3, input4, input5};
	
	// Array for each topic words size
	private static double[] topicWordSizes = {CultureSize, BusinessSize, PoliticsSize, SportsSize, ScienceSize};
	
	// Array for each topic vocabulary size
	private static double[] topicVocabularySizes = {CultureVocabulary, BusinessVocabulary, PoliticsVocabulary, SportsVocabulary, ScienceVocabulary};
	
	// ArrayList for all words in all bags
	private static ArrayList<String> totalWords = new ArrayList<String>();
	
	// ArrayList for all words in topic culture bag
	private static ArrayList<String> t1 = new ArrayList<String>();
	
	// ArrayList for all words in topic business bag
	private static ArrayList<String> t2 = new ArrayList<String>();
	
	// ArrayList for all words in topic politics bag
	private static ArrayList<String> t3 = new ArrayList<String>();
	
	// ArrayList for all words in topic sports bag
	private static ArrayList<String> t4 = new ArrayList<String>();
	
	// ArrayList for all words in topic science bag
	private static ArrayList<String> t5 = new ArrayList<String>();
	

	// if it is a new word which is not in any topic bag, we may do reinforcement learning in the future
	private void newWord(String word){
		
	}
	
	/*** compute the likelyhood value : probability of a word x given condition topic ck, 
	which means the frequency of a word in a topic bag
	
	parameters 
	count: the number of times a word x appears in a topic bag
	countAll: the number of times a word x appears in all topic bags
	topicSize: the number of words a topic bag contains (count duplicated same words)
	topicVocabulary : the kind of words a topic bag contains (not count duplicated same words) ***/
	
	private double likelyhood(double count, double countAll
			,double topicSize, double topicVocabulary) {
		
		// likelyhood value
		double pxck = 0;
		
		double tfidf = count / countAll;
		
		
		/*** the original formula is pxck = count / topicSize
		try to avoid 0 probability issue ( when a new word which is not exist in a topic bag,then count would be 0)
		0 probability solution : add 1 smoothing
		add 1 smoothing : pxck = ( 1 + count) / (topicVocabulary + topicSize)
		so if it is a new word for a topic bag, then pxck = (1 + 0) / (topicVocabulary + topicSize)
		count/countAll : give weights for a word frequency, the concept came from term frequency-inverse document frequency (tf-idf)
		count * (count/countAll), which means the word frequency in a topic bag should be balanced with its frequency in all topic bags
		reason for this tf-idf : a word w1 which only appears in a topic bag t1 should weight more than 
		a word w2 which appears in several topic bags and has same frequency with w1 in topic bag t1 ***/   
		
		pxck = ( 1 + count  * tfidf ) / ( topicVocabulary + topicSize );
		
		
		// System.out.println("lieklyhood value: " + pxck);
		
		return pxck;
	}
	
	
	// constructor for loading all topic bags 
	public Classificer(){
		
		String line = null;
		
		try {
			// load all words in all topic bags into ArrayList totalWords
			BufferedReader reader = new BufferedReader(new FileReader(new File(inputs[0])));
			while ((line = reader.readLine()) != null){
				totalWords.addAll(Arrays.asList(line.split(" ")));
			}
			
			// load all words in topic culture bag into ArrayList t1
			reader = new BufferedReader(new FileReader(new File(inputs[1])));
			while ((line = reader.readLine()) != null){
				t1.addAll(Arrays.asList(line.split(" ")));
			}
			
			// load all words in topic business bag into ArrayList t2
			reader = new BufferedReader(new FileReader(new File(inputs[2])));
			while ((line = reader.readLine()) != null){
				t2.addAll(Arrays.asList(line.split(" ")));
			}
			
			// load all words in topic politics bag into ArrayList t3
			reader = new BufferedReader(new FileReader(new File(inputs[3])));
			while ((line = reader.readLine()) != null){
				t3.addAll(Arrays.asList(line.split(" ")));
			}
			
			// load all words in topic sports bag into ArrayList t4
			reader = new BufferedReader(new FileReader(new File(inputs[4])));
			while ((line = reader.readLine()) != null){
				t4.addAll(Arrays.asList(line.split(" ")));
			}
			
			// load all words in topic science bag into ArrayList t5
			reader = new BufferedReader(new FileReader(new File(inputs[5])));
			while ((line = reader.readLine()) != null){
				t5.addAll(Arrays.asList(line.split(" ")));
			}
			
			System.out.println("Loading all topic bags...done");
			
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
	// process single tweet
	public String process(String tweet){
		
		// Preprocess tweet content, details see the comments in DataStructure class
		DataStructure ds = new DataStructure(tweet);
		
		// get the set of words for a tweet ( no duplicates )
		// return type is a hashset so the word order in the set may not be the same as they are in the tweet
		Set<String> wordSet = ds.getWordSet();
		
		// tmep array for store each word total count in all bags
		ArrayList<Double> countAllList = new ArrayList<Double>();
		
		for (String s: wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
					countAll++;
				}	
			}
			countAllList.add(countAll);
		}
		
		// five topic scores for five topics classification
		// s1 -1.5, s2 -0.5, s3 +0.5, s4, s5 -4   extra weights added to balance the words distribution in wiki dataset
		double s1 = classify(wordSet, countAllList, t1, topicWordSizes[0], topicVocabularySizes[0]) - 1.5;
		double s2 = classify(wordSet, countAllList, t2, topicWordSizes[1], topicVocabularySizes[1]) - 0.5;
		double s3 = classify(wordSet, countAllList, t3, topicWordSizes[2], topicVocabularySizes[2]) + 0.5;
		double s4 = classify(wordSet, countAllList, t4, topicWordSizes[3], topicVocabularySizes[3]);
		double s5 = classify(wordSet, countAllList, t5, topicWordSizes[4], topicVocabularySizes[4]) - 4.0;
		
		// console log
		System.out.println("Culture score: " + s1
				+ "\nBusiness score: " + s2
				+ "\nSports score: " + s4
				+ "\nPolitics score: " + s3
				+ "\nScience score: " + s5);
		
		// console log, pick the max score
		double[] pick = {s1,s2,s3,s4,s5};
		int flag = 0;
		
		double max = -999;
		
		for (int i = 0; i < pick.length; i++){
			if (pick[i] > max){
				max = pick[i];
				flag = i+1;
			}
		}
		
		String label = "";
		if (flag == 1){
			label = "Culture";
		}
		else if (flag == 2){
			label = "Business";	
		}
		else if (flag == 3){
			label = "Sports";
		}
		else if (flag == 4){
			label = "Politics";
		}
		else if (flag == 5){
			label = "Science";
		}
		
		System.out.println("tweet: \""+ tweet + "\"" + " is related to " + label);
				
		// return tweet,culture score,business score,sports score, science score
		// using return string to writer into csv file in outer function call
		return (tweet 
				+ "," + s1 
				+ "," + s2
				+ "," + s4
				+ "," + s3
				+ "," + s5);
		
	}
	
	// process for tweets input file
	public void process(BufferedReader reader, BufferedWriter writer){
		
		String line = null;
		
		try {
			// read each line in the file
			while ((line = reader.readLine()) != null){
			// write tweet and its five scores
				writer.write(process(line));
				writer.newLine();
			}
			
			System.out.println("All tweets has been processed. Done.");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Double classify( Set<String> wordSet, ArrayList<Double> countAllList, ArrayList<String> topicWords, double WordSize, double VocabularySize){
		
		/*** probability for choosing a certain topic ck among all topics in out system
		calculate the number of words in topic ck over the number of words in all topics (count duplicates)
		make sure that both WordSize and total parameter are type double   ***/
		
		
		
		double pck = WordSize / total;
		
		// int WordNum = wordSet.size();  // number of unique words in a tweet, maybe use in the future
		
		//System.out.println("pck: " + pck);
		
		// ArrayList for each likelyhood probability for each word in a tweet 
		ArrayList<Double> likelyList = new ArrayList<Double>();
		
		int i = 0;
		// calculate likelyhood value for each word in the tweet ( not count duplicates)
		for (String s : wordSet){
			
			// skip empty token
			if (s.equals("")){
				continue;
			}
			
			// count: time of word s in topic bag ck
			// countAll: time of word s in all topic bags
			double count = 0;
			
			double countAll = countAllList.get(i);
			i++;
			
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			//System.out.println("count: " + count);
			
			// if word s is a new word beyond our knowledge base
			if (countAll == 0){
				
				//System.out.println("!!New word: "+s);
				// not implement, maybe in future
				newWord(s);
				// assign countAll to 1, avoid being divided by 0 problem
				countAll = 1;
			}
			
			// details in likeyhood function comments
			likelyList.add(likelyhood(count,countAll,WordSize,VocabularySize));			
		}
		
		// init score
		// avoid under flow problem, solution: using summation of log(likelyhood) instead of product of likelyhood
		double score = Math.log(pck);
		
		for (Double d: likelyList){	
			score += Math.log(d);
		}
		return score; 
	}
}
