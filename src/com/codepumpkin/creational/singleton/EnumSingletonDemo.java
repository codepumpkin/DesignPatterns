package com.codepumpkin.creational.singleton;

/**
 * You can read more about Enum Singleton Design Pattern at
 * http://codepumpkin.com/breaking-singleton-using-reflection-and-enum-singleton/
 * 
 * @author codepumpkin.com
 *
 */
public class EnumSingletonDemo {
	 
    public static void main(String[] args) {
        System.out.println(SingletonEnum.INSTANCE);
    }
}
 
enum SingletonEnum{
    INSTANCE;
    SingletonEnum()
    {
        System.out.println("SingletonEnum Constructor ");
    }
}
