package com.codepumpkin.creational;

public class LimitObjectCreationTest {

    public static void main(String[] args) {

        LimitClass obj;
        int i=1;
        while(i<=20)
        {
        	obj = LimitClass.getLimInstance();
        	i++;
        }
      }
}


class LimitClass {

	/**
	 * count of alive instances in JVM  
	 */
    public static int objCount = 0;

    /**
     * private constructor
     * increases the objCount static variable on every object creation
     */
    private LimitClass(){
        objCount++;
        System.out.println("instance " + objCount + " created");
    }

    /**
     * static factory method to return LimitClass instance
     * @return instance of LimitClass if not reached to threshold, else returns null
     */
    public static synchronized LimitClass getLimInstance() {
        if(objCount < 3 ){
            return new LimitClass();
        }
        System.out.println("Instance Limit reached. Can not create new Object");
        System.gc();
        return null;
    }
    
    /**
     * decreases the objCount static variable when JVM runs garbage collection
     * and destroys unused instances
     */
    @Override
    public void finalize()
    {
    	System.out.println("Instance destroyed");
    	 objCount--;
    }
}
