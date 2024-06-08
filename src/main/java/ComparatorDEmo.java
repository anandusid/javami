import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDEmo {

	public static void main(final String[] args) {

		final Comparator<String> obj = (s1, s2) -> {

			if (s1.length() < s2.length()) {
				return -1;
			}
			return 1;
		};

		final List<String> fruitList = Arrays.asList("ORange", "Mango", "Apple", "jackfruit", "Guva");

		Collections.sort(fruitList, obj);
		System.out.print(fruitList);
	}

}
