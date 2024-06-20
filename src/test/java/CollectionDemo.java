import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class CollectionDemo {
	public static void main(final String[] args) {

		final List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(2);
		integerList.add(3);

		final var iterator = integerList.iterator();
		System.out.println(integerList);

		while (iterator.hasNext()) {
			final Integer value = iterator.next();
			iterator.remove();
		}

		System.out.println(integerList);

		final Map<String, Integer> hashMap = new HashMap<>();

		hashMap.put("Key1", 1);
		hashMap.put("Key2", 2);
		hashMap.put("Key3", 3);
		hashMap.put("Key4", 4);

//		for (final var map : hashMap.entrySet()) {
//			if (map.getKey().equals("Key4")) {
//				hashMap.put("Key5", 5);
////				map.setValue(6);
//			}
//
//		}
		System.out.println(hashMap);

		final char a[] = { 'a', '5', 'A', ' ' };
		System.out.println(Character.isDigit(a[0]) + " --- " + Character.isWhitespace(a[3]) + " ---  "
				+ Character.isUpperCase(a[2]));

		final Random r = new Random();
		for (int i = 0; i < 1; i++) {
			r.ints(3, 3, 5).forEach(System.out::print);
		}

		final Integer num = 1;
		final ArrayList<Integer> number = addToArrayList(num);
		final String name = "anandu";
		final ArrayList<Integer> nameList = addToArrayList(num);
	}

	private static <T> ArrayList<T> addToArrayList(final T num) {

		final ArrayList<T> a = new ArrayList<>();
		a.add(num);
		return a;

	}

}
