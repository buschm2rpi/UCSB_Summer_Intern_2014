package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TweetPreProcessing {
	// file is encoded in ASCII
	private static final Charset charset = Charset.forName("US-ASCII");
	// path of the input file
	private static final String input = "test02";
	// path of the output file
	private static final String output = "test03";
	
	public static void main(String[] args){
		
		// extract tweet data and delete duplicated from Mechanical Turk data
		/*try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
			
			long a = 1;
			while ((line = reader.readLine()) != null){
				if (a % 5 == 1) {
				writer.write(line);
				writer.newLine();
				}
				a++;
				
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
			
		}*/
		
		// extract hashtags
		try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
		
			while ((line = reader.readLine()) != null){
				
			
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
		
		}
		
		
	}

}
