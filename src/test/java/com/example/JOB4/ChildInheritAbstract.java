package com.example.JOB4;

public class ChildInheritAbstract extends AbstractClassDemo {

	@Override
	void test() {
		System.out.println(" ChildInheritAbstract test is executing ... ");

	}

	public static void main(final String[] args) {
		final ChildInheritAbstract obj = new ChildInheritAbstract();
		obj.test();
		obj.normalTest();
	}

}
