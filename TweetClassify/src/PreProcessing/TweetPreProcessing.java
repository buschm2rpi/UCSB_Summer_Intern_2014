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
	private static final String input = "data_preprocess/csvY.csv";
	// path of the output file
	private static final String output = "data_preprocess/csvY_2.csv";
	
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
		
		//
		/*try{
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			String line = null;
			
		
			while ((line = reader.readLine()) != null){
				String[] tokens = line.split(",");
				Integer max = 0;
				int j = 0;
				for(int i = 1; i < 7;i++){
					
					Integer a = Integer.parseInt(tokens[i]);
					if (a > max){
						max = a;
						j = i;
						tokens[i] = "1";
						if (i > 1){
							tokens[1] = "0";
						}
					}
					else {
						tokens[i] = "0";
					}
				}
				
				for (int i = 1; i <7; i++){
					if (i == j){
						tokens[i] = "1";
					}
					else
						tokens[i] = "0";
				}
				
				for (String s : tokens){
					writer.write(s + ",");
				}
				writer.newLine();
			}
			writer.close();
		}
		catch(IOException e){
			System.err.println(e);
			
		}*/
		
		
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
		
		// preprocesse data 
		//input test05, output test05_5
		
		/*try{
			// read input text file
			BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
			// write output text file
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
			// input line holder
			String line = null;
		
			while ((line = reader.readLine()) != null){
				// split by tab and get index and content
				String index = line.split("\t")[0];
				writer.write(index+"\t");
				line = line.split("\t")[1];
				
				// tokenize input line
				List<String> tokens = Arrays.asList(line.split(" "));
				ArrayList<String> tokensArrayList = new ArrayList<String>();
				tokensArrayList.addAll(tokens);
				// extract hashtags, social relationships(@username)
				for (int i = 0; i < tokensArrayList.size(); i++){
					String s = tokensArrayList.get(i);
					
					// move extract hashtags into else bolck and replace else if with if in the next line
					// extract social relationships
					if (s.startsWith("RT") || s.contains("@")){
						socialApproach(s);
						tokensArrayList.remove(i);
					}
					// write token
					else {
						// extract hashtags, remove #, leave hashtag text
						if (s.startsWith("#")){
							hashtagApproach(s);
							//tokensArrayList.remove(i);
							s = s.replace("#", "");
							
						}
						
						
						// clean the &#digits
						if (s.contains("&#")){
							String pattern = "&#\\d*";
							s = s.replaceAll(pattern, "");
						}
						// clean punctuation and digits
						String pattern2 = "[^a-zA-Z]";
						s = s.replaceAll(pattern2, "");
						
						// need to convert upper case? may or may not
						
						// write token and add white-space
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
		
		// clean result csv file, delete empty rows and all 0 rows
		// input csvX, output csvX_m
		// input csvX_p, output csvX_pm
		/*try{
		BufferedReader reader = Files.newBufferedReader(Paths.get(input), charset);
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(output), charset);
		String line = null;
		
		
		while ((line = reader.readLine()) != null){
			String[] tokens = line.split(","); 
			//remove empty lines
			if (tokens.length < 2){
				System.out.println("line#: "+ tokens[0]);
				continue;
			}
			// remove all 0 lines
			String token1 = tokens[1];
			String token2 = tokens[2];
			String token3 = tokens[3];
			if (token1.equals("0.0") && token2.equals("0.0") && token3.equals("0.0")){
				System.out.println("line#: "+tokens[0]);
				continue;
			}
			
			
			
			writer.write(line);
			writer.newLine();
			
			
			
			
		}
		writer.close();
	}
	catch(IOException e){
		System.err.println(e);
		
	}*/
		
		
	}

}
