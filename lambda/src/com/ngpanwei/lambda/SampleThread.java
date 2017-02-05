package com.ngpanwei.lambda;

public class SampleThread {
	public static void main(String args[]) {
		Thread thread = new Thread(() -> { System.out.println("runs in thread") ; }) ;
		thread.start();
		System.out.println("runs in main");
	}
	public static void main2(String args[]) {
		Runnable task = () -> { System.out.println("runs in thread") ;} ;
		Thread thread = new Thread(task);
		thread.start();
		System.out.println("runs in main");
	}
	
	public static void main1(String args[]) {
		Thread thread = new Thread(new Runnable() {
			public void run() {
				System.out.println("runs in thread");
			}
		});
		thread.start();
		System.out.println("runs in main");
	}
}
