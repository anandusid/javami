package com.example.JOB4;

public interface Java8Parent {

	void demo();

	static String demoStatic() {
		return " i am Java8Parent static";
	}

	default String demoDefault() {
		return " i am Java8Parent demoDefault";
	}

}
