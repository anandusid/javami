package com.example.JOB4.tcs.thread;

public class ThreadDemoClass {
	
	public static void main(String[] args) {
		MetaInfo m = new MetaInfo();
		Thread t1 = new Thread(()-> {
			for(int i =0; i<=100; i++) {
				m.counterIncrement();
			}
		}
		);
		Thread t2 = new Thread(()-> {
			for(int i =0; i<=100; i++) {
				m.counterIncrement();
			}
		}
		);
		t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		System.out.println(m.getCounter());
	}

}


class MetaInfo{
	private int counter=0;
	
	public synchronized void counterIncrement() {
		
		counter++;
	}
	public synchronized int getCounter() {
		return counter;
	}
}