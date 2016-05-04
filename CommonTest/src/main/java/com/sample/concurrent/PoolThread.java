package com.sample.concurrent;

public class PoolThread extends Thread {
	private BlockingQueue<Runnable> taskQueue = null;
	private boolean isStopped = false;
	
	public PoolThread(BlockingQueue<Runnable> taskQueue) {
		this.taskQueue = taskQueue;
	}
	
	public void run() {
		while (!isStopped()) {
			try {
				Runnable runnable = taskQueue.dequeue();
				runnable.run();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public synchronized void doStop() {
		isStopped = true;
		this.interrupt();
	}
	
	public synchronized boolean isStopped() {
		return isStopped;
	}
	
}
