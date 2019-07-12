public class PQueue {

	private boolean isEmpty = true;
	MaxHeap qHeap = new MaxHeap();

	public PQueue() {

	}

	public void enPQueue(Process p) {
		if (p.getTimeRemaining() != 0) {
			isEmpty = false;
			qHeap.add(p);
		}
	}

	public boolean isEmpty() {

		return isEmpty;
	}

	public Process dePQueue() {
		Process root = qHeap.getMax(); 
		qHeap.removeMax(); 

		if (qHeap.isEmpty()) {
			isEmpty = true;
		} else {

			qHeap.MaxHeapifyUp(qHeap.getSize() - 1); 

		}
		return root;

	}
	

	   public void clearQueue(){
	       qHeap.clearHeap();
	   }


	public void update(int timeToIncrementLevel, int maxLevel) {

		for (int i = 1; i < qHeap.getSize(); i++) { 

			Process p = qHeap.getIndex(i); 
			p.incrementTimeNotProcessed();

			if (p.getTimeNotProcessed() >= timeToIncrementLevel) {

				if (p.getPriority() < maxLevel) {
					p.incrementPriority();
					qHeap.MaxHeapifyUp(i); 
				}

				p.resetTimeNotProcessed();

			}
		}

	}

	public String toString() {

		return qHeap.toString();

	}

}