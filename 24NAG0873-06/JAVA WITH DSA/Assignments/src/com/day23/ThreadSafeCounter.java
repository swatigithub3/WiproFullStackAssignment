package com.day23;

public class ThreadSafeCounter {

	public static void main(String[] args) {
		final Counter counter = new Counter();
		Thread thread1 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});
		Thread thread2 = new Thread(() -> {
			for(int i = 0; i < 1000; i++) {
				counter.decrement();
			}
		});
		thread1.start();
		thread2.start();
		try {
			thread1.join();
			thread2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Counter value: " + counter.getCount());
		ImmutableData immutableData = new ImmutableData(42);
		Thread thread = new Thread(() -> {
			System.out.println("Immutable data value: " + immutableData.getValue());
		});
		thread.start();

	}

}
class Counter{
	private int count = 0;
	public synchronized void increment() {
		count++;
	}
	public synchronized void decrement() {
		count--;
	}
	public synchronized int getCount() {
		return count;
	}
}
final class ImmutableData{
	private final int value;
	public ImmutableData(int value) {
		this.value= value;
	}
	public int getValue() {
		return value;
	}
}
