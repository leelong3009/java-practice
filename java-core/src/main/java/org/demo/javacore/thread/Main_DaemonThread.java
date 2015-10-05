package org.demo.javacore.thread;

public class Main_DaemonThread{

	public static void main(String[] args){
		Thread deamonThread = new Thread(new DeamonThread(), "deamon");
		deamonThread.setDaemon(true);
		deamonThread.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finishing program");
	}

}

class DeamonThread implements Runnable{

	public void run() {
		while(true){
			process();
		}
	}
	
	private void process(){
		System.out.println("Processing deamon thread");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
