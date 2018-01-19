
package com.codepumpkin.creational.singleton;

public class CloneableSingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class CloneableParent implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException{
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
