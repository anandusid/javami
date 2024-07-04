package com.example.JOB4.tcs.override;

public class Child extends Parent {

	public void show() {
		System.out.println("Child show");
	}

	@Override
	public void showMain() {
		System.out.println("Child show");
	}
}