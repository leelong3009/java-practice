package com.sample.concurrent;

public class MyRunnable implements Runnable {

	int var1 = 0;
	
	public void methodOne() {
		int var2 = 0;
		var2++;
		System.out.println("var2 " + var2);
	}
	public void run() {
//		methodOne();
		synchronized (MyRunnable.class) {
			var1++;	
		}
		System.out.println("var1 " + var1);
	}
	
	public static void main(String[] args) {
		Runnable r = new MyRunnable();
		for (int i=0; i<10000; i++) {
			Thread t1 = new Thread(r);
			t1.start();
		}
//		Thread t2 = new Thread(r);
		
//		t1.start();
//		t2.start();
	}

}
