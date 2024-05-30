package com.example.JOB4;

public class Employe {

	public Employe(final String name, final String location, final Integer age) {
		this.name = name;
		this.location = location;
		this.age = age;
	}

	private String name, location;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(final String location) {
		this.location = location;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(final Integer age) {
		this.age = age;
	}

	private Integer age;

}
