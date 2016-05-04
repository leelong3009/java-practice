package com.sample.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorMain {

	public static void main(String[] args) {
		int  corePoolSize  =    3;
		int  maxPoolSize   =   10;
		long keepAliveTime = 5000;

		ExecutorService threadPoolExecutor =  new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
		
		for (int i=0; i < 10; i++) {
			threadPoolExecutor.execute(new Runnable() {
				public void run() {
					System.out.println("I am thread " + Thread.currentThread().getName());
				}
			});
		}

	}

}
