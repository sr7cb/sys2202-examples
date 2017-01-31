package sys2202.examples.phtis.simulator;

public class Smartphone {
	
	private AccelerationSensor accelerationSensor;
	private LocationSensor locationSensor;
	
	public Smartphone() {
		
		accelerationSensor = new AccelerationSensor();
		locationSensor = new LocationSensor();
	}
	
	public void Shake(int seconds) {
		
	}
	
	public void ChangeLocation() {
		
	}
}
