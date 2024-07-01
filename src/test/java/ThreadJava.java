import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadJava {

	private static int count = 0;

	public static int getCount() {
		return count;
	}

	private synchronized static void increment() {
		count++;
	}

	private static void incrementExecutorService() {
		count++;
	}

	public static void main(final String[] args) {

//		final ThreadJava obj = new ThreadJava();
//		final Thread t1 = new Thread(() -> {
//			for (int i = 0; i <= 5; i++) {
//				System.out.println(Thread.currentThread().getName() + " - Count: " + i);
//
//				obj.increment();
////				Thread.yield();
//			}
//		});
//
//		final Thread t2 = new Thread(() -> {
//			for (int i = 0; i <= 5; i++) {
//				System.out.println(Thread.currentThread().getName() + " - Count: " + i);
//
//				obj.increment();
////				Thread.yield();
//			}
//		});
//		t1.start();
//		t2.start();
//		System.out.println(obj.getCount());
//
//	}
		final ExecutorService es = Executors.newFixedThreadPool(2);

		final Runnable task = (() -> {
			System.out.println(Thread.currentThread().getName());
			incrementExecutorService();
		});
		es.submit(task);
		es.submit(task);

		es.shutdown();

	}

}
