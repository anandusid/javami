public class Demo {

	public static void main(final String[] args) {

//		final List<String> stringLst = Arrays.asList("abcd", "pqrst", "xwyz");
//
//		final Map<String, Long> mapOfWords = stringLst.stream().filter(s -> s.contains("s"))
//				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//		System.out.println(mapOfWords);
//
//		chechNumber(10, 0);
//		final Animal animal = new Animal();
//		animal.setAnimalName("Cat");

		final int[] a = { 2, 4, 6, 8, 10 };
		final int[] b = { 1, 3, 5, 9, 11 };

		final int[] c = new int[a.length + b.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			c[k] = a[i];
			k++;
			c[k] = b[i];
			k++;
			for (final int l : c) {
				if (l != 0) {
					System.out.print(l + " , ");
				}
			}
			System.out.println();
		}

	}

	private static void chechNumber(final int i, final int j) {
		int b = 0;
		try {
			b = i / j;
		} catch (final ArithmeticException ae) {
			System.out.println(ae.getMessage());
		} catch (final Exception e) {
			System.out.println(e.getMessage());
		}

	}

}

class Animal implements Cloneable {
	String animalName;

	public String getAnimalName() {
		return animalName;
	}

	public void setAnimalName(final String animalName) {
		this.animalName = animalName;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(final Cat cat) {
		this.cat = cat;
	}

	Cat cat;

}

class Cat {
	String sound;

	public String getSound() {
		return sound;
	}

	public void setSound(final String sound) {
		this.sound = sound;
	}
}