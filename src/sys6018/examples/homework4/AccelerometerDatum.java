package sys6018.examples.homework4;

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
	
	public AccelerometerDatum(float x, float y, float z, String deviceId, LocalDateTime timestamp) {
		
		super(deviceId, timestamp);
		
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Datum Copy() {
		
		return new AccelerometerDatum(x, y, z, getDeviceId(), getTimestamp());
	}
}