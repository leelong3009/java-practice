package com.sample.design.pattern.observer;

import java.util.Observer;

public class Main {

	public static void main(String[] args) {
		//create subject
        MyTopic topic = new MyTopic();
		//create observers
        Observer obj1 = new MyTopicSubscriber("Obj1");
        Observer obj2 = new MyTopicSubscriber("Obj2");
        Observer obj3 = new MyTopicSubscriber("Obj3");

        topic.addObserver(obj1);
        topic.addObserver(obj2);
        topic.addObserver(obj3);
        
        topic.setMessage("new message");
	}

}
