package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class BluetoothDatum extends OnOffDatum {
	private int range;
    private int signal_strength;

	public BluetoothDatum() {
		super();
	}
	public BluetoothDatum(int range, int signal_strength){
		this.range = range;
		this.signal_strength = signal_strength;
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	} 
	public int getRange() {
		return range;
	}
	public int getSignalStrength(){
		return signal_strength;
	}
	
	public void setRange(int range) {
		this.range = range;
	}
	public void setSignalStrength(int signal_strength){
		this.signal_strength = signal_strength;
	}
	
	public String toString() {
		return "The range is: " + range + " The signal strength: " + signal_strength + " Device Id: " + deviceId + " timestamp: " + timestamp;
	}
}
