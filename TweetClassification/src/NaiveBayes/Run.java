package NaiveBayes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Evaluation.ConvertScoresToMax;
import Evaluation.FScore;
import PreProcessing.BagConstructor;

public class Run {
	
	/*** total words : 19012956
	business words: 	2314802 hashset size: 109764
	culture words : 	5516333	hashset size: 244896
	politics words: 	2338477	hashset size: 115319
	science words : 	7864152	hashset size: 268368
	sports words : 		979192	hashset size: 52810  ***/
	
	
	// test
	//private static final String tweet = 
		//	"Some people only say fall love once every time voice fall love all over again MarilynMonroeDC";
		
	//private static final String input = "data_preprocess/test08";
	
	//private static final String output = "data_preprocess/test09_9.csv";
	
	
	
	
	
	
	public static void main(String[] args){
		
		System.out.println("Please wait for 20 secs for loading data....");
		
		Classificer c = new Classificer();
		
		System.out.println("loading data finish");
		
		int i = -1;
		while ( i != 0){
		
		System.out.println("\n\n(All file path start point is 'yxu/github/UCSB_Summer_Intern_2014/UCSB_Summer_Intern_2014/TweetClassification')"
				+ "\n (eg. 'test_demo' file's path is 'data_preprocess/test_demo')"
				+ "\n Please enter the mode: "
				+ "\n1 clean a single tweet"
				+ "\n2 clean a tweet input file and write cleaned results into an output file ( Do not contain tweet index in input file)"
				+ "\n3 classify a single tweet"
				+ "\n4 classify mutiple tweets in an input file and write results into an output file"
				+ "\n5 generate wiki bag of words step 2 (step 1 is in apache mahout example codes, we don't need to change step 1)"
				+ "::: After you have all bags, remember to run UnionBags.java under NaiveBayes folder to the bag_total.txt"
				+ "\n6 evaluate performace"
				+ "\n0 exit"
				+ "\n Enter your choice (one integer 1-6): ");
		
		Scanner in = new Scanner(System.in);
		i = in.nextInt();
		
		System.out.println(i);
		
		if (i == 1){
			
			BagConstructor bc = new BagConstructor();
			
			System.out.println("Please enter a tweet:\n");
			in = new Scanner(System.in);
			String tweet = in.nextLine();
			
			System.out.println(tweet);
			
			bc.Consturct(tweet);
			
		}
		
		if (i == 2){
			BagConstructor bc = new BagConstructor();
			
			System.out.println("Please enter an input file path:\n");
			in = new Scanner(System.in);
			String input = in.nextLine();
			
			//System.out.println(input);
			
			System.out.println("Please enter an output file path:\n");
			in = new Scanner(System.in);
			String output = in.nextLine();
			
			//System.out.println(output);
			
			bc.Consturct(input, output);
			
			
		}
		
		
		
		
		if (i == 3){
			System.out.println("Please enter a cleaned tweet:\n");
			in = new Scanner(System.in);
			String tweet = in.nextLine();
			
			System.out.println(tweet);
			
			c.process(tweet);
		}
		
		
		if (i == 4){
			System.out.println("Please enter a cleaned input file path:\n");
			in = new Scanner(System.in);
			String input = in.nextLine();
			
			System.out.println(input);
			
			System.out.println("Please enter output file path:\n");
			in = new Scanner(System.in);
			String output = in.nextLine();
			
			System.out.println(output);
			
			try {
				BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
				BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
				
				c.process(reader,writer);
				
				writer.close();
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		if ( i == 5){
			
			BagConstructor bc = new BagConstructor();
			
			System.out.println("Please enter an input file path:\n");
			in = new Scanner(System.in);
			String input = in.nextLine();
			
			//System.out.println(input);
			
			System.out.println("Please enter an output file path:\n");
			in = new Scanner(System.in);
			String output = in.nextLine();
			
			//System.out.println(output);
			
			bc.Consturct(input, output);
			
		}
		
		if ( i == 6){
			
			System.out.println("Please enter an result scores file path:\n");
			in = new Scanner(System.in);
			String input = in.nextLine();
			
			//System.out.println(input);
			
			System.out.println("Please enter an intermedial output file path:\n");
			in = new Scanner(System.in);
			String output = in.nextLine();
			
			//System.out.println(output);
			
			ConvertScoresToMax cst = new ConvertScoresToMax();
			cst.convert(input, output);
			
			FScore fs = new FScore();
			fs.evaluate(output);
			
			
		}
			
		}	
		
	}
	
}
