package PreProcessing;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// maybe use more advance datastructure to represent a tweet in the future

public class DataStructure {
	// set of words in a tweet (not count duplicates)
	private Set<String> wordSet;

	// number of words in a tweet (not count duplicates)
	private int total;
	
	// convert a String tweet into a set
	public DataStructure(String tweet){
		
		String[] wordArray = tweet.split(" ");
		
		wordSet = new HashSet<String>(Arrays.asList(wordArray));
		
		total = wordSet.size();
	}
	
	public Set<String> getWordSet() {
		return wordSet;
	}

	public void setWordSet(Set<String> wordSet) {
		this.wordSet = wordSet;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
