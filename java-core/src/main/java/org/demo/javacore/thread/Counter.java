package org.demo.javacore.thread;

public class Counter {
	private volatile int count = 0;
	
	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}

	public void increaseCount(){
		count++;
	}
	
	public void Counter(){
		
	}
}
