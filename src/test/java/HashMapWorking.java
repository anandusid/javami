import java.util.HashMap;
import java.util.Map;

public class HashMapWorking {
	public static void main(final String[] args) {
		final Student obj1 = new Student(1, "Anandu");
		final Student obj2 = new Student(2, "Bilal");

		final Map<Student, String> map = new HashMap<>();
		map.put(obj1, "first");
		map.put(obj2, "second");
		System.out.println(map.get(obj1));

	}

}

class Student {
	public Student(final int i, final String string) {
		this.rollNo = i;
		this.name = string;
	}

	@Override
	public int hashCode() {
		return 1111;
	}

	@Override
	public boolean equals(final Object obj) {

		return false;
	}

	int rollNo;
	String name;

}