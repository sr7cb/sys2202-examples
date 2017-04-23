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


public class Question2Runner implements Runnable{


	private ArrayList<String> paths;
	private int startPath;
	private int endPath;
	private Hashtable<String, Integer> idCount;

	public Question2Runner(ArrayList<String> paths, int startPath, int endPath){
		this.paths = paths;
		this.startPath = startPath;
		this.endPath = endPath;
	}
	
	public void run() {
		idCount = new Hashtable<String, Integer>();
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
				JsonElement id = j.get("DeviceId");
				
				if(!idCount.containsKey(id.toString())){
					idCount.put(id.toString(), 1);
				}
				else
				{
					int count = idCount.get(id.toString());
					count = count +1;
					idCount.replace(id.toString(), count);
					//System.out.println(idCount.get(id));
				}
					
			}
		}
	}
	public Hashtable<String, Integer> getidCount(){
		return idCount;
	}
}
