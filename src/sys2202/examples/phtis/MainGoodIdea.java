package sys2202.examples.phtis;

import java.time.LocalDateTime;

public class MainGoodIdea {

	public static void main(String[] args) {

		// can't instantiate abstract classes
		// Datum datum = new Datum(deviceId, timestamp); -- ERROR
		
		String deviceId = "234-2-432-r-32-23";
		LocalDateTime timestamp = LocalDateTime.parse("2017-01-31T11:30");
		Datum accelerometerDatum = new AccelerometerDatum(deviceId, timestamp, 1, 2, 3);
		System.out.println(accelerometerDatum.toString());
		
		// can't change restricted fields
		// accelerometerDatum.setDeviceId("2342-234-32-3"); -- ERROR
		
		// polymorphism is elegant
		Datum locationDatum = new LocationDatum(deviceId, timestamp, 35, -20, 10);
		System.out.println(locationDatum.toString());
	}
}