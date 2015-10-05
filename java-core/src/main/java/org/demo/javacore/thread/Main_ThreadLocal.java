package org.demo.javacore.thread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class Main_ThreadLocal implements Runnable{

	private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat("yyyyMMdd HHmm");
		};
	};
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " default formatter " + formatter.get().toPattern());
		try{
			Thread.sleep(new Random().nextInt(1000));
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		formatter.set(new SimpleDateFormat());
		System.out.println(Thread.currentThread().getName() + " editted formatter " + formatter.get().toPattern());
		
	}
	
	public static void main(String[] args) throws InterruptedException{
		Main_ThreadLocal runnable = new Main_ThreadLocal();
		for(int i=0; i<10; i++){
			Thread t = new Thread(runnable, ""+i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
	}

}
