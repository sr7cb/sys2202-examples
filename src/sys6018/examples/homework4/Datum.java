package sys6018.examples.homework4;

import java.time.LocalDateTime;

public class Datum {

	private String deviceId;
	private LocalDateTime timestamp;

	public String getDeviceId() {

		return deviceId;
	}

	public LocalDateTime getTimestamp() {

		return timestamp;
	}

	public Datum(String deviceId, LocalDateTime timestamp) {

		this.deviceId = deviceId;
		this.timestamp = timestamp;
	}

	public Datum Copy() {

		return new Datum(deviceId, timestamp);
	}
}