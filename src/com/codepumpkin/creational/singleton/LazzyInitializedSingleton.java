package com.codepumpkin.creational.singleton;


/**
 * You can read more about singleton design pattern at 
 * http://codepumpkin.com/singleton-design-pattern/
 * 
 * @author codepumpkin.com 
 *
 */
public class LazzyInitializedSingleton {
	 
    private static LazzyInitializedSingleton instance;
 
    private LazzyInitializedSingleton() {
 
    }
 
    // Lazy initialization is done when client firt time request for the
    // instance
    public static LazzyInitializedSingleton getInstance() {
        if (instance == null) {
            instance = new LazzyInitializedSingleton();
        }
        return instance;
    }
    
    
    
    public static void main(String s[])
    {
    	LazzyInitializedSingleton s1 = LazzyInitializedSingleton.getInstance();
    	LazzyInitializedSingleton s2 = LazzyInitializedSingleton.getInstance();
    	
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