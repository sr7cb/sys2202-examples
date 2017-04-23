package Homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;

public class Question3 {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> paths = new ArrayList<String>();
		try {
			Files.walk(Paths.get("C:/Users/Sanil'sPC/Documents/sp2017sys2202_mobile_data")).filter(Files::isRegularFile)
			.map(path -> path.toString()).forEach(paths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Question3Runner runner1 = new Question3Runner(paths, 0, 1914);
		Thread thread1 = new Thread(runner1);
		thread1.start();
		
		Question3Runner runner2 = new Question3Runner(paths, 1915, 3838);
		Thread thread2 = new Thread(runner2);
		thread2.start();
		
		Question3Runner runner3 = new Question3Runner(paths, 3839, 5742);
		Thread thread3 = new Thread(runner3);
		thread3.start();
		
		Question3Runner runner4 = new Question3Runner(paths, 5743, 7656);
		Thread thread4 = new Thread(runner4);
		thread4.start();
		
		Question3Runner runner5 = new Question3Runner(paths, 7657, 9570);
		Thread thread5 = new Thread(runner5);
		thread5.start();
		
		Question3Runner runner6 = new Question3Runner(paths, 9571, 11484);
		Thread thread6 = new Thread(runner6);
		thread6.start();
		
		Question3Runner runner7 = new Question3Runner(paths, 11485, 13398);
		Thread thread7 = new Thread(runner7);
		thread7.start();
		
		Question3Runner runner8 = new Question3Runner(paths, 13399, 15312);
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
		Hashtable<LocalDate, Hashtable<String,Integer>> mergeidCount = new Hashtable<LocalDate, Hashtable<String,Integer>>();
		MergeCounts(runner1.getDayCount(), mergeidCount);
		MergeCounts(runner2.getDayCount(), mergeidCount);
		MergeCounts(runner3.getDayCount(), mergeidCount);
		MergeCounts(runner4.getDayCount(), mergeidCount);
		MergeCounts(runner5.getDayCount(), mergeidCount);
		MergeCounts(runner6.getDayCount(), mergeidCount);
		MergeCounts(runner7.getDayCount(), mergeidCount);
		MergeCounts(runner8.getDayCount(), mergeidCount);
		PrintWriter idCountCsvFile = new PrintWriter("dayidcount.csv");
		idCountCsvFile.write("day,id,count\n");
		for(LocalDate t : mergeidCount.keySet()) {
			for(String j : mergeidCount.get(t).keySet())
				idCountCsvFile.write(t + "," + j + "," + mergeidCount.get(t).get(j) +"\n");
			}
			
		idCountCsvFile.close();
		
	}
	private static void MergeCounts(Hashtable<LocalDate, Hashtable<String, Integer>> runnerdayCount, Hashtable<LocalDate, Hashtable<String, Integer>> mergeidCount)
	{
		for(LocalDate time : runnerdayCount.keySet())
		{
			if(!mergeidCount.containsKey(time)) {
				mergeidCount.put(time, runnerdayCount.get(time));
			}
			else {
				for(String id : runnerdayCount.get(time).keySet()){
					if(!mergeidCount.get(time).containsKey(id)){
						mergeidCount.put(time, runnerdayCount.get(time));
					}
					else {
						int value = mergeidCount.get(time).get(id);
						int value2 = runnerdayCount.get(time).get(id);
						mergeidCount.get(time).put(id, value + value2);
					}
				}
	
			}
				
		}
	}
}
