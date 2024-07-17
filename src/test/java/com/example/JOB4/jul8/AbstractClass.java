package com.example.JOB4.jul8;

public abstract class AbstractClass {
	public AbstractClass(final String field) {
		this.className = field;
	}

	private String className;

	abstract void display();

	public void defaultDisplay() {
		System.out.println("defaultDisplay     :  " + this.className);
	}
}
