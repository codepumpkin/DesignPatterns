package com.codepumpkin.creational.singleton.threadSafeLazy;

/**
 * You can read more about Bill Pugh Singleton Implementation at 
 * http://codepumpkin.com/double-checked-locking-singleton/
 * 
 * @author codepumpkin.com 
 *
 */

public class BillPughSingleton {
	 
    private BillPughSingleton(){}
     
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
     
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
