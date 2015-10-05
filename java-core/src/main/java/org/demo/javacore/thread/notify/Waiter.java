package org.demo.javacore.thread.notify;


public class Waiter implements Runnable {

	private MyMessage msg;
	
	public Waiter(MyMessage msg){
		this.msg = msg;
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
		synchronized (msg) {
			try{
				System.out.println(name+" waiting to get notified at time "+System.currentTimeMillis());
				msg.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			System.out.println(name+" waiter thread got notified at time "+System.currentTimeMillis());
			//process the message now
			System.out.println(name+" processed: "+msg.getMsg());
		}
	}

}
