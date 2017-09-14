package net.dvt32.concurrency.task4;

/**
 * This program starts two threads at the same time
 * and both of them count and print numbers 
 * from some start value to an end value.
 * 
 * When one of the counter threads counts,
 * it stops and lets the other one count as well.
 * This process is repeated until both of them reach their end value.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class SynchronizedCounterThread
	implements Runnable
{
	private Thread counterThread;
	private int startValue;
	private int endValue;
	
	/**
	 * This constructor initializes the internal counter thread and gives it a name.
	 * 
	 * The start value MUST be greater than the end value,
	 * otherwise an IllegalArgumentException is thrown.
	 * 
	 * @param startValue The start number value
	 * @param endValue The end number value
	 * @param threadName The counter thread's name
	 */
	public SynchronizedCounterThread(int startValue, int endValue, String threadName) {
		if (startValue > endValue) {
			throw new IllegalArgumentException("Start value CAN'T be larger than end value!");
		}
		
		counterThread = new Thread(this, threadName);
		this.startValue = startValue;
		this.endValue = endValue;
	}
	
	/**
	 * This method returns the internal counter thread.
	 * It is used in order to start the thread.
	 * 
	 * @return the counter thread
	 */
	public Thread getCounterThread() {
		return counterThread;
	}
	
	/**
	 * This method shows what's happening when the counter thread is running.
	 * 
	 * It is synchronized, which allows both threads to count at the same rate.
	 */
	public synchronized void run() {
		int currentValue = startValue;
		
		while (currentValue <= endValue) {
			System.out.println( counterThread.getName() + ": " + currentValue);
			currentValue++;
		}
	}
	
	/**
	 * This is the program's main method. 
	 * 
	 * It starts two counter threads, which both 
	 * count from some start value to some end value.
	 * 
	 * When one thread counts, it lets the 
	 * other one count as well, before continuing.
	 */
	public static void main(String[] args) {
		SynchronizedCounterThread a = new SynchronizedCounterThread(1, 5, "a");
		SynchronizedCounterThread b = new SynchronizedCounterThread(1, 5, "b");

		a.getCounterThread().start();
		b.getCounterThread().start();
	}
}