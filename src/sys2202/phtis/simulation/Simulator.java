package sys2202.phtis.simulation;

import java.time.LocalDateTime;
import java.util.Random;

import Homework6.LocationDatum;
import sys2202.phtis.AccelerometerDatum;
import sys2202.phtis.simulation.smartphone.Smartphone;

public class Simulator {

	private Smartphone smartphone; 
	private Random random;
	
	public Simulator(Smartphone smartphone) {
		
		this.smartphone = smartphone;
		this.random = new Random();
		
		LocationDatum initialLocation = new LocationDatum(this.smartphone.getDeviceId(), LocalDateTime.now(),
				-90 + random.nextDouble() * 180, -180 + random.nextDouble() * 360, random.nextDouble());
		
		this.smartphone.getLocationSensor().setCurrentReading(initialLocation);
	}
	
	public void shakePhone() throws Exception {

		System.out.println("Shaking phone for 1 second...");
		
		for (int i = 0; i < 10; ++i) {
			double x = -1 + random.nextDouble() * 2;
			double y = -1 + random.nextDouble() * 2;
			double z = -1 + random.nextDouble() * 2;
			AccelerometerDatum newReading = new AccelerometerDatum(smartphone.getDeviceId(), LocalDateTime.now(), x, y, z);
			smartphone.getAccelerationSensor().setCurrentReading(newReading);
			Thread.sleep(100);
		}
	}

	public void driveWithPhone() throws Exception {

		System.out.println("Driving with phone for 5 seconds...");
		
		for (int i = 0; i < 5; ++i) {
			
			LocationDatum currentLocation = smartphone.getLocationSensor().getCurrentReading();

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

			LocationDatum newLocation = new LocationDatum(smartphone.getDeviceId(), LocalDateTime.now(), newLatitude, newLongitude,
					10 + (-3 + 6 * random.nextDouble()));

			this.smartphone.getLocationSensor().setCurrentReading(newLocation);
			
			Thread.sleep(1000);
		}
	}
}
