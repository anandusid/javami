import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrimeNumbersCheck {

	public static void main(final String[] args) {

		final List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

		final List<Integer> primeNumbers = numbers.stream().filter(PrimeNumbersCheck::isPrime)
				.collect(Collectors.toList());
		final String a = "anandu";
		final String b = "udnana";
		if (a.length() != b.length()) {
			System.out.println("not anagrom");
		}
		final Map<Character, Integer> map1 = new HashMap<>();
		final Map<Character, Integer> map2 = new HashMap<>();
		for (final char c : a.toCharArray()) {
			map1.put(c, map1.getOrDefault(c, 0) + 1);
		}
		for (final char c : b.toCharArray()) {
			map2.put(c, map2.getOrDefault(c, 0) + 1);
		}
		System.out.println(map1 + " *** " + map2);

		final double removeDuplicate = map1.entrySet().stream().filter(e -> e.getValue() == 1)
				.mapToDouble(Map.Entry::getValue).sum();
		System.out.println(removeDuplicate);

		final String str = "red blue green black blue white black";

	}

	private static boolean isPrime(final int number) {

		if (number <= 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(i); i++) {
			if (number % 1 == 0) {
				return false;
			}
		}
		return true;
	}
}
