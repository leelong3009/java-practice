package com.sample.concurrent;

public class ThreadJoinTestMain {

	public static void main(String[] args) {
		Runnable r = new MyRunnable2();
		Thread t1 = new Thread(r, "t1");
		Thread t2 = new Thread(r, "t2");
		Thread t3 = new Thread(r, "t3");
		
		t1.start();
		
		// start second thread after thread one is dead or 2 seconds
		try {
			t1.join(2000);
		} catch (InterruptedException e) {
			
		}
		t2.start();
		// start t3 after thread one is dead
		try {
			t1.join();
		} catch (InterruptedException e) {
			
		}
		t3.start();
		
		// let all thread finish execution before finishing main thread
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			
		}
		System.out.println("All threads are dead !!!");
	}

}

class MyRunnable2 implements Runnable {

	public void run() {
		System.out.println("Thread started :: " + Thread.currentThread().getName());
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			
		}
		System.out.println("Thread ended :: " + Thread.currentThread().getName());
	}
	
}
