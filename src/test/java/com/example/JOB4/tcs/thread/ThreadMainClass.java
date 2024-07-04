package com.example.JOB4.tcs.thread;

class ThreadClass1 implements Runnable {

	@Override
	public void run() {
		System.out.println(" ThreadClass1 run");

	}

	public void normalrun() {
		System.out.println(" ThreadClass1 normalrun");

	}

}

class ThreadClass2 implements Runnable {

	@Override
	public void run() {
		System.out.println(" ThreadClass2 run");

	}

}

public class ThreadMainClass {
	public static void main(final String[] args) {
		final ThreadClass1 t1 = new ThreadClass1();
		final ThreadClass2 t2 = new ThreadClass2();
		final Thread o1 = new Thread(new ThreadClass1());
		final Thread o2 = new Thread(t2);
		o1.start();
		o2.start();
	}
}
