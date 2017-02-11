package sys2202.phtis.simulation.smartphone;

import java.util.ArrayList;

import sys2202.phtis.AccelerometerDatum;
import sys2202.phtis.Datum;
import sys2202.phtis.LocationDatum;

public class LocalDataStore implements ISensorChangeListener {

	private ArrayList<Datum> data;

	public ArrayList<LocationDatum> getLocationData() {

		ArrayList<LocationDatum> locationData = new ArrayList<LocationDatum>();
		
		for(int i = 0; i < data.size(); ++i) {
			if(data.get(i) instanceof LocationDatum) {
				locationData.add((LocationDatum)data.get(i));
			}
		}
		
		return locationData;
	}
	
	public ArrayList<AccelerometerDatum> getAccelerometerData() {

		ArrayList<AccelerometerDatum> accelerometerData = new ArrayList<AccelerometerDatum>();
		
		for(int i = 0; i < data.size(); ++i) {
			if(data.get(i) instanceof AccelerometerDatum) {
				accelerometerData.add((AccelerometerDatum)data.get(i));
			}
		}
		
		return accelerometerData;
	}

	public LocalDataStore() {

		data = new ArrayList<Datum>();

	}

	public void newReadingHasArrived(Datum datum) {

		data.add(datum);
		
		System.out.println("A new datum was added to the local data store:  " + datum);

	}
}
