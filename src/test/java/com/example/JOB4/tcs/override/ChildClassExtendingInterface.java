package com.example.JOB4.tcs.override;

public class ChildClassExtendingInterface implements ParentInterface {

	@Override
	public void showMain() {
		System.out.println("ChildClassExtendingInterface show main");

	}

	static void showMainStatic() {
		System.out.println(" ParentInterface static method");
	}

	@Override
	public void showMainDefault1() {
		System.out.println(" ParentInterface default method 1");
	}
}
