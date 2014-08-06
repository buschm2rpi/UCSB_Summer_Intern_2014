package PreProcessing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataStructure {
	private Set<String> wordSet;
	private Map<String,Integer> wordCount;
	private Long total;
	
	
	public DataStructure(String doc){
		
		String[] wordArray = doc.split(" ");
		
		total = (long) wordArray.length;
		
		wordSet = new HashSet<String>(Arrays.asList(wordArray));
		wordCount = new HashMap<String,Integer>();
		
		for(String s : wordSet){
			Integer count = 0;
			for(String a : wordArray){
				if (s.equalsIgnoreCase(a)){
					count++;
				}
			}
			wordCount.put(s, count);
			
		}
		
	}
	
	
	// can not construct HashMap for bog of words , <word, count> , need time around 18 days
	public DataStructure(BufferedReader reader , BufferedWriter writer, String flag){
		
		String line = null;
		ArrayList<String> doc = new ArrayList<String>();
		
		try {
			while ( (line = reader.readLine()) != null){
				doc.addAll(Arrays.asList(line.split(" ")));	
	
			}
			
			total = (long)doc.size();
			System.out.println("doc size: "+total);
			
			wordSet = new HashSet<String>(Arrays.asList(doc.toArray(new String[]{})));
			System.out.println("HashSet size: "+wordSet.size());
			
			wordCount = new HashMap<String,Integer>();
			
			int i = 0;
			
			for(String s : wordSet){
				Integer count = 0;
				
				for(int j = 0; j < doc.size(); j++){
					
					if (s.equalsIgnoreCase(doc.get(j))){
						count++;
					}
					
					//System.out.println(total-j + " remain," + (wordSet.size() - i) + " wordSet remain," + "topic "+flag);
					
				}
				//wordCount.put(s, count);
				writer.write(s + "," + count);
				writer.newLine();
				
				i++;
				
			}
			System.out.println("data structure done");
		} 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Set<String> getWordSet() {
		return wordSet;
	}

	public void setWordSet(Set<String> wordSet) {
		this.wordSet = wordSet;
	}

	public Map<String,Integer> getWordCount() {
		return wordCount;
	}

	public void setWordCount(Map<String,Integer> wordCount) {
		this.wordCount = wordCount;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
	

}
