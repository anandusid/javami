package com.example.JOB4;

class Counter {
	private static int count = 0;

	// Synchronized method to ensure thread safety
	public synchronized void increment() {
		count++;
	}

	public synchronized int getCount() {
		return count;
	}
}

public class ThreadDemo {
	public static void main(final String[] args) {
		final Counter counter = new Counter();

		// Creating multiple threads
		final Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		final Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (final InterruptedException e) {
			e.printStackTrace();
		}

		// The result will be 2000, as the increment operation is synchronized
		System.out.println("Final count: " + counter.getCount());
	}
}
