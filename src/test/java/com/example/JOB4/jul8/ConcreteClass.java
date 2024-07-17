package com.example.JOB4.jul8;

public class ConcreteClass extends AbstractClass {

	public ConcreteClass(final String field) {
		super(field);
		this.className = field;
	}

	private String className;

	@Override
	void display() {
		System.out.println(" ConcreteClass display    :   " + this.className);

	}

	@Override
	public void defaultDisplay() {
		System.out.println("defaultDisplay     :  " + this.className);
	}
}
