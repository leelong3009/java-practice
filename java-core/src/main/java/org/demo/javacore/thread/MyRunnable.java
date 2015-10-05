package org.demo.javacore.thread;

public class MyRunnable implements Runnable {

	public void run() {
		System.out.println("Thread started : "+ Thread.currentThread().getName());
		try{
			Thread.sleep(3000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Thread ended : "+ Thread.currentThread().getName());

	}

}
