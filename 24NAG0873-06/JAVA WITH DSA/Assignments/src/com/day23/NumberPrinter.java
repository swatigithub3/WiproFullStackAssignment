package com.day23;

class NumberRunnable implements Runnable{
	public void run() {
		try {
			for(int i = 1; i <= 10; i++) {
				System.out.println(Thread.currentThread().getName() + ": " + i);
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " interrupted.");
		}
	}
}

public class NumberPrinter {

	public static void main(String[] args) {
		Thread t1 = new Thread(new NumberRunnable(), "Thread-1");
		Thread t2 = new Thread(new NumberRunnable(), "Thread-2");
		t1.start();
		t2.start();

	}

}


