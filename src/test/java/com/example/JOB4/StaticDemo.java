package com.example.JOB4;

public class StaticDemo {

	public static void main(final String[] args) {
		final StaticDemoChild obj = new StaticDemoChild();
		StaticDemoChild.staticDisplay();

	}

}

class StaticDemoParent {

	static String name = "StaticDemo";

	static void staticDisplay() {
		System.out.println(name);
	}

	void normalDisplay() {
		System.out.println("normalDisplay");
	}

}

class StaticDemoChild extends StaticDemoParent {

}