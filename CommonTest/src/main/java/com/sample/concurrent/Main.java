package com.sample.concurrent;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		ThreadPool threadPool = new ThreadPool(3, 10);
		for (int i=0; i < 10; i++) {
			threadPool.excecute(new Runnable() {
				public void run() {
					System.out.println("I am thread " + Thread.currentThread().getName() + "-" +Thread.currentThread().hashCode());
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
	}

}
