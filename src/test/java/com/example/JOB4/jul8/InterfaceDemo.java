package com.example.JOB4.jul8;

interface MyInterface {
	// Abstract method
	void abstractMethod();

	// Default method
	default void defaultMethod() {
		System.out.println("Default method in the interface");
	}

	// Static method
	static void staticMethod() {
		System.out.println("Static method in the interface");
	}

	// Constant
	String CONSTANT = "Constant in the interface";
}

public class InterfaceDemo implements MyInterface {
	@Override
	public void abstractMethod() {
		System.out.println("Abstract method implementation");
	}

	// Default method
	@Override
	public void defaultMethod() {
		System.out.println("Default method in the Class");
	}

	// Static method
	static void staticMethod() {
		System.out.println("Static method in the Class");
	}

	// Constant
	String CONSTANT = "Constant in the Class";

	public static void main(final String[] args) {
		final InterfaceDemo myClass = new InterfaceDemo();
		myClass.abstractMethod();
		myClass.defaultMethod();
		MyInterface.staticMethod();
		System.out.println(MyInterface.CONSTANT);
	}
}
