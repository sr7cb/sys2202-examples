package sys2202.examples.phtis.simulator.smartphone;

import sys2202.examples.phtis.Datum;

public interface ISensorChangeListener {

	void newReadingHasArrived(Datum datum);
}