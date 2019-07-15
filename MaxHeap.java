import java.util.ArrayList;

public class MaxHeap<T>{

	private ArrayList<Process> maxHeap;
	private int size; 


	public MaxHeap() {
		maxHeap = new ArrayList<Process>();
		size = 0;
	}


	public void add(Process p) {
		maxHeap.add(p);
		size++;
		maxHeapifyUp(maxHeap,maxHeap.size()-1);
	}


	public int getLeftIndex(int index) {
		return (index*2)+1;
	}


	public void exchange(int i, int j) {
		if(maxHeap.size() > 0 && i!=j) {
			Process temp = maxHeap.get(i);
			maxHeap.set(i,maxHeap.get(j));
			maxHeap.set(j, temp);
		}
	}



	public int getRightIndex(int index) {
		return (1+index) * 2;
	}


	public int getParentIndex(int index){
		return ((index-1)/2);

	}


	public ArrayList<Process> getMaxHeapArray() {
		return maxHeap;
	}

	public int size() {
		return maxHeap.size();
	}


	public Process get(int index) {
		return maxHeap.get(index);
	}


	public void set(int index, Process element) {
		maxHeap.set(index, element);
	}

	public Process remove(int index) {
		return maxHeap.remove(index);
	}


	public void maxHeapifyDown(ArrayList<Process> A, int i) {

		int l = getLeftIndex(i);
		int r = getRightIndex(i);
		int largest;

		if(l < A.size() && A.get(l).compareTo(A.get(i)) == 1) {
			largest = l;
		}else {
			largest = i; 
		}

		if(r < A.size() && A.get(r).compareTo(A.get(largest)) == 1) {
			largest = r; 
		}

		if(largest != i) {
			exchange(i,largest);
			maxHeapifyDown(A,largest);
		}		
	}


	public void maxHeapifyUp(ArrayList<Process> A ,int i) {
		if(i != 0) {
			int parent = getParentIndex(i);
			if(A.get(i).compareTo(A.get(parent)) == 1) {
				exchange(i,parent);
				maxHeapifyUp(A,parent);
			}
		}
	}


	public void update(int timeToIncrementPriority, int maxLevel) {

		if(maxHeap.size() != 0) {

			for(int i = 0; i < maxHeap.size(); i++) {

				maxHeap.get(i).incrementTimeNotProcessed();

				if(maxHeap.get(i).getTimeNotProcessed() >= timeToIncrementPriority) {  

					maxHeap.get(i).resetTimeNotProcessed();
					if(maxHeap.get(i).getPriority() < maxLevel) {

						maxHeap.get(i).makePriority();
						maxHeapifyUp(maxHeap, i);
					}

				}

			}

		}



	}



	public Process extractMaxHeap() {
		Process max = null;
		if(maxHeap.size() > 0) {
			exchange(0,maxHeap.size()-1);
			max = maxHeap.remove(maxHeap.size()-1);
			size--;
			maxHeapifyDown(maxHeap,0);
		}
		return max;
	}

}