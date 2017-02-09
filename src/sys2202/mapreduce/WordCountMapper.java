package sys2202.mapreduce;

import java.util.Scanner;

public class WordCountMapper {

	public static void main(String[] args) {

		// create a scanner to read words from the standard input
		Scanner inputScanner = new Scanner(System.in);
		
		// read each word that comes through standard input
		while (inputScanner.hasNext())
		{
			// get the next word
			String word = inputScanner.next();
			
			// print the current key-value pair:  the word and a 1 indicating its occurrence
			System.out.println(word + "\t" + 1);
		}
		
		inputScanner.close();
	}
}