package com.example.stati;

public class ConfinementExample {

	// A static variable shared among all instances of the class
	private static int counter = 0;
	private int counterConfinement = 0;
	private volatile int counterConfinementVolatile = 0;

	// Method that increments the static counter in a synchronized manner
	public static synchronized void incrementCounter() {
		counter++;
		System.out.println("Counter incremented to: " + counter);
	}

	public void incrementcounterConfinementCounter() {
		counterConfinement++;
		counterConfinementVolatile++;
		System.out.println("Counter incremented to counterConfinement : " + counterConfinement);
		System.out.println("Counter incremented to counterConfinementVolatile : " + counterConfinementVolatile);
	}

	public static void main(final String[] args) throws InterruptedException {
		// Create multiple threads that increment the counter
		final var obj = new ConfinementExample();
		final Thread thread1 = new Thread(() -> {
			incrementCounter();
			obj.incrementcounterConfinementCounter();// Thread 1 increments the counter
		});

		final Thread thread2 = new Thread(() -> {
			incrementCounter(); // Thread 2 increments the counter
			obj.incrementcounterConfinementCounter();
		});

		// Start the threads
		thread1.start();
		thread2.start();
		thread1.join();
		thread2.join();
		counter++;
		obj.counterConfinement++;
		obj.counterConfinement++;
	}
}
