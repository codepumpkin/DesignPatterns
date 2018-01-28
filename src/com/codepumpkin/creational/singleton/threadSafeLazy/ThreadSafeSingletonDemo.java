package com.codepumpkin.creational.singleton.threadSafeLazy;

/**
 * You can read more about Thread Safe Singleton Design Pattern at
 * http://codepumpkin.com/double-checked-locking-singleton/
 * 
 * @author codepumpkin.com
 *
 */
class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	// Thread T2, T3, T4 are waiting for T1 to release the lock
	public static synchronized ThreadSafeSingleton getInstance() {
		// Thread T1 has taken the lock
		if (instance == null) {
			instance = new ThreadSafeSingleton(); // Critical section
		}
		return instance;
	}
}

/**
 * 
 * Demo class for testing Singleton Design Pattern using synchronized
 * getIntance() method
 *
 */
public class ThreadSafeSingletonDemo {
	static ThreadSafeSingleton s1 = null, s2 = null;

	public static void main(String s[]) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			s1 = ThreadSafeSingleton.getInstance();
		});
		Thread t2 = new Thread(() -> {
			s2 = ThreadSafeSingleton.getInstance();
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		if (s1 == s2) {
			System.out.println("Same/Single Object");
		} else {
			System.out.println("Not Singleton Object");
		}
	}
}
