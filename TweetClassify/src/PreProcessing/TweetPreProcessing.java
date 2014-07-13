package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.net.*;
import com.google.gson.Gson;



public class TweetPreProcessing {
	// file is encoded in ASCII
	private static final Charset charset = Charset.forName("US-ASCII");
	// path of the input file
	private static final String input = "test06";
	// path of the output file
	private static final String output = "test07";
	
	public static void hashtagApproach(String hashtag){
		// classify tweets based on its hashtags
		
	}
	
	public static void socialApproach(String hashtag){
		// classify tweets based on its @username
		
	}
	
	public static void nonLetterProcess(String symbol){
		// process punctuation and digits
		
	}
	
	public static void main(String[] args){
		
		
		// find the tweets which has less than five answers
		// for previous testing
		/*try{
		BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
		
		String line = null;
		
		long a = 1;
		String pindex = "";
		String pcontent = "";
		
		
		while ((line = reader.readLine()) != null){
			
			String index = line.split("\t")[0];
			String content = line.split("\t")[1];
			
			if ((pindex.equals(index)) && (!pcontent.equals(content))){
				System.out.println(index);
			}
			
			pindex = index;
			pcontent = content;
			
		}
		
	}
	catch(IOException e){
		System.err.println(e);
		
	}*/
		
		
		// extract tweet data, add index and delete duplicated from Mechanical Turk data
		// input test02, output test05
		/*try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
			
			long a = 1;
			long b = 0;
			while ((line = reader.readLine()) != null){
				if (a % 5 == 1) {
				
				b++;
				writer.write(b + "\t" + line);
				writer.newLine();
				
				}
				
				
				
				a++;
				
				
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
			
		}*/
		
		
		// extract answers and index
		// input test03, output test06
		/*try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
			
			long a = 1;
			long b = 0;
			while ((line = reader.readLine()) != null){
				if (a % 5 == 1) {
				
				b++;
				}
				
				writer.write(b + "\t" + line);
				writer.newLine();
				
				a++;
				
				
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
			
		}*/
		
		// count each tweet's answers,format as: index	ArtsCulture#	Business#	Sports#	Politics#	ScienceTechnology#	OtherUnknown#	
		// input test06, output test07
		/*try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
			
			long a = 1;
			long b = 1;
			int ArtsCulture = 0;
			int Business = 0;
			int Sports = 0;
			int Politics = 0;
			int ScienceTechnology = 0;
			int OtherUnknown = 0;
			
			while ((line = reader.readLine()) != null){
				
				if(line.contains("ArtsCulture")){
					ArtsCulture++;
				}
				else if(line.contains("Business")){
					Business++;
				}
				else if(line.contains("Sports")){
					Sports++;
				}
				else if(line.contains("Politics")){
					Politics++;
				}
				else if(line.contains("ScienceTechnology")){
					ScienceTechnology++;
				}
				else if(line.contains("OtherUnknown")){
					OtherUnknown++;
				}
				
				
				if (a % 5 == 0) {
					writer.write(b + "," + ArtsCulture + "," + Business + "," + Sports
							+ "," + Politics + "," + ScienceTechnology + "," + OtherUnknown);
					writer.newLine();
					b++;
					ArtsCulture = 0; Business = 0; Sports = 0; Politics = 0; ScienceTechnology = 0; OtherUnknown = 0;
				}
				
				a++;
				
				
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
			
		}*/
		
		// preprocesse data (only for testing not use in project yet)
		
		/*try{
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
						// clean punctuation and digits
						String pattern2 = "[^a-zA-Z]";
						s = s.replaceAll(pattern2, "");
						
						writer.write(s+" ");
					}
			
				}
				writer.newLine();
				
				
				
				
				
				
			}
			
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
		
		}*/
		
		
		
		
	}

}
