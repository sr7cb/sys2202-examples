package sys2202.examples.phtis;

import java.time.LocalDateTime;

public class AccelerometerDatum extends Datum {

	private float x;
	private float y;
	private float z;
	
	public float getX() {
		
		return x;
	}
	
	public float getY() {
		
		return y;
	}
	
	public float getZ() {
		
		return z;
	}
	
	public AccelerometerDatum(String deviceId, LocalDateTime timestamp, float x, float y, float z) {
		
		super(deviceId, timestamp);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Datum Copy() {
		
		return new AccelerometerDatum(getDeviceId(), getTimestamp(), x, y, z);
	}
	
	public String toString() {
		
		return super.toString() + ", X:  " + x + ", Y:  " + y + ", Z:  " + z;
	}
}