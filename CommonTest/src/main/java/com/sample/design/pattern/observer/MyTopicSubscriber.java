package com.sample.design.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class MyTopicSubscriber implements Observer{
	private String name;
	
	public MyTopicSubscriber(String name) {
		this.name = name;
	}

	@Override
	public void update(Observable o, Object arg) {
		MyTopic topic = (MyTopic) o;
		System.out.println(name+":: Consuming message::"+ topic.getMessage());
	}

}
