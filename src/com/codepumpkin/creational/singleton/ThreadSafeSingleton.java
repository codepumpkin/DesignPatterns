package com.codepumpkin.creational.singleton;

public class ThreadSafeSingleton {
	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	// Thread T2, T3, T4 are waiting for T1 to release the lock
	public static synchronized ThreadSafeSingleton getInstance() {
		// Thread T1 has taken the lock
		if (instance == null) {
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
}
