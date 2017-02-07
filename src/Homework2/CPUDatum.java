package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class CPUDatum extends Datum {
	private double clock_speed;
	private int usage;
	private int current_processId;

	public CPUDatum() {
		super();
	}
	public CPUDatum(double clock_speed, int usage, int current_processId){
		this.clock_speed = clock_speed;
		this.usage = usage;
		this.current_processId = current_processId;
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	} 
	public double getClockSpeed() {
		return clock_speed;
	}
	public int getUsage(){
		return usage;
	}
	public int getCurrentProcessId() {
		return current_processId;
	}
	public void setClockSpeed(double clock_speed) {
		this.clock_speed = clock_speed;
	}
	public void setUsage(int usage){
		this.usage = usage;
	}
	public void setCurrentProcessId(int current_processId) {
		this.current_processId = current_processId;
	}
	public String toString() {
		return "Clock speed: " + clock_speed + " current usage: " + usage + " current process id: " + current_processId + "Device Id: " + deviceId + " timestamp: " + timestamp;
	}
}
