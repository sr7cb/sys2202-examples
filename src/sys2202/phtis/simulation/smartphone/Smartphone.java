package sys2202.phtis.simulation.smartphone;

public class Smartphone {

	private String deviceId;
	private AccelerationSensor accelerationSensor;
	private LocationSensor locationSensor;
	private LocalDataStore localDataStore;
	
	public String getDeviceId() {
		
		return deviceId;
		
	}
	
	public AccelerationSensor getAccelerationSensor() {
		
		return accelerationSensor;
		
	}
	
	public LocationSensor getLocationSensor() {
		
		return locationSensor;
		
	}
	
	public LocalDataStore getLocalDataStore() {
		
		return localDataStore;
		
	}

	public Smartphone(String deviceId) {

		this.deviceId = deviceId;
		this.accelerationSensor = new AccelerationSensor();
		this.locationSensor = new LocationSensor();
		this.localDataStore = new LocalDataStore();
		this.accelerationSensor.setChangeListener(localDataStore);
		this.locationSensor.setChangeListener(localDataStore);
	}
}