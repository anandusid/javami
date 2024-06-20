import com.example.JOB4.IterfaceDemo;

public class ChildInterface implements IterfaceDemo {
	int a = 10;

	@Override
	public void display() {
		System.out.println(" child !!!!");

	}

	static void staticMethod() {
		System.out.println("sttaic Methos of  child !!!");
	}

}
