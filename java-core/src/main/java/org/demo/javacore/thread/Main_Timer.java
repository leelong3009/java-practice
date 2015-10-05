package org.demo.javacore.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Main_Timer extends TimerTask {

	@Override
	public void run() {
		System.out.println("Timer task started at:"+new Date());
        completeTask();
        System.out.println("Timer task finished at:"+new Date());
	}

	private void completeTask(){
		try {
            //assuming it takes 20 secs to complete the task
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public static void main(String[] args){
		Main_Timer timerTask = new Main_Timer();
		//running timer task as daemon thread
		Timer timer = new Timer(true); 
		timer.schedule(timerTask, 0, 10 *1000);
		System.out.println("Timertask started");
		try{
			Thread.sleep(120000);
		}catch(Exception e){
			
		}
		timer.cancel();
		System.out.println("Timter ended");
		try{
			Thread.sleep(300000);
		}catch(Exception e){
			
		}
	}
	
}
