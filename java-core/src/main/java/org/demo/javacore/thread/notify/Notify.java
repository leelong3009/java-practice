package org.demo.javacore.thread.notify;


public class Notify implements Runnable{
	private MyMessage msg;
	
	public Notify(MyMessage msg){
		this.msg = msg;
	}
	
	public void run() {
		String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
//                msg.notify();
                 msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		
	}

}
