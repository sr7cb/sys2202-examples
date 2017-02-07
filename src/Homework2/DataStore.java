package Homework2;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
public class DataStore {
	private ArrayList<Datum> datalist = new ArrayList<Datum>(); 
	private Timestamp timestamp;
	private String deviceId;

	public DataStore() {

	}
	public DataStore(String deviceId, Timestamp timestamp) {
		this.timestamp = timestamp;
		this.deviceId = deviceId;
	}

	public ArrayList<Datum> getDataList() {
		return datalist;
	}
	public void addDatum(Datum d) {
		datalist.add(d);
	}
	public void removeDatum(int i) {
		datalist.remove(i);
	}

}
