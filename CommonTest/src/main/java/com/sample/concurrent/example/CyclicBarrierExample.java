package com.sample.concurrent.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		Runnable barrierAction1 = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 1 executed");
			}
		};
		
		Runnable barrierAction2 = new Runnable() {
			public void run() {
				System.out.println("BarrierAction 2 executed");
			}
		};
		
		CyclicBarrier barrier1 = new CyclicBarrier(2, barrierAction1);
		CyclicBarrier barrier2 = new CyclicBarrier(2, barrierAction2);
		
		Runnable r1 = new CyclicBarrierRunnable(barrier1, barrier2);
		Runnable r2 = new CyclicBarrierRunnable(barrier1, barrier2);
		
		new Thread(r1).start();
		new Thread(r2).start();

	}

}

class CyclicBarrierRunnable implements Runnable {
	private CyclicBarrier barrier1, barrier2;
	
	public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2) {
		this.barrier1 = barrier1;
		this.barrier2 = barrier2;
	}

	public void run() {
		try {
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is waiting at barrier 1");
			barrier1.await();
			Thread.sleep(1000);
			System.out.println(Thread.currentThread().getName() + " is waiting at barrier 2");
			barrier2.await();
			System.out.println(Thread.currentThread().getName() + " done.");
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}