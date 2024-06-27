
public class StaticPassReference {
	String a = "Hello";
	String b = "World";

	public static void main(final String[] args) {
		try {
			final StaticPassReference obj = new StaticPassReference();
			System.out.println(obj.a + " ********* " + obj.b);
			swap(obj);
			System.out.println(obj.a + " ********* " + obj.b);
		} catch (final Exception e) {

		}
	}

	public static void swap(final StaticPassReference obj) {

		final String temp = obj.a;
		obj.a = obj.b;
		obj.b = temp;
	}

}
