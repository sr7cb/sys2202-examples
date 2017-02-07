package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class GPSDatum extends Datum {
	private float latitude;
	private float longitude;
	private float accuracy;

	public GPSDatum() {
		super();
	}
	public GPSDatum(float latitude, float longitude, float accuracy){
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	} 
	public float getLatitude() {
		return latitude;
	}
	public float getLongitude(){
		return longitude;
	}
	public float getAccuracy() {
		return accuracy;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public void setLongitude(float longitude){
		this.longitude = longitude;
	}
	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}
	public String toString() {
		return "Latitude: " + latitude + " Longitude: " + longitude + " Accuracy: " + accuracy + "Device Id: " + deviceId + " timestamp: " + timestamp;
	}
}
