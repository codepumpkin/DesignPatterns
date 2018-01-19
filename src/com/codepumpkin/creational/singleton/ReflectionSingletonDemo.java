package com.codepumpkin.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
 
public class ReflectionSingletonDemo {
 
    public static void main(String[] args) {
        ReflectionSingleton instanceOne = ReflectionSingleton.getInstance();
        ReflectionSingleton instanceTwo = null;
        try {
 
            // Change the access level of private field 'instance' and set null
            // every time object gets created
            Field instance = ReflectionSingleton.class.getDeclaredField("instance");
            instance.setAccessible(true);
            instance.set(instance, null);
 
            Constructor constructor = ReflectionSingleton.class.getDeclaredConstructor();
            // Below code will change constructor access level from private to
            // public
            constructor.setAccessible(true);
 
            // Creating second instance
            instanceTwo = (ReflectionSingleton) constructor.newInstance();
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("instanceOne HashCode : " + instanceOne.hashCode());
        System.out.println("instanceTwo HashCode : " + instanceTwo.hashCode());
 
    }
 
}
 
class ReflectionSingleton {
    private static final ReflectionSingleton instance = new ReflectionSingleton();
 
    private ReflectionSingleton() {
        if (instance != null) {
            throw new IllegalStateException("instance already created.");
        }
        System.out.println("Singleton instance is being created.");
    }
 
    public static ReflectionSingleton getInstance() {
        return instance;
    }
}