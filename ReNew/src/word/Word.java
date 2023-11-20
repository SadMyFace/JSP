package word;

import java.util.Scanner;

public class Word {
	Scanner scanner = new Scanner(System.in);
	
	private String word;
	private String mean;
	
	Word(){
		
	}
	
	Word(String word, String mean){
		this.word = word;
		this.mean = mean;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		return "Word [word=" + word + ", mean=" + mean + "]";
	}
	
	
}
