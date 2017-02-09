package sys2202.phtis.simulation.smartphone;

import sys2202.phtis.Datum;

public interface ISensorChangeListener {

	void newReadingHasArrived(Datum datum);
}