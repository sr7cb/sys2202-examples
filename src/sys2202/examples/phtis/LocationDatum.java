package sys2202.examples.phtis;

import java.time.LocalDateTime;

public class LocationDatum extends Datum {

	private float latitude;
	private float longitude;
	private float accuracyInMeters;
	
	public float getLatitude() {
		
		return latitude;
	}
	
	public float getLongitude() {
		
		return longitude;
	}
	
	public float getAccuracyInMeters() {
		
		return accuracyInMeters;
	}
	
	public LocationDatum(String deviceId, LocalDateTime timestamp, float latitude, float longitude, float accuracyInMeters)
	{
		super(deviceId, timestamp);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracyInMeters = accuracyInMeters;
	}
	
	public Datum Copy() {
		
		return new LocationDatum(getDeviceId(), getTimestamp(), latitude, longitude, accuracyInMeters);
	}
	
	public String toString() {
		
		return super.toString() + ", Lat:  " + latitude + ", Lon:  " + longitude + ", Accuracy (m):  " + accuracyInMeters;
	}
}