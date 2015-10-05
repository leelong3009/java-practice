package org.demo.javacore.thread;

public class Main_TestVolatile {
	private static volatile int count = 0;
	
	public static void main(String[] args) {
		new ChangeMaker().start();
		new ChangeListener().start();

	}
	
	static class ChangeMaker extends Thread {
		
		@Override
		public void run() {
			int local_value = count;
			while(count <5){
				System.out.println("Increate count to " + (local_value+1));
				count = ++local_value;
				try{
					Thread.sleep(500);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
			
		}
	}
	
	static class ChangeListener extends Thread {
		@Override
		public void run() {
			int local_value = count;
			while(local_value < 5){
				if(local_value != count){
					System.out.println("Current count " + count);
					local_value = count;
				}
			}
		}
	}
}
