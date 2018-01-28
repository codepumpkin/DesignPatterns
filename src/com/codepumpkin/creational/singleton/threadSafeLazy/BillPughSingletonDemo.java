package com.codepumpkin.creational.singleton.threadSafeLazy;


/**
 * You can read more about Bill Pugh Singleton Implementation at 
 * http://codepumpkin.com/double-checked-locking-singleton/
 * 
 * @author codepumpkin.com 
 *
 */

class BillPughSingleton {
	 
    private BillPughSingleton(){}
     
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
     
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

/**
 * 
 * Demo class for testing Bill Pugh Singleton Design Pattern
 *
 */
public class BillPughSingletonDemo {
	 
	static BillPughSingleton s1 = null, s2 = null;

	public static void main(String s[]) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			s1 = BillPughSingleton.getInstance();
		});
		Thread t2 = new Thread(() -> {
			s2 = BillPughSingleton.getInstance();
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