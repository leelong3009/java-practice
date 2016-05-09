package timezone;

import java.io.Serializable;
import java.sql.Timestamp;

public class Location implements Serializable{
	private static final long serialVersionUID = -8695659171717317614L;
	
	private Timestamp date;
	private double longitude;
	private double latitude;
	private String area;
	private Timestamp localTime;
	
	
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public Timestamp getLocalTime() {
		return localTime;
	}
	public void setLocalTime(Timestamp localTime) {
		this.localTime = localTime;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public Location() {
		
	}
	
	public Location(double latitude, double longitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	public Location(Timestamp date, double latitude, double longitude) {
		this.date = date;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	@Override
	public String toString() {
		return DateTimeCommon.simpleFormat.format(this.getDate()) + "," + this.getLatitude() + "," + this.getLongitude() + "," + this.getArea() + "," + DateTimeCommon.fullFormat.format(this.getLocalTime());
	}
}
