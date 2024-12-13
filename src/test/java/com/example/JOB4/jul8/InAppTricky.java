//package com.example.JOB4.jul8;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.CopyOnWriteArrayList;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@ToString
//@Getter
//class Employee {
//	private int id;
//	private String name;
//	private String role;
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(id, name, role);
//	}
//
//	@Override
//	public boolean equals(final Object obj) {
//		if (this == obj) {
//			return true;
//		}
//		if (obj == null) {
//			return false;
//		}
//		if (getClass() != obj.getClass()) {
//			return false;
//		}
//		final Employee other = (Employee) obj;
//		return id == other.id && Objects.equals(name, other.name) && Objects.equals(role, other.role);
//	}
//
//}
//
//public class InAppTricky {
//	public static void main(final String[] args) {
//
//		final Map<Employee, String> employeManagerMap = new ConcurrentHashMap();
//		final Employee e1 = new Employee();
//		e1.setId(1);
//		e1.setName("anandu");
//		e1.setRole("SSE");
//		employeManagerMap.put(e1, "Deepak");
//		final Employee e2 = new Employee();
//		e2.setId(2);
//		e2.setName("athul");
//		e2.setRole("SSE");
//		employeManagerMap.put(e2, "Varada");
//		final Employee e3 = new Employee();
//		e3.setId(3);
//		e3.setName("Rupa");
//		e3.setRole("SSE");
////		System.out.println(employeManagerMap);
////		final Set<Employee> employeManagerMapKeySets = employeManagerMap.keySet();
////		System.out.println(employeManagerMapKeySets);
//
//		final List<Employee> employeeList = new CopyOnWriteArrayList<>();
//		employeeList.add(e1);
//		employeeList.add(e2);
//		for (final Employee e : employeeList) {
//			System.out.println(e.getName());
//			employeeList.add(e3);
//
//		}
//		System.out.println(employeeList);
//
////		for (final Entry<Employee, String> mapSet : employeManagerMap.entrySet()) {
////			System.out.println(mapSet.getKey().getName());
////			employeManagerMap.put(e2, "Jobu");
////		}
//
//	}
//
//}
