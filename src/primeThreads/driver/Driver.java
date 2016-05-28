package primeThreads.driver;
import primeThreads.store.Results;
import primeThreads.store.ResultsInterface;
import primeThreads.threadMgmt.CreateWorkers;
import primeThreads.util.FileProcessor;
import primeThreads.util.IsPrime;
import primeThreads.util.Logger;



public class Driver{

	public static void main(String args[])throws Exception {

		if(args==null || args.length==0){
			throw new IllegalArgumentException("NO input file found & No of threads and debug value");
		}else if(args.length<3 || args.length>3){
			throw new IllegalArgumentException("Three argument are required. <InputFile> <Number of Threads> <DebugValue>");
		}else if(args.length==3){
			int NUM_THREADS=-1,DEBUG_VALUE=-1;
			
			try {
				NUM_THREADS = Integer.parseInt(args[1].toString());
				if(NUM_THREADS<1 || NUM_THREADS>5){
					throw new IllegalAccessException("Number of Thread should be in 1 to 5 (inclusive)");
				}
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Threads should be a number between [1,5]");
			}finally {
				
			}
			
			try {
				DEBUG_VALUE = Integer.parseInt(args[2].toString());
				if(DEBUG_VALUE<0 || DEBUG_VALUE>4){
					throw new IllegalAccessException("Debug Value should be in 0 to 4 (inclusive)");
				}
				Logger.setDebugValue(DEBUG_VALUE);
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Debug value should be a number between [0,4]");
			}finally {
				
			}
			
			
			FileProcessor fp=null;
			
			try {
				 fp = new FileProcessor(args[0].toString());
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}finally {
				
			}
			
			Results results = new Results();
			IsPrime isPrime = new IsPrime();
			/**
			 * Passing the instance of 
			 * Result,Isprime and FileProcessor 
			 * into the CreateWorker class.
			 */
			CreateWorkers worker = new CreateWorkers(fp,isPrime,results);
			worker.startWorkers(NUM_THREADS);
			results.showData();
			ResultsInterface resultInt = results;
			resultInt.writeSumToScreen();
			fp.fileClose();
			
		}else{
			throw new IllegalAccessException();
		}
		
		


	} // end main(...)

} // end public class Driver

