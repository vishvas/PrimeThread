package primeThreads.util;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import primeThreads.util.Logger;
import primeThreads.util.Logger.DebugLevel;


// File reading code

public class FileProcessor {
	FileInputStream fstream;
	BufferedReader br;
	PrintStream out;
	private String fileName;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * Parsing the input file
	 * @param fileName
	 * @throws IOException
	 */
	public FileProcessor(String fileName) throws IOException{
		// Open the file
				
				 fstream = new FileInputStream(fileName);
				 Logger.writeMessage("File Processor Constructor Called", Logger.DebugLevel.CONSTRUCTOR);
				 br = new BufferedReader(new InputStreamReader(fstream));
				 
				 
	}
	public void fileClose() throws IOException{
		 // file close
	      br.close();
	}
	public String readLineFromFile() {
		try {
			
			return br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
