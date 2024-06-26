package com.day23;

public class BankAccount {
	private double balance;
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
	}
	public synchronized void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println(Thread.currentThread().getName() + " deposited " + amount + ". New balance: " + balance);
		}
	}
	public synchronized void withdraw(double amount) {
		if(amount > 0 && balance >= amount) {
			balance -= amount;
			System.out.println(Thread.currentThread().getName() + " withdraw " + amount + ". New Balance: " + balance);
		} else {
			System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds. Current Balance: " + balance);
		}
	}

	public static void main(String[] args) {
		BankAccount account = new BankAccount(1000.0);
		Runnable depositTask = () -> {
			for(int i = 0; i < 5; i++) {
				account.deposit(100);
				try {
					Thread.sleep(50);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		Runnable withdrawTask = () -> {
			for(int i = 0; i < 5; i++) {
				account.withdraw(50);
				try {
					Thread.sleep(50);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		Thread thread1 = new Thread(depositTask, "Thread-1");
		Thread thread2 = new Thread(withdrawTask, "Thread-2");
		Thread thread3 = new Thread(depositTask, "Thread-3");
		Thread thread4 = new Thread(withdrawTask, "Thread-4");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final balance: " + account.getBalance());
	}
	public synchronized double getBalance() {
		return balance;
	}

}
