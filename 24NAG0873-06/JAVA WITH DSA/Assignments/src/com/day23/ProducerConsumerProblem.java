package com.day23;

import java.util.LinkedList;
import java.util.Queue;

 class SharedResource{
	private final Queue<Integer> queue = new LinkedList<>();
	private final int capacity = 5;
	public synchronized void produce(int value) throws InterruptedException{
		while(queue.size() == capacity) {
			wait();
		}
		queue.add(value);
		notifyAll();
	}
	public synchronized int consume() throws InterruptedException{
		while(queue.isEmpty()) {
			wait();
		}
		int value = queue.poll();
		notifyAll();
		return value;
	}
	
}
 class Producer implements Runnable{
	 private final SharedResource resource;
	 public Producer(SharedResource resource) {
		 this.resource = resource;
	 }
	 public void run() {
		 try {
			 for(int i = 0; i < 10; i++) {
				 resource.produce(i);
				 System.out.println("Produced " +i);
				 Thread.sleep(100);
			 }
		 } catch(InterruptedException e) {
			 Thread.currentThread().interrupt();
		 }
	 }
 }
 
 class Consumer implements Runnable{
	 private final SharedResource resource;
	 public Consumer(SharedResource resource) {
		 this.resource = resource;
	 }
	 public void run() {
		 try {
			 for(int i = 0; i < 10; i++) {
				 int value = resource.consume();
				 System.out.println("Consumed " + value);
				 Thread.sleep(150);
			 }
		 } catch(InterruptedException e) {
			 Thread.currentThread().interrupt();
		 }
	 }
 }
 

public class ProducerConsumerProblem {
	public static void main(String[] args) {
		SharedResource resource = new SharedResource();
		Thread producerThread = new Thread(new Producer(resource));
		Thread consumerThread = new Thread(new Consumer(resource));
		producerThread.start();
		consumerThread.start();

	}

}
