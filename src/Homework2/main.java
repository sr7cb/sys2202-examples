package Homework2;

import java.time.*;
public  class main{
	public static void main(String args[]) {
		DataStore ds = new DataStore();
		CPUDatum cd = new CPUDatum(3.0, 50, 123);
		cd.setTimestamp(LocalDateTime.now());
		cd.setDeviceId("1");
		GPSDatum gd = new GPSDatum(5.3f, 2.3f, 6.0f);
		gd.setTimestamp(LocalDateTime.now());
		gd.setDeviceId("2");
		BluetoothDatum bd = new BluetoothDatum(50, 50);
		bd.setTimestamp(LocalDateTime.now());
		bd.setDeviceId("3");
		AccelerometerDatum ad = new AccelerometerDatum(23.3f, 23.5f, 123.3f);
		ad.setTimestamp(LocalDateTime.now());
		ad.setDeviceId("4");
		ScreenDatum sd = new ScreenDatum(70, 23, 14);
		sd.setTimestamp(LocalDateTime.now());
		sd.setDeviceId("5");
		ds.addDatum(cd);
		ds.addDatum(gd);
		ds.addDatum(bd);
		ds.addDatum(ad);
		ds.addDatum(sd);
		for(Datum d : ds.getDataList()) {
			System.out.println(d.toString());
		}		
	}
}
