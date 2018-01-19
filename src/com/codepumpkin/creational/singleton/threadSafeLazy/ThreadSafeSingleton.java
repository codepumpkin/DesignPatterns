package com.codepumpkin.creational.singleton.threadSafeLazy;

/**
 * You can read more about Thread Safe Singleton Design Pattern at 
 * http://codepumpkin.com/double-checked-locking-singleton/
 * 
 * @author codepumpkin.com 
 *
 */


public class ThreadSafeSingleton {
    private static ThreadSafeSingleton instance;
 
    private ThreadSafeSingleton() {
    }
 
    // Thread T2, T3, T4 are waiting for T1 to release the lock
    public static synchronized ThreadSafeSingleton getInstance() {
        // Thread T1 has taken the lock
        if (instance == null) {
            instance = new ThreadSafeSingleton();  // Critical section
        }
        return instance;
    }
}