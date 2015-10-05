package org.demo.javacore.thread;

public class Main_ThreadJoin {
	public static void main(String[] args){
    	Thread t1 = new Thread(new MyRunnable(), "t1");
    	Thread t2 = new Thread(new MyRunnable(), "t2");
    	Thread t3 = new Thread(new MyRunnable(), "t3");
    	
    	t1.start();
//    	wait for 2 seconds or if t1's dead
    	try {
			t1.join(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	t2.start();
    	
//    	start third thread only when first thread is dead
    	try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	t3.start();
    	
//    	let all threads finish execution before finishing main thread
    	try {
    		System.out.println("t1 is alive " + t1.isAlive()); 
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("All threads are dead, existing main thread");
	}
}
