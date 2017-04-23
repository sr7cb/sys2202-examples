package Homework6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


public class Question1 {

	public static void main(String[] args) throws IOException {
		ArrayList<String> paths = new ArrayList<String>();
		try {
			Files.walk(Paths.get("C:/Users/Sanil'sPC/Documents/sp2017sys2202_mobile_data")).filter(Files::isRegularFile)
			.map(path -> path.toString()).forEach(paths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Question1Runner runner1 = new Question1Runner(paths, 0, 1914);
		Thread thread1 = new Thread(runner1);
		thread1.start();
		
		Question1Runner runner2 = new Question1Runner(paths, 1915, 3838);
		Thread thread2 = new Thread(runner2);
		thread2.start();
		
		Question1Runner runner3 = new Question1Runner(paths, 3839, 5742);
		Thread thread3 = new Thread(runner3);
		thread3.start();
		
		Question1Runner runner4 = new Question1Runner(paths, 5743, 7656);
		Thread thread4 = new Thread(runner4);
		thread4.start();
		
		Question1Runner runner5 = new Question1Runner(paths, 7657, 9570);
		Thread thread5 = new Thread(runner5);
		thread5.start();
		
		Question1Runner runner6 = new Question1Runner(paths, 9571, 11484);
		Thread thread6 = new Thread(runner6);
		thread6.start();
		
		Question1Runner runner7 = new Question1Runner(paths, 11485, 13398);
		Thread thread7 = new Thread(runner7);
		thread7.start();
		
		Question1Runner runner8 = new Question1Runner(paths, 13399, 15312);
		Thread thread8 = new Thread(runner8);
		thread8.start();
	
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
			thread6.join();
			thread7.join();
			thread8.join();
		} catch (InterruptedException e) {
			System.out.println("Joining failed");
		}
		Hashtable<LocalDate, Integer> mergeddayCount = new Hashtable<LocalDate, Integer>();
		MergeCounts(runner1.getDayCount(), mergeddayCount);
		MergeCounts(runner2.getDayCount(), mergeddayCount);
		MergeCounts(runner3.getDayCount(), mergeddayCount);
		MergeCounts(runner4.getDayCount(), mergeddayCount);
		MergeCounts(runner5.getDayCount(), mergeddayCount);
		MergeCounts(runner6.getDayCount(), mergeddayCount);
		MergeCounts(runner7.getDayCount(), mergeddayCount);
		MergeCounts(runner8.getDayCount(), mergeddayCount);
		PrintWriter dayCountCsvFile = new PrintWriter("daycount.csv");
		dayCountCsvFile.write("date,count\n");
		for(LocalDate t : mergeddayCount.keySet()) {
				dayCountCsvFile.write(t + "," + mergeddayCount.get(t) +"\n");
			}
			
		dayCountCsvFile.close();
		
	}
	private static void MergeCounts(Hashtable<LocalDate, Integer> runnerdayCount, Hashtable<LocalDate, Integer> mergeddayCount)
	{
		for(LocalDate time : runnerdayCount.keySet())
		{
			if(!mergeddayCount.containsKey(time)) {
				mergeddayCount.put(time, runnerdayCount.get(time));
				
			}
			else {
				mergeddayCount.put(time, mergeddayCount.get(time) + runnerdayCount.get(time));
			}
				
		}
	}
	
}
	
