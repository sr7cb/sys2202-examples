package Homework2;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
public abstract class OnOffDatum extends Datum {
	public boolean value;

	public OnOffDatum() {
		super();
	}

	public OnOffDatum(boolean value){
		this.value = value;
	} 
	public boolean getValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	public String toString() {
		if(value == true) 
			return "The device is on";
		else
			return "The device is off";
	}
}
