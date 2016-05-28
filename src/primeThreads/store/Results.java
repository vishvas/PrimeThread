
package primeThreads.store;


import java.util.Vector;


import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;

public class Results implements ResultsInterface {
    // appropriate data structure as private data member
	// appropriate method to save prime number to the data structure
	
	Vector<Integer> hm = null;
	/**
	 * Creating the vector
	 */
	public Results(){
		Logger.writeMessage("Result's Constructor Vector Created", DebugLevel.CONSTRUCTOR);
		hm = new Vector<>();

	}
	
    
	/**
	 * Inserting the data elements
	 */
	public void insert(int number){
		hm.add(number);

	}
	/**
	 * Display the stored data of vector
	 */
public void showData(){
		for (int i = 0; i < hm.size(); i++) {
			Logger.writeMessage("Stored Data Value:"+ hm.get(i),DebugLevel.DATASTRUCTURE);
		}
			
	}	
	/**
	 * Write the total sum on screen
	 */
public void writeSumToScreen() {
    	int sum=0;

    	for (int i = 0; i < hm.size(); i++) {
    		
    		sum = sum + hm.get(i);
		}
    	
    	Logger.writeMessage("The sum of all the prime numbers is:"+sum,DebugLevel.OUTPUT);
	}
}



