package sys2202.examples.phtis.simulator;

public abstract class Sensor<DatumType> {

	private ISensorChangeListener<DatumType> changeListener;
	
	public ISensorChangeListener<DatumType> getChangeListener() {
		
		return changeListener;
		
	}
	
	public void setChangeListener(ISensorChangeListener<DatumType> changeListener) {
		
		this.changeListener = changeListener;
	}	
}