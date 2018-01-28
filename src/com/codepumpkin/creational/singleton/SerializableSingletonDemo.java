package com.codepumpkin.creational.singleton;

import java.io.*;

public class SerializableSingleton implements Serializable {
     
     
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
