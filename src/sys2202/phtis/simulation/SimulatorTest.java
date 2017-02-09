package sys2202.phtis.simulation;

import java.util.ArrayList;

import sys2202.phtis.AccelerometerDatum;
import sys2202.phtis.LocationDatum;
import sys2202.phtis.simulation.smartphone.Smartphone;

public class SimulatorTest {

	public static void main(String[] args) throws Exception {
		
		// Create a smartphone.
		Smartphone smartphone = new Smartphone("msg8u");
		
		// Create a simulator to do various things with our smartphone.
		Simulator simulator = new Simulator(smartphone);
		
		// Shake our smartphone.
		simulator.shakePhone();
		
		// Take our smartphone for a drive to generate some location data.
		simulator.driveWithPhone();
		
		// The data we've generated can be retrieved from the local data store.
		ArrayList<AccelerometerDatum> accelerationData = smartphone.getLocalDataStore().getAccelerometerData();
		for(int i = 0; i < accelerationData.size(); ++i) {
			
			AccelerometerDatum acceleration = accelerationData.get(i);
			System.out.println(acceleration.toString());
			
		}
		
		ArrayList<LocationDatum> locationData = smartphone.getLocalDataStore().getLocationData();
		for(int i = 0; i < locationData.size(); ++i) {
			
			LocationDatum location = locationData.get(i);
			System.out.println(location.toString());
			
		}
	}
}