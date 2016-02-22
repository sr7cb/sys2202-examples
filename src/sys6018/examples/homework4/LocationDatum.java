package sys6018.examples.homework4;

import java.time.LocalDateTime;

public class LocationDatum extends Datum {

	private float latitude;
	private float longitude;
	private float accuracy;
	
	public float getLatitude() {
		
		return latitude;
	}
	
	public float getLongitude() {
		
		return longitude;
	}
	
	public float getAccuracy() {
		
		return accuracy;
	}
	
	public LocationDatum(float latitude, float longitude, float accuracy, String deviceId, LocalDateTime timestamp)
	{
		super(deviceId, timestamp);
		
		this.latitude = latitude;
		this.longitude = longitude;
		this.accuracy = accuracy;
	}
	
	public Datum Copy() {
		
		return new LocationDatum(latitude, longitude, accuracy, getDeviceId(), getTimestamp());
	}
}