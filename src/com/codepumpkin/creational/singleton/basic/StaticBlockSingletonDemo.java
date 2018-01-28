package com.codepumpkin.creational.singleton.basic;

/**
 * You can read more about singleton design pattern at
 * http://codepumpkin.com/singleton-design-pattern/
 * 
 * @author codepumpkin.com
 *
 */
class StaticBlockSingleton {
	private static StaticBlockSingleton instance;

	private StaticBlockSingleton() {

	}

	static {
		try {
			instance = new StaticBlockSingleton();
		} catch (Exception e) {
			throw new RuntimeException("Exception occured in creating instance");
		}
	}

	public static StaticBlockSingleton getInstance() {
		return instance;
	}

}

/**
 * 
 * Demo class for testing Static block initialization Singleton Design Pattern
 *
 */
public class StaticBlockSingletonDemo {

	public static void main(String s[]) {
		StaticBlockSingleton s1 = StaticBlockSingleton.getInstance();
		StaticBlockSingleton s2 = StaticBlockSingleton.getInstance();

		if (s1 == s2) {
			System.out.println("Same/Single Object");
		} else {
			System.out.println("Not Singleton Object");
		}
	}
}
