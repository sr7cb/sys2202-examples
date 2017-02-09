package sys2202.examples.phtis.simulator.smartphone;

import java.time.LocalDateTime;
import java.util.Random;

import sys2202.examples.phtis.AccelerometerDatum;
import sys2202.examples.phtis.LocationDatum;

public class Smartphone {

	private String deviceId;
	private AccelerationSensor accelerationSensor;
	private LocationSensor locationSensor;
	private LocalDataStore localDataStore;
	private Random random;
	
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
		this.random = new Random();

		LocationDatum initialLocation = new LocationDatum(deviceId, LocalDateTime.now(),
				-90 + random.nextDouble() * 180, -180 + random.nextDouble() * 360, random.nextDouble());
		
		this.locationSensor.setCurrentReading(initialLocation);
		
		

	}

	public void Shake() throws Exception {

		for (int i = 0; i < 10; ++i) {
			double x = -1 + random.nextDouble() * 2;
			double y = -1 + random.nextDouble() * 2;
			double z = -1 + random.nextDouble() * 2;
			AccelerometerDatum newReading = new AccelerometerDatum(deviceId, LocalDateTime.now(), x, y, z);
			accelerationSensor.setCurrentReading(newReading);
			Thread.sleep(100);
		}
	}

	public void Drive() throws Exception {

		for (int i = 0; i < 10; ++i) {

			LocationDatum currentLocation = locationSensor.getCurrentReading();

			double newLatitude = currentLocation.getLatitude() + 0.001 * random.nextDouble();
			if (newLatitude < -90)
				newLatitude = -90;
			if (newLatitude > 90)
				newLatitude = 90;

			double newLongitude = currentLocation.getLongitude() + 0.001 * random.nextDouble();
			if (newLongitude < -180)
				newLongitude = -180;
			if (newLongitude > 180)
				newLongitude = 180;

			LocationDatum newLocation = new LocationDatum(deviceId, LocalDateTime.now(), newLatitude, newLongitude,
					10 + (-3 + 6 * random.nextDouble()));

			locationSensor.setCurrentReading(newLocation);
			
			Thread.sleep(1000);
		}
	}
}