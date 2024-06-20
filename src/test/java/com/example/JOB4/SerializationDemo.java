package com.example.JOB4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.persistence.Transient;

public class SerializationDemo {

	public static void main(final String[] args) throws IOException, ClassNotFoundException {
		final EmployeeObj e = new EmployeeObj();
		e.setName("abacd");
		e.setId(5);
		e.setDummy("Transient field");
		e.address = "statics";

		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
			os.writeObject(e);
		}

		try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("employee.ser"))) {
			final EmployeeObj e1 = (EmployeeObj) is.readObject();
			System.out.println("After Deserialization:");
			System.out.println("ID: " + e1.getId());
			System.out.println("Name: " + e1.getName());
			System.out.println("Dummy: " + e1.getDummy()); // Transient field, should be null or default
			System.out.println("Address: " + EmployeeObj.address); // Static field, not serialized
		}
	}
}

class EmployeeObj implements Serializable {

	private static final long serialVersionUID = 1L;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public static String getAddress() {
		return address;
	}

	public static void setAddress(final String address) {
		EmployeeObj.address = address;
	}

	public String getDummy() {
		return dummy;
	}

	public void setDummy(final String dummy) {
		this.dummy = dummy;
	}

	private int id;
	private String name;
	static String address;
	@Transient
	private String dummy;

	private void writeObject(final ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
		// Optionally, serialize additional fields here if needed
	}

	// Custom deserialization method to handle @Transient fields
	private void readObject(final ObjectInputStream in) throws IOException, ClassNotFoundException {
		in.defaultReadObject();
		// Optionally, deserialize additional fields here if needed
	}

	// To include static fields in the toString method
	@Override
	public String toString() {
		return "Employee{id=" + id + ", name='" + name + "', dummy='" + dummy + "', address='" + address + "'}";
	}

}
