package sys2202.examples.phtis.simulator;

public interface ISensorChangeListener<DatumType> {

	void NewDataHasArrived(DatumType datum);
}