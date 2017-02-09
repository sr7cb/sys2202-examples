package sys2202.examples.homework3;

import java.util.ArrayList;

import sys2202.examples.phtis.Datum;
import sys2202.examples.phtis.simulator.smartphone.Smartphone;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Smartphone smartphone = new Smartphone("msg8u");
		
		smartphone.Shake();
		smartphone.Drive();
		smartphone.Drive();
		
		ArrayList<Datum> data = smartphone.getLocalDataStore().getData();
		
		for(int i = 0; i < data.size(); ++i) {
			
			Datum datum = data.get(i);
			System.out.println(datum.toString());
			
		}		
	}
}