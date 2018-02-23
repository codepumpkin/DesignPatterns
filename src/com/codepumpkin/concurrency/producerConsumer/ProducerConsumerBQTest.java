package com.codepumpkin.concurrency.producerConsumer;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


/**
 * Simple Java Program to test Producer Consumer Design Pattern 
 * using  BlockingQueue
 *
 * @author CodePumpkin
 *
 */
public class ProducerConsumerBQTest {

	public static void main(String[] args) throws InterruptedException {
		
		BlockingQueue sharedQ = new LinkedBlockingQueue();
		
		
		Thread consumerThread = new Thread(new ConsumerBQ(sharedQ), "CONSUMER");
		Thread producerThread = new Thread(new ProducerBQ(sharedQ), "PRODUCER");
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		
	}

}

/**
 * Producer Thread will keep producing values for Consumer.
 * 
 * It will use put() method of BlockingQueue to add values
 * in sharedQ
 * 
 * @author CodePumpkin
 *
 */
class ProducerBQ implements Runnable
{
	private final BlockingQueue  sharedQ;
	
	public ProducerBQ(BlockingQueue  sharedQ)
	{
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run(){
		
		while(true)
		{
			try
			{
				Random random = new Random(); 
				int number = random.nextInt(100);
				System.out.println("Producing value " + number);
				sharedQ.put(number);
			}
			catch(InterruptedException ie)
			{
				System.err.println("Error :: " + ie);
			}
		}
	}
}

/**
 * Consumer Thread will consumer values form shared queue. 
 * 
 * It uses take method of BlockingQueue 
 * 
 * @author CodePumpkin
 *
 */
class ConsumerBQ implements Runnable
{
	private final BlockingQueue  sharedQ;
	
	public ConsumerBQ(BlockingQueue  sharedQ)
	{
		this.sharedQ = sharedQ;
	}
	
	@Override
	public void run(){
		
		while(true)
		{
			try
			{
				
				System.out.println("Consumed value " + sharedQ.take());
				
			}
			catch(InterruptedException ie)
			{
				System.err.println("Error :: " + ie);
			}
		}
	}
}




