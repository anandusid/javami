package com.example.JOB4;

public class StaticDemo {

	static int count;
	String name = "anandu";

	static void getCount() {
		final var s = 3;
		System.out.println(s);
//		System.out.println(name);
//		display();
	}

	void display() {
		System.out.println("nothing ....");
		System.out.println(count);
		System.out.println(name);
		getCount();
	}

}
