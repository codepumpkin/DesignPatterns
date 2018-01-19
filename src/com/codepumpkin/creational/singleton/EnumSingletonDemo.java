package com.codepumpkin.creational.singleton;

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
