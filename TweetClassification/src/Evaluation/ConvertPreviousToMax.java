package Evaluation;

/***
 * convert previous system scores after linear regression mapping into the topic index which has a max score
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertPreviousToMax {

private static final String input = "data_preprocess/ynew.txt";
	
	private static final String output = "data_preprocess/newpre9";
	
	public static void main(String[] args){
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = null;
			
			
			
			while ((line = reader.readLine()) != null){
				String[] results = line.split(",");
				
				writer.write(results[0]+",");
				
				
				double max = -9999;
				int k = 0;
				
				for (int j = 1; j < 6;j++){
					double result = Double.parseDouble(results[j]);
					if( j == 1 ){
						result += 0.15;
					}
					if ( j == 5){
						result += 0.3;
					}
					if ( j == 2){
						result += 0.1;
					}
					if (j == 3){
						result -= 0.15;
					}
					
					if( j == 4){
						result -= 0.6;
					}
					
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
