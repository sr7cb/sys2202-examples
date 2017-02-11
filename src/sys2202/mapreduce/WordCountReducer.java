package sys2202.mapreduce;

import java.util.Hashtable;
import java.util.Scanner;

public class WordCountReducer {

	public static void main(String[] args) {
		
		// create a scanner to read lines from the standard input
		Scanner inputScanner = new Scanner(System.in);

		// reduce all word counts into an overall hashtable
		Hashtable<String, Integer> wordCount = new Hashtable<String, Integer>();

		// read each line on standard input
		while (inputScanner.hasNextLine()) {
			
			// each line contains a word and its count from a mapper
			String line = inputScanner.nextLine();
			String[] splitLine = line.split("\t");
			String word = splitLine[0];
			int count = Integer.parseInt(splitLine[1]);
			
			// accumulate the word and count into our hashtable
			if (wordCount.containsKey(word)) {
				int currentCount = wordCount.get(word);
				wordCount.put(word, currentCount + count);
			} else
				wordCount.put(word, 1);
		}

		// output final counts to standard output
		for (String word : wordCount.keySet())
			System.out.println(word + "\t" + wordCount.get(word));
		
		inputScanner.close();
	}
}