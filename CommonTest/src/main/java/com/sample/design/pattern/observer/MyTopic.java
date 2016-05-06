package com.sample.design.pattern.observer;

import java.util.Observable;

public class MyTopic extends Observable{
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		setChanged();
		notifyObservers();
	}
	
	
}
