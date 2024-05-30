package com.example.JOB4;

public class Java8InterfaceTestingClass implements Java8Parent {

	@Override
	public void demo() {
		System.out.println(" Java8InterfaceTestingClass overrided Demo of Java8Parent");

	}

	public static void main(final String[] args) {

		final Java8Parent obj = new Java8InterfaceTestingClass();

		System.out.println(obj.demoDefault());
		System.out.println(Java8Parent.demoStatic());

	}

}
