package Homework6;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Hashtable;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class Question1Runner implements Runnable{


	private ArrayList<String> paths;
	private int startPath;
	private int endPath;
	private Hashtable<LocalDate, Integer> dayCount;

	public Question1Runner(ArrayList<String> paths, int startPath, int endPath){
		this.paths = paths;
		this.startPath = startPath;
		this.endPath = endPath;
	}
	
	public void run() {
		dayCount = new Hashtable<LocalDate, Integer>();
		for(int path = startPath; path <= endPath; path++){
			if(path%1000 == 0) {
				System.out.println("Has done an interation of 1000");
			}
			FileReader jsonFile = null;
			try {
				jsonFile = new FileReader(paths.get(path));
			} catch (FileNotFoundException e) {
				System.out.println("File not found");
			}
			JsonParser jsonParser = new JsonParser(); 
			JsonArray parsedJSON = jsonParser.parse(jsonFile).getAsJsonArray();
			for(int i = 0; i < parsedJSON.size(); i++){
				JsonObject j = parsedJSON.get(i).getAsJsonObject();
				JsonElement time = j.get("Timestamp");
				DateTimeFormatter formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
				String timestampStr = time.getAsString();
				LocalDateTime timestamp = LocalDateTime.parse(timestampStr, formatter);
				if(!dayCount.containsKey(timestamp.toLocalDate())){
					dayCount.put(timestamp.toLocalDate(), 1);
				}
				else
				{
					int count = dayCount.get(timestamp.toLocalDate());
					count = count +1;
					dayCount.replace(timestamp.toLocalDate(), count);
					//System.out.println(dayCount.get(timestamp));
				}
					
			}
		}
	}
	public Hashtable<LocalDate, Integer> getDayCount(){
		return dayCount;
	}
}
