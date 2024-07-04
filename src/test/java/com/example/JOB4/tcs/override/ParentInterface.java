package com.example.JOB4.tcs.override;

public interface ParentInterface {
	void showMain();

	static void showMainStatic() {
		System.out.println(" ParentInterface static method");
	}

	default void showMainDefault0() {
		System.out.println(" ParentInterface default method 0");
	}

	default void showMainDefault1() {
		System.out.println(" ParentInterface default method 1");
	}
}
