package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TweetPreProcessing {
	// file is encoded in ASCII
	private static final Charset charset = Charset.forName("US-ASCII");
	// path of the input file
	private static final String input = "test02";
	// path of the output file
	private static final String output = "test03";
	
	public static void hashtagApproach(String hashtag){
		// classify tweets based on its hashtags
		
	}
	
	public static void socialApproach(String hashtag){
		// classify tweets based on its @username
		
	}
	
	
	
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
		
		// clean data
		
		try{
			// read input text file
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			// write output text file
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			// input line holder
			String line = null;
		
			while ((line = reader.readLine()) != null){
				// tokenize input line
				List<String> tokens = Arrays.asList(line.split(" "));
				ArrayList<String> tokensArrayList = new ArrayList<String>();
				tokensArrayList.addAll(tokens);
				// extract hashtags, social relationships(@username)
				for (int i = 0; i < tokensArrayList.size(); i++){
					String s = tokensArrayList.get(i);
					// extract hashtags
					if (s.startsWith("#")){
						hashtagApproach(s);
						tokensArrayList.remove(i);
					}
					// extract social relationships
					else if (s.startsWith("RT") || s.contains("@")){
						socialApproach(s);
						tokensArrayList.remove(i);
					}
					// write token
					else {
						// clean the &#digits
						if (s.contains("&#")){
							String pattern = "&#\\d*";
							s = s.replaceAll(pattern, "");
						}
						writer.write(s+" ");
					}
			
				}
				writer.newLine();
				
			}
			
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
		
		}
		
		
	}

}
