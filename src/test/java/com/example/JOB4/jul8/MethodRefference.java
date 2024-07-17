package com.example.JOB4.jul8;

import java.util.function.Function;

public class MethodRefference {

	public static void main(final String[] args) {
		final Function<String, Pomo> a = Pomo::new;

		final Pomo p = a.apply("working Thaliva");

		final int i = 0;
		final int j = 0;
		int k = 30;
		int l = 20;
//		i = i++ + ++i + ++i + ++i;
//		j = ++j + j++ + j++ + j++ + j++;
// 59; 37
		k = k-- + k--;
		l = --l + --l;
		// ++i;
		System.out.println("k is : " + k + " and l is : " + l);
		/*
		 * System.out.println(i); i++; System.out.println(i++ + ++i );
		 * System.out.println(i);
		 */

	}
}

class Pomo {
	public Pomo(final String name) {
		this.name = name;
		System.out.println(" Constructor invoked    :   " + this.name);
	}

	private String name;
	static String CONSTANT = "Constant in the interface";

	static void staticMethod() {
		System.out.println("Static method in the interface");
	}

	void display() {
		System.out.println(" ConcreteClass display    :   " + this.name);

	}

}