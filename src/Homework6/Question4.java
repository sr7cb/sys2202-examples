package Homework6;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Question4 {
	
	public static void main(String[] args) throws IOException {
		ArrayList<String> paths = new ArrayList<String>();
		try {
			Files.walk(Paths.get("C:/Users/Sanil'sPC/Documents/sp2017sys2202_mobile_data/sp2017sys2202_mobile_data/LocationDatum")).filter(Files::isRegularFile)
			.map(path -> path.toString()).forEach(paths::add);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Question4Runner runner1 = new Question4Runner(paths, 0, 390);
		Thread thread1 = new Thread(runner1);
		thread1.start();
		
		Question4Runner runner2 = new Question4Runner(paths, 391, 781);
		Thread thread2 = new Thread(runner2);
		thread2.start();
		
		Question4Runner runner3 = new Question4Runner(paths, 782, 1172);
		Thread thread3 = new Thread(runner3);
		thread3.start();
		
		Question4Runner runner4 = new Question4Runner(paths, 1173, 1563);
		Thread thread4 = new Thread(runner4);
		thread4.start();
		
		Question4Runner runner5 = new Question4Runner(paths, 1564, 1954);
		Thread thread5 = new Thread(runner5);
		thread5.start();
		
		Question4Runner runner6 = new Question4Runner(paths, 1955, 2345);
		Thread thread6 = new Thread(runner6);
		thread6.start();
		
		Question4Runner runner7 = new Question4Runner(paths, 2346, 2736);
		Thread thread7 = new Thread(runner7);
		thread7.start();
		
		Question4Runner runner8 = new Question4Runner(paths, 2737, 3122);
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
		ArrayList<LocationDatum> mergeCount = new ArrayList<LocationDatum>();
		MergeCounts(runner1.getlDCount(), mergeCount);
		MergeCounts(runner2.getlDCount(), mergeCount);
		MergeCounts(runner3.getlDCount(), mergeCount);
		MergeCounts(runner4.getlDCount(), mergeCount);
		MergeCounts(runner5.getlDCount(), mergeCount);
		MergeCounts(runner6.getlDCount(), mergeCount);
		MergeCounts(runner7.getlDCount(), mergeCount);
		MergeCounts(runner8.getlDCount(), mergeCount);
		PrintWriter lDCsvFile = new PrintWriter("locationDatum.csv");
		lDCsvFile.write("deviceId, latitude, longitude, accuracy, timestamp\n");
		for(LocationDatum ld : mergeCount) {
			lDCsvFile.write(ld.getDeviceId() + "," + ld.getLatitude() + "," + ld.getLongitude() 
			+ "," + ld.getAccuracyInMeters() + "," + ld.getTimestamp() +"\n");
		}
		lDCsvFile.close();
	}
	private static void MergeCounts(ArrayList<LocationDatum> runningLD, ArrayList<LocationDatum> mergedLD) {
			for(LocationDatum ld : runningLD){
				mergedLD.add(ld);
			}
		}
}