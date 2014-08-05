package PreProcessing;

public class Word {
	// word index
	private long index;
	// word content
	private String word;
	// word frequency
	private String count;
	
	public Word (long index, String word, String count){
		this.index = index;
		this.word = word;
		this.count = count;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
	
	

}
