/*
 * @author Alex Acevedo
 * CS 321
 * Project 2 - CPU Scheduling Simulation 
 * 
 * This class defines a priority queue using a max-heap
 * 
 */
public class PQueue {

	//Creates a global generic for PQueue
	MaxHeap<Process> PQueue;

	//Creates a Generic MaxHeap using the Process class
	public PQueue() {

		PQueue = new MaxHeap<Process>();

	}

	//Adds a process to the queue
	public void enPQueue(Process p) {
		PQueue.add(p);
	}

	//Removes a queued process by using the method instantiated in MaxHeap class
	public Process dePQueue() {

		Process deQueueMaxHeap = PQueue.pullMaxHeap();
		
		deQueueMaxHeap.resetTimeNotProcessed();

		return deQueueMaxHeap;

	}

	//updates the queued element
	public void update(int timeToIncrementPriority, int maxLevel) {

			PQueue.update(timeToIncrementPriority, maxLevel);

	}
	
	//Checks if the process queue is empty
	public boolean isEmpty() {

		return PQueue.size() == 0;

	}

}