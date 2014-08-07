package NaiveBayes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import PreProcessing.DataStructure;



public class Classificer {
	
	private static final String input1 = "data_preprocess/words/bag_culture.txt";
	private static final String input2 = "data_preprocess/words/bag_business.txt";
	private static final String input3 = "data_preprocess/words/bag_politics.txt";
	private static final String input4 = "data_preprocess/words/bag_sports.txt";
	private static final String input5 = "data_preprocess/words/bag_science.txt";
	private static final String input0 = "data_preprocess/words/bag_total.txt";
	
	private static final String tweet = 
			"Governor Palin as VP Pick just proves again  Republicans do what Democrats only talk about";
	
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
	
	
	private static double likelyhood(double count, double countAll
			,double topicSize, double topicVocabulary) {
		
		double px = 0;
		
		px = ( 1 + count  * (count/countAll)) / ( topicVocabulary + topicSize );
		
		return px;
	}
	
	
	
	public static void main(String[] args){
		
		DataStructure ds = new DataStructure(tweet);
		
		Set<String> wordSet = ds.getWordSet();
		
		ArrayList<Double> likelyList = new ArrayList<Double>();
		
		ArrayList<String> topicWords = new ArrayList<String>();
		ArrayList<String> totalWords = new ArrayList<String>();
		
		String line = null;
		
		try{
		
		
		BufferedReader reader0 = new BufferedReader(new FileReader(new File(input0))); 
		
		while ((line = reader0.readLine()) != null){
			totalWords.addAll(Arrays.asList(line.split(" ")));
		}
		
		
		// t1 culture
		
		double pck_Culture = CultureSize / total;
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(input1)));;
		
		topicWords.clear();
		
		while((line = reader.readLine()) != null){
			topicWords.addAll(Arrays.asList(line.split(" ")));
			
		}
		
		
		for (String s : wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double count = 0;
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
						countAll++;
				}	
			}
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			
			if (countAll == 0){
				countAll = 1;
			}
			likelyList.add(likelyhood(count,countAll,CultureSize,CultureVocabulary));
			
		}
		
		double CultureScore = Math.log(pck_Culture);
		//double CultureScore = 0;
		
		for (Double d: likelyList){
			
			CultureScore += Math.log(d);
			
		}
		
		// t2 business
		double pck_Business = BusinessSize / total;
		
		reader = new BufferedReader(new FileReader(new File(input2)));;
		
		topicWords.clear();
		
		likelyList.clear();
		
		while((line = reader.readLine()) != null){
			topicWords.addAll(Arrays.asList(line.split(" ")));
			
		}
		
		for (String s : wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double count = 0;
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
						countAll++;
				}	
			}
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			
			if (countAll == 0){
				countAll = 1;
			}
			
			likelyList.add( likelyhood(count,countAll,BusinessSize,BusinessVocabulary));
			
		}
		
		double BusinessScore = Math.log(pck_Business);
		//double BusinessScore = 0;
		
		for (Double d : likelyList){
			BusinessScore += Math.log(d);
			
		}
		
		// t3 politics
		double pck_Politics = PoliticsSize / total;
		
		reader = new BufferedReader(new FileReader(new File(input3)));;
		
		topicWords.clear();
		likelyList.clear();
		
		while((line = reader.readLine()) != null){
			topicWords.addAll(Arrays.asList(line.split(" ")));
			
		}
		
		
		for (String s : wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double count = 0;
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
						countAll++;
				}	
			}
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			
			if (countAll == 0){
				countAll = 1;
			}
			likelyList.add(likelyhood(count,countAll,PoliticsSize,PoliticsVocabulary));
			
		}
		
		double PoliticsScore = Math.log(pck_Politics);
		//double PoliticsScore = 0;
		
		for (double d: likelyList){
			PoliticsScore += Math.log(d);
			
		}
		
		
		// t4 sports
		double pck_Sports = SportsSize / total;
		
		reader = new BufferedReader(new FileReader(new File(input4)));;
		
		topicWords.clear();
		likelyList.clear();
		
		while((line = reader.readLine()) != null){
			topicWords.addAll(Arrays.asList(line.split(" ")));
			
		}
		
		
		for (String s : wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double count = 0;
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
						countAll++;
				}	
			}
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			
			if (countAll == 0){
				countAll = 1;
			}
			likelyList.add(likelyhood(count,countAll,SportsSize,SportsVocabulary));
			
		}
		
		double SportsScore = Math.log(pck_Sports);
		//double SportsScore = 0;
		
		for (Double d : likelyList){
			SportsScore += Math.log(d);
			
		}
		
		// t5 science
		double pck_Science = ScienceSize / total;
		
		reader = new BufferedReader(new FileReader(new File(input5)));;
		
		topicWords.clear();
		likelyList.clear();
		
		while((line = reader.readLine()) != null){
			topicWords.addAll(Arrays.asList(line.split(" ")));
			
		}
		
		
		for (String s : wordSet){
			
			if (s.equals("")){
				continue;
			}
			
			double count = 0;
			double countAll = 0;
			
			for (String t : totalWords){
				
				if (s.equalsIgnoreCase(t)){
						countAll++;
				}	
			}
			
			for (String t : topicWords){
			
				if (s.equalsIgnoreCase(t)){
						count++;
				}
			}
			
			if (countAll == 0){
				countAll = 1;
			}
			likelyList.add(likelyhood(count,countAll,ScienceSize,ScienceVocabulary));
			
		}
		
		double ScienceScore = Math.log(pck_Science);
		//double ScienceScore = 0;
		
		for (Double d : likelyList){
			ScienceScore += Math.log(d);
			
		}
		
		System.out.println("Culture score: " + CultureScore 
				+ "\nBusiness score: " + BusinessScore
				+ "\nPolitics score: " + PoliticsScore
				+ "\nSports score: " + SportsScore
				+ "\nScience score: " + ScienceScore);
		
		
		}
		catch (IOException e){
			System.err.print(e);
		}
		
			
	}
	

}
