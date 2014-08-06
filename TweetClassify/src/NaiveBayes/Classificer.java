package NaiveBayes;

import PreProcessing.DataStructure;



public class Classificer {
	
	private static final String input1 = "data_preprocess/words/bag_sports.txt";
	private static final String input2 = "data_preprocess/words/bag_science.txt";
	private static final String input3 = "data_preprocess/words/bag_politics.txt";
	private static final String input4 = "data_preprocess/words/bag_culture.txt";
	private static final String input5 = "data_preprocess/words/bag_business.txt";
	
	private static final String output1 = "data_preprocess/words/sports_count.txt";
	private static final String output2 = "data_preprocess/words/science_count.txt";
	private static final String output3 = "data_preprocess/words/politics_count.txt";
	private static final String output4 = "data_preprocess/words/culture_count.txt";
	private static final String output5 = "data_preprocess/words/business_count.txt";
	
	public static void main(String[] args){
		
		Test t = new Test(input1,output1,"sports");
			t = new Test(input2,output2, "science");
			t = new Test(input3,output3, "politics");
			t = new Test(input4,output4,"culture");
			t = new Test(input5,output5,"business");
		
	}
	

}
