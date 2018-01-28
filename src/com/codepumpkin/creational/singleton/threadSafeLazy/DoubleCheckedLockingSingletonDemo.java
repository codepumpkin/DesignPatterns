package com.codepumpkin.creational.singleton.threadSafeLazy;

/**
 * You can read more about Double Checked Locking singleton design pattern at 
 * http://codepumpkin.com/double-checked-locking-singleton/
 * 
 * @author codepumpkin.com 
 *
 */

public class DoubleCheckedLockingSingleton {

	private static volatile DoubleCheckedLockingSingleton instance;

	private DoubleCheckedLockingSingleton() 
	{
	}

	public static DoubleCheckedLockingSingleton getInstance() 
	{
		if (instance == null) 
		{
			synchronized (DoubleCheckedLockingSingleton.class) 
			{
				if (instance == null) 
				{
					instance = new DoubleCheckedLockingSingleton();
					System.out.println("Instance Created");
				}
			}

		}
		return instance;
	}

}
