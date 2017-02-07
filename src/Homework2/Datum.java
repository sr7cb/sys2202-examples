package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
public abstract class Datum {
	
	public LocalDateTime timestamp;
	public String deviceId;

	public Datum() {
		timestamp = null;
		deviceId = "";
	}
	
	public Datum(LocalDateTime timestamp, String deviceId) {
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setTimestamp(LocalDateTime localDateTime) {
		timestamp = localDateTime;
	}
	public void setDeviceId(String Id) {
		 deviceId = Id;
	}
	public String toString() {
		return "Device Id: " + deviceId + " and timestamp: " + timestamp;
	}
}
