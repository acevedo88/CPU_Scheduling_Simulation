
public class PQueue {



	MaxHeap<Process> PQueue;

	public PQueue() {

		PQueue = new MaxHeap<Process>();

	}


	public void enPQueue(Process p) {
		PQueue.add(p);
	}

	public Process dePQueue() {

		Process extraction = PQueue.extractMaxHeap();
		extraction.resetTimeNotProcessed();

		return extraction;

	}

	public void update(int timeToIncrementPriority, int maxLevel) {

			PQueue.update(timeToIncrementPriority, maxLevel);

	}
	
	public boolean isEmpty() {

		return PQueue.size() == 0;

	}

}