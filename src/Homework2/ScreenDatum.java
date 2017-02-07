package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class ScreenDatum extends OnOffDatum {
	private int brightness;
	private int time_remaining;
	private int time_until_sleep;

	public ScreenDatum() {
		super();
	}
	public ScreenDatum(int birghtness, int time_remaining, int time_until_sleep){
		this.brightness = brightness;
		this.time_remaining = time_remaining;
		this.time_until_sleep = time_until_sleep;
		this.deviceId = deviceId;
		this.timestamp = timestamp;
	} 
	public int getBrightness() {
		return brightness;
	}
	public int getTimeRemaining(){
		return time_remaining;
	}
	public int getTimeUntilSleep() {
		return time_until_sleep;
	}
	public void setBrightness(int brightness) {
		this.brightness = brightness;
	}
	public void setTimeRemaining(int time_remaining){
		this.time_remaining = time_remaining;
	}
	public void setTimeUntilSleep(int time_until_sleep) {
		this.time_until_sleep = time_until_sleep;
	}
	
	public String toString() {
		return "Birghtness: " + brightness + " time remaining: " + time_remaining + " time until sleep: "  + time_until_sleep +" Device Id: " + deviceId + " timestamp: " + timestamp;
	}
}
