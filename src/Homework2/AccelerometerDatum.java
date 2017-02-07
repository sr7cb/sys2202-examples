package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public class AccelerometerDatum extends Datum {
	private float x;
	private float y;
	private float z;

	public AccelerometerDatum() {
		super();
	}
	public AccelerometerDatum(float x, float y, float z){
		this.x = x;
		this.y = y;
		this.z = z;
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	} 
	public float getX() {
		return x;
	}
	public float getY(){
		return y;
	}
	public float getZ() {
		return z;
	}
	public void setX(float x) {
		this.x = x;
	}
	public void setY(float y){
		this.y = y;
	}
	public void setZ(float z) {
		this.z = z;
	}
	public String toString() {
		return "X: " + x + " Y: " + y + " Z: " + z + " Device Id: " + deviceId + " timestamp: " + timestamp;
	}
}
