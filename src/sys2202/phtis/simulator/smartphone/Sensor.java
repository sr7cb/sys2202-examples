package sys2202.phtis.simulator.smartphone;

import sys2202.phtis.Datum;

public abstract class Sensor<DatumType extends Datum> {

	private DatumType currentReading;
	private ISensorChangeListener currentReadingChangeListener;

	public DatumType getCurrentReading() {

		return currentReading;

	}

	public void setCurrentReading(DatumType newReading) {

		if (newReading == null && currentReading != null || !newReading.equals(currentReading)) {

			currentReading = newReading;
			
			if(currentReadingChangeListener != null) {
				
				currentReadingChangeListener.newReadingHasArrived(newReading);
				
			}
		}
	}

	public ISensorChangeListener getChangeListener() {

		return currentReadingChangeListener;

	}

	public void setChangeListener(ISensorChangeListener changeListener) {

		this.currentReadingChangeListener = changeListener;

	}
}