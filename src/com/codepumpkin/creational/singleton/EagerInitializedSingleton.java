package com.codepumpkin.creational.singleton;

/**
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
}
