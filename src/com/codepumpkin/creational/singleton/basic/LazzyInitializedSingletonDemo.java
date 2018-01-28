package com.codepumpkin.creational.singleton.basic;


/**
 * You can read more about singleton design pattern at 
 * http://codepumpkin.com/singleton-design-pattern/
 * 
 * @author codepumpkin.com 
 *
 */
class LazzyInitializedSingleton {
	 
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
    
    
    
   
    
}

public class LazzyInitializedSingletonDemo{
	
	static LazzyInitializedSingleton s1=null,s2=null;
	
	
	 public static void main(String s[]) throws InterruptedException
	    {
	    	// Comment any one of the below methods and run the program
	    	
	    	//singleThread(); // comment this method while executing multipleThread() method
	    	multipleThread(); // comment this method while executing singleThread() method.
	    		
	    }
	    
	    /**
	     *  Method to check behaviour in single thread environment
	     */
	    public static void singleThread()
	    {
	    	s1 = LazzyInitializedSingleton.getInstance();
	    	s2 = LazzyInitializedSingleton.getInstance();
	    	
	    	if(s1==s2)
	    	{
	    		System.out.println("Same/Single Object");
	    	}
	    	else
	    	{
	    		System.out.println("Not Singleton Object");
	    	}
	    }
	    
	    /**
	     *  Method to check behaviour in multi thread environment. 
	     *  Some time this method may give singleton object, keep on executing to see the result.
	     *  Or 
	     *  Debug the code ;) 
	     * 
	     */
	    public static void multipleThread() throws InterruptedException
	    {
	    	
	    	Thread t1 = new Thread(() -> {
				s1 = LazzyInitializedSingleton.getInstance();
	    	});
	    	Thread t2 = new Thread(() -> {
				s2 = LazzyInitializedSingleton.getInstance();
	    	});
	    	
	    	t1.start();
	    	t2.start();
	    	
	    	t1.join();
	    	t2.join();
	    	
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
