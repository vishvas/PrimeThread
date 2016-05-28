package primeThreads.store;
/**
 * Result interface which extends stdoutput and store data interface
 * @author Vishvas
 *
 */
public interface ResultsInterface extends StdoutDisplayInterface, StoreDataInterface{
	public void writeSumToScreen();
	public void insert(int i);
}
