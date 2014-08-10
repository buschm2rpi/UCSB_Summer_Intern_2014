package Evaluation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FScore {

	private static final String input1 = "data_preprocess/new4";
	
	private static final String input2 = "data_preprocess/csvY_n1";
	
	private static final String output = "data_preprocess/evaluation";
	
	public static void main(String[] args){
		
		
		// accuracy
		/*try{
			BufferedReader reader1 = new BufferedReader(new FileReader(new File(input1)));
			
			BufferedReader reader2 = new BufferedReader(new FileReader(new File(input2)));
		
			//BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			ArrayList<String> ans = new ArrayList<String>();
			
			int right = 0;
			
			String line = null;
			
			while ((line = reader1.readLine()) != null){
				
				ans.add(line.split(",")[1]);
				
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
			
			System.out.println("correct answers : " + right);
			System.out.println("accuracy : " + (right / (double)6000));
	
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		// total correct 2884, total accuracy 0.48
		
		try{
		BufferedReader reader1 = new BufferedReader(new FileReader(new File(input1)));
		
		BufferedReader reader2 = new BufferedReader(new FileReader(new File(input2)));
	
		//BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
		
		ArrayList<String> index = new ArrayList<String>();
		
		ArrayList<String> ans = new ArrayList<String>();
		
		ArrayList<String> index1 = new ArrayList<String>();
		
		ArrayList<String> index2 = new ArrayList<String>();
		
		ArrayList<String> index3 = new ArrayList<String>();
		
		ArrayList<String> index4 = new ArrayList<String>();
		
		ArrayList<String> index5 = new ArrayList<String>();
		
		int right = 0;
		
		int right1 = 0; // 1 ans in new3
		
		int right2 = 0; // 2 ans in new3
		
		int right3 = 0; // 3 ans in new3
		
		int right4 = 0; // 4 ans in new3
		
		int right5 = 0; // 5 ans in new3
		
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
		
		int i = 1;
		
		int j = 0;
		
		
		while ((line = reader2.readLine()) != null){
			
			if (j >= index5.size()){
				break;
			}
			
			String x = index5.get(j);
			
			String[] y = line.split(",");
			
			String y0 = y[0];
			
			if(x.equals(y0)){
				String s = ans.get(i-1);
					
				
				if (y.length == 2){
					if (y[1].equals(s)){
						right5++;
					}
				}
				else if (y.length > 2){
					if (y[1].equals(s) || y[2].equals(s)){
						right5++;
					}
				}
				j++;
			}
			i++;
		
			
		}
		
		
		
		System.out.println("correct answers : " + right5);
		System.out.println("accuracy : " + (right5 / (double)(index5.size())));
		
		// topic 1 culture , correct : 592, precision 0.3666
		// topic 2 business, correct : 305, precision 0.4295
		// topic 3 sports, correct 698, precision 0.8554
		// topic 4 politics, correct 672, precision 0.8484
		// topic 5 science, correct 617, precision 0.2985

	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
}
