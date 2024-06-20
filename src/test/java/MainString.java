
public class MainString {

	void add(int a, Integer a1) {
		a = a + 10;
		a1 = a1 + 10;
	}

	void modify(final Rectangle rectangle) {
		rectangle.length = 35;
		rectangle.fun = 1;

	}

	public static void main(final String[] args) {

		final MainString obj = new MainString();
		final int a = 10;
		final Integer a1 = 10;
		obj.add(a, a1);
		System.out.println(a + " *********** " + a1);

		final Rectangle rect = new Rectangle();
		rect.length = 10;
		rect.width = 4;
		rect.fun = 0;
		rect.modify(rect);
		System.out.println(a + " rectangle " + rect.length);
		System.out.println(rect.fun + " fun ");

		final String word1 = " Vamika ";

	}
}

class Rectangle {
	int length;
	int width;
	static int fun;

	public void modify(final Rectangle rect) {
		// TODO Auto-generated method stub

	}
}