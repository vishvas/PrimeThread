
package primeThreads.threadMgmt;

import primeThreads.util.FileProcessor;
import primeThreads.store.Results;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class CreateWorkers  {
	FileProcessor fp= null;
	IsPrime isPrime=null;
	Results result =null;
	
	
    public CreateWorkers(FileProcessor fileProcessor, IsPrime isPrimeNumber, Results results){
    	Logger.writeMessage("Creater Worker Constructor Called", DebugLevel.CONSTRUCTOR);
    	fp = fileProcessor;
    	isPrime = isPrimeNumber;
    	result = results;
    	 
    }
    /**
     * Creating number of threads
     * @param NUM_THREADS
     */
    public void startWorkers(int NUM_THREADS){
    	Thread [] thread = new Thread[NUM_THREADS];
    	
    	for (int i = 0; i < NUM_THREADS; i++) {
    		thread[i] = new Thread(new WorkerThread(fp,isPrime,result));
    		thread[i].setName("Thread"+i);
    		thread[i].start();
    		Logger.writeMessage("Created Thread:"+i, DebugLevel.THREAD);
			
			
		}
    	/**
    	 * Joining the created threads
    	 */
    	for(int i = 0; i < thread.length; i++){
    		try{
    			thread[i].join();
    		}
    		catch(InterruptedException e){
    			e.printStackTrace();
    		}
    	}
    	
    }

}