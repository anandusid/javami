package com.example.JOB4;

public class StudentArray {

	@Override
	public String toString() {
		return "StudentArray [Name=" + Name + "]";
	}

	private String Name;

	public StudentArray(final int i, final String string) {
		final int no = i;
		this.Name = string;
	}
}
