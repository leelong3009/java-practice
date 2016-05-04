package com.sample.common;

import java.io.Serializable;

public class Location implements Serializable{
	private static final long serialVersionUID = -8695659171717317614L;
	
	private double longitude;
	private double latitude;
	
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
	
	public Location(double latitude, double longitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	
}
