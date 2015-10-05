package org.demo.javacore.thread;

import org.demo.javacore.thread.notify.MyMessage;
import org.demo.javacore.thread.notify.Notify;
import org.demo.javacore.thread.notify.Waiter;

public class Main_WaitNotify {
	public static void main(String[] args){
		MyMessage msg = new MyMessage("This is a message");
		
		Thread waiter = new Thread(new Waiter(msg), "waiter");
		Thread waiter1 = new Thread(new Waiter(msg), "waiter1");
		Thread notify = new Thread(new Notify(msg), "notify");
		
		waiter.start();
		waiter1.start();
		notify.start();
	}
}
