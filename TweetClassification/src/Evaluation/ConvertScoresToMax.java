package Evaluation;

/***
 * convert five topic scores into the topic index which has a max score
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertScoresToMax {
	
	
	
	public void convert(String input, String output){
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = null;
			
			int i  = 1;
			
			while ((line = reader.readLine()) != null){
				String[] results = line.split(",");
				
				writer.write(i+",");
				i++;
				
				double max = -9999;
				int k = 0;
				
				for (int j = 1; j < 6;j++){
					double result = Double.parseDouble(results[j]);
					if (result > max){
						k = j;
						max = result;
					}	
				}
				writer.write(k + "\n");	
			}
			
			writer.close();
					
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
