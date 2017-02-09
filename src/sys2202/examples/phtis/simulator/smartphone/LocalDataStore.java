package sys2202.examples.phtis.simulator.smartphone;

import java.util.ArrayList;

import sys2202.examples.phtis.Datum;

public class LocalDataStore implements ISensorChangeListener {

	private ArrayList<Datum> data;

	public ArrayList<Datum> getData() {

		return data;

	}

	public LocalDataStore() {

		data = new ArrayList<Datum>();

	}

	public void newReadingHasArrived(Datum datum) {

		data.add(datum);

	}
}
