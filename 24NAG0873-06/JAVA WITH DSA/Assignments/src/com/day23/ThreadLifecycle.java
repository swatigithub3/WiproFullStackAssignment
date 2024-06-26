package com.day23;

public class ThreadLifecycle {
	private static final Object lock = new Object();

	public static void main(String[] args) {
		Thread t = new Thread(new LifecycleRunnable());
		System.out.println("Thread state after creation: " + t.getState());
		t.start();
		System.out.println("Thread state after calling start(): " + t.getState());
		try {
			Thread.sleep(500);
			synchronized(lock) {
				lock.notify();
			}
			Thread blocker = new Thread(() ->{
				synchronized(lock) {
					try {
						System.out.println("Blocker thread trying to acquire lock...");
						lock.wait();
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
			});
			synchronized(lock) {
				blocker.start();
				Thread.sleep(100);
				System.out.println("Blocker thread state: " + blocker.getState());
				lock.notify();
			}
			t.join(1000);
			System.out.println("Main thread state after timed join: " + Thread.currentThread().getState());
			t.join();
			System.out.println("Thread state after termination: " + t.getState());
			
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

	}
	static class LifecycleRunnable implements Runnable{
		public void run() {
			try {
				System.out.println("Thread state in run():"  + Thread.currentThread().getState());
				synchronized(lock) {
					System.out.println("Thread entering WAITING state.....");
					lock.wait();
				}
				System.out.println("Thread entering TIMED_WAITING state....");
				Thread.sleep(1000);
				System.out.println("Thread re-entering RUNNABLE state...");
				
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
