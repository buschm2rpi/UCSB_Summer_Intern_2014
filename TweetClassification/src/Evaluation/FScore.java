package Evaluation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FScore {

	// Mechanial Turk Max vote answers for each tweet
	private static final String input2 = "data_preprocess/csvY_n1";
	
	private static void precision(ArrayList<String> topicIndex, ArrayList<String> ans, String flag){
		
		try{
		BufferedReader reader2 = new BufferedReader(new FileReader(new File(input2)));
		

		int i = 1;
		
		int j = 0;
		
		int right = 0;
		
		String line = null;
		
		while ((line = reader2.readLine()) != null){
			
			if (j >= topicIndex.size()){
				break;
			}
			
			String x = topicIndex.get(j);
			
			String[] y = line.split(",");
			
			String y0 = y[0];
			
			if(x.equals(y0)){
				String s = ans.get(i-1);
					
				
				if (y.length == 2){
					if (y[1].equals(s)){
						right++;
					}
				}
				else if (y.length > 2){
					if (y[1].equals(s) || y[2].equals(s)){
						right++;
					}
				}
				j++;
			}
			i++;
		
			
		}
		
		System.out.println("topic " + flag + " correct answers : " + right);
		System.out.println("topic " + flag + " precision : " + (right / (double)(topicIndex.size())));
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	private static void preRecall(String input1){
		
		try{
		BufferedReader reader1 = new BufferedReader(new FileReader(new File(input2)));
		
		
	
		//BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
		
		ArrayList<String> index = new ArrayList<String>();
		
		ArrayList<String> ans = new ArrayList<String>();
		
		ArrayList<String> index1 = new ArrayList<String>();
		
		ArrayList<String> index2 = new ArrayList<String>();
		
		ArrayList<String> index3 = new ArrayList<String>();
		
		ArrayList<String> index4 = new ArrayList<String>();
		
		ArrayList<String> index5 = new ArrayList<String>();
		
		int right = 0; // 5 ans in new3
		
		String line = null;
		
		while ((line = reader1.readLine()) != null){
			
			String x = line.split(",")[0];
			String y = line.split(",")[1];
			
			index.add(x);
			
			ans.add(y);
			
			if(y.equals("1")){
				index1.add(x);
			}
			else if ( y.equals(("2"))){
				index2.add(x);
			}
			else if ( y.equals("3")){
				index3.add(x);
			}
			else if (y.equals("4")){
				index4.add(x);
			}
			else if (y.equals("5")){
				index5.add(x);
			}
		}
		recall(input1, index1,ans,"Culture");
		recall(input1, index2,ans,"Business");
		recall(input1, index3,ans,"Sports");
		recall(input1, index4,ans,"Politics");
		recall(input1, index5,ans,"Science");	
		
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

private static void recall(String input1, ArrayList<String> topicIndex, ArrayList<String> ans,String flag){
	
	try{
	BufferedReader reader2 = new BufferedReader(new FileReader(new File(input1)));
	
	int i = 1;
	
	int j = 0;
	
	int right = 0;
	
	String line = null;
	
	while ((line = reader2.readLine()) != null){
		
		if (j >= topicIndex.size()){
			break;
		}
		
		String x = topicIndex.get(j);
		
		String[] y = line.split(",");
		
		String y0 = y[0];
		
		if(x.equals(y0)){
			String s = ans.get(i-1);
				
			
			if (y.length == 2){
				if (y[1].equals(s)){
					right++;
				}
			}
			else if (y.length > 2){
				if (y[1].equals(s)){
					right++;
				}
			}
			j++;
		}
		i++;	
	}
	
	System.out.println("topic " + flag + " covered answers : " + right);
	System.out.println("topic " + flag + " recall : " + (right / (double)(topicIndex.size())));
	
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		//new 6
		
		// topic 1 culture , correct : 710, recall 0.5274
		// topic 2 business, correct : 360, recall 0.3722
		// topic 3 sports, correct 743, recall 0.61
		// topic 4 politics, correct 788, recall 0.4191
		// topic 5 science, correct 320, recall 0.5432
		//0.48
	
}

	
	public void evaluate(String input1){	
		
		// accuracy
		try{
			BufferedReader reader1 = new BufferedReader(new FileReader(new File(input1)));
			
			BufferedReader reader2 = new BufferedReader(new FileReader(new File(input2)));
			
			ArrayList<String> index = new ArrayList<String>();
			
			ArrayList<String> ans = new ArrayList<String>();
			
			ArrayList<String> index1 = new ArrayList<String>();
			
			ArrayList<String> index2 = new ArrayList<String>();
			
			ArrayList<String> index3 = new ArrayList<String>();
			
			ArrayList<String> index4 = new ArrayList<String>();
			
			ArrayList<String> index5 = new ArrayList<String>();
			
			int right = 0;
			
			String line = null;
			
			while ((line = reader1.readLine()) != null){
				
				String x = line.split(",")[0];
				String y = line.split(",")[1];
				
				index.add(x);
				
				ans.add(y);
				
				if(y.equals("1")){
					index1.add(x);
				}
				else if ( y.equals(("2"))){
					index2.add(x);
				}
				else if ( y.equals("3")){
					index3.add(x);
				}
				else if (y.equals("4")){
					index4.add(x);
				}
				else if (y.equals("5")){
					index5.add(x);
				}
				
			}
			
			int i = 0;
			
			while ((line = reader2.readLine()) != null){
				
				String[] y = line.split(",");
				
				String s = ans.get(i);
					i++;
					
				if (y.length == 2){
					if (y[1].equals(s)){
						right++;
					}
				}
				else if (y.length > 2){
					if (y[1].equals(s) || y[2].equals(s)){
						right++;
					}
				}
			}
			
			System.out.println("total correct answers : " + right);
			System.out.println("total accuracy : " + (right / (double)5996));
			
			reader1.close();
			reader2.close();
			
			System.out.println();
			
			precision(index1,ans,"Culture");
			precision(index2,ans,"Business");
			precision(index3,ans,"Sports");
			precision(index4,ans,"Politics");
			precision(index5,ans,"Science");
			
			System.out.println();
			
			preRecall(input1);
			
			
	
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


