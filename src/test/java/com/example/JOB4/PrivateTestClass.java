package com.example.JOB4;

class PrivateTestClass {

	public static void main(final String[] args) {

		final String s1 = "hello";
		final String s2 = s1 + " world";
		System.out.println(s2);

		final PrivateTestClass obj = new PrivateTestClass();
		obj.display();
	}

	private void display() {
		String name = "abc";
		System.out.println(name.hashCode());
		System.out.println(name + " def");
		name = name + " 1234";
		System.out.println(name.hashCode());

	}

}
