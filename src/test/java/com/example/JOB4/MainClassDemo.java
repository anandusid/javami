package com.example.JOB4;

class SuperClass {
	static void staticMethod() {
		System.out.println("Static method in SuperClass");
	}

	void instanceMethod() {
		System.out.println("Instance method in SuperClass");
	}
}

class SubClass extends SuperClass {
	static void staticMethod() {
		System.out.println("Static method in SubClass");
	}

	@Override
	void instanceMethod() {
		System.out.println("Instance method in SubClass");
	}
}

public class MainClassDemo {
	public static void main(final String[] args) {
//		final SuperClass superClass = new SuperClass();
//        SuperClass subClassAsSuper = new SubClass();
//		final SuperClass subClass = new SubClass();

		final IntefaceParent obj = new ChildExtendInterface();
		final ChildExtendInterface childObj = new ChildExtendInterface();
		obj.staticMethod();

//		superClass.staticMethod(); // Outputs: Static method in SuperClass
//        subClassAsSuper.staticMethod(); // Outputs: Static method in SuperClass
//		subClass.staticMethod(); // Outputs: Static method in SubClass

//		superClass.instanceMethod(); // Outputs: Instance method in SuperClass
//        subClassAsSuper.instanceMethod(); // Outputs: Instance method in SubClass
//		subClass.instanceMethod(); // Outputs: Instance method in SubClass
	}
}
