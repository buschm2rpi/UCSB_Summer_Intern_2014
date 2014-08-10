package Evaluation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FPrevious {

	private static final String input = "data_preprocess/csvX_p.csv";
	
	private static final String output = "data_preprocess/pre1";
	
public static void main(String[] args){
		
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File(input)));
		
			BufferedWriter writer = new BufferedWriter(new FileWriter(new File(output)));
			
			String line = null;
			
			int i  = 1;
			
			while ((line = reader.readLine()) != null){
				writer.write(i + ",");
				i++;
				
				String[] datas = line.split(",");
				writer.write(datas[18] + "," + datas[8] + "," + "0"+ ","+datas[19] + "," + datas[13] + "\n");
				
			}
			
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
