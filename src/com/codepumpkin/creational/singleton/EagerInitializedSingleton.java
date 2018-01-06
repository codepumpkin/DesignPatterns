package com.codepumpkin.creational.singleton;

/**
 * You can read more about singleton design pattern at 
 * http://codepumpkin.com/singleton-design-pattern/
 * 
 * @author codepumpkin.com 
 *
 */
public class EagerInitializedSingleton {
	 
    // Private static instance is created at the time of class loading
    private static EagerInitializedSingleton instance = new EagerInitializedSingleton();
 
    // Constructor made private so that no new instance can be created
    private EagerInitializedSingleton() {
 
    }
 
    // Static method to return the instance to the client
    public static EagerInitializedSingleton getInstance() {
        return instance;
    }
    
    
    
    public static void main(String s[])
    {
    	EagerInitializedSingleton s1 = EagerInitializedSingleton.getInstance();
    	EagerInitializedSingleton s2 = EagerInitializedSingleton.getInstance();
    	
    	if(s1==s2)
    	{
    		System.out.println("Same/Single Object");
    	}
    	else
    	{
    		System.out.println("Not Singleton Object");
    	}
    }
}
