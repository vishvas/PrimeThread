
package primeThreads.threadMgmt;

import primeThreads.store.Results;
import primeThreads.store.ResultsInterface;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class WorkerThread implements Runnable {

	
	FileProcessor fileProcessor = null;
	IsPrime isPrime = null;
	ResultsInterface result = null;
	private Thread thread;
	public WorkerThread(FileProcessor fp, IsPrime isPrimes, Results results) {
		Logger.writeMessage("WorkerThread Constructor Called", DebugLevel.CONSTRUCTOR);
		fileProcessor = fp;
		isPrime = isPrimes;
		result = results;
	}
	/**
	 * Overriding the run method of runnable interface
	 * Running threads and checking for the prime number
	 * and store them if they are prime number
	 */
	public void run() {
		 thread = Thread.currentThread();
		
		try {
			
			String s = fileProcessor.readLineFromFile();
			
			while (s != null) {
				
				Logger.writeMessage("Running Thread:" + Thread.currentThread().getName(), DebugLevel.THREAD);
				int number = Integer.parseInt(s);
				int i = isPrime.checkPrime(number);

				if (i == 1) {
					
					Logger.writeMessage("Value Inserted:" + number + " by " + Thread.currentThread().getName(), DebugLevel.RESULT);
					result.insert(number);
				} else {
					
				}
				
				s = fileProcessor.readLineFromFile();
			}

		} catch (Exception e) {
			e.printStackTrace();
			Logger.writeMessage("Thread " + Thread.currentThread().getName() + " interrupted.",DebugLevel.THREAD);
		}
		 Logger.writeMessage("Thread " + Thread.currentThread().getName() + " exiting.",DebugLevel.THREAD);
	}

}