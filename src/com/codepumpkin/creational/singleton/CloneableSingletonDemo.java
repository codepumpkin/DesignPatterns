package com.codepumpkin.creational.singleton;

/**
 * You can read more about Cloning in Singleton Design Pattern at
 * http://codepumpkin.com/preventing-cloning-in-singleton-design-pattern/
 * 
 * @author codepumpkin.com
 *
 */
class CloneableParent implements Cloneable {
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return this.clone();
	}
}

class SingletonChild extends CloneableParent {
	private static SingletonChild instance = new SingletonChild();

	private SingletonChild() {

	}

	public static SingletonChild getInstance() {
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}

/**
 * 
 * Demo class for testing Cloning in Singleton Design Pattern 
 *
 */
public class CloneableSingletonDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		SingletonChild s1 = SingletonChild.getInstance();
		s1.clone();
	}

}
