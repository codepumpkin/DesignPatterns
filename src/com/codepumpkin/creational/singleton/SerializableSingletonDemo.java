package com.codepumpkin.creational.singleton;

import java.io.*;

/**
 * You can read more about Serialization in Singleton Design Pattern at
 * http://codepumpkin.com/serialization-singleton-design-pattern/
 * 
 * @author codepumpkin.com
 *
 */
class SerializableSingleton implements Serializable {
     
     
    private static final long serialVersionUID = 1L;
    private static SerializableSingleton instance = new SerializableSingleton();
     
    // make additional fields transient
    transient String[] xyz = {"xyz1", "xyz2", "xyz3"};
 
    private SerializableSingleton() {
    }
 
    public static SerializableSingleton getInstance() {
        return instance;
    }
     
    
    protected Object readResolve() {
      return getInstance();
    }
}

/**
 * 
 * Demo class for testing Serialization in Singleton Design Pattern 
 *
 */
public class SerializableSingletonDemo{
	public static void main(String args[]) {
		 
	    try {
	        SerializableSingleton instance1 = SerializableSingleton.getInstance();
	        ObjectOutput out = null;
	 
	        // Serialize object state to file
	        out = new ObjectOutputStream(new FileOutputStream("codePumpkin.ser"));
	        out.writeObject(instance1);
	        out.close();
	 
	        // deserialize from file to object
	        ObjectInput in = new ObjectInputStream(new FileInputStream("codePumpkin.ser"));
	        SerializableSingleton instance2 = (SerializableSingleton) in.readObject();
	        in.close();
	 
	        System.out.println("instance1 hashCode = " + instance1.hashCode());
	        System.out.println("instance2 hashCode = " + instance2.hashCode());
	        
	        /**
	         * Comment readResolve() method in SerializableSingleton and you will get multiple objects
	         */
	        
	        if (instance1 == instance2) {
				System.out.println("Same/Single Object");
			} else {
				System.out.println("Not Singleton Object");
			}
	 
	    } catch (IOException | ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	 
	}
}
