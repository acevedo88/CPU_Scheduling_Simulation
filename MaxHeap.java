/*
 * @author Alex Acevedo
 * CS 321
 * Project 2 - CPU Scheduling Simulation 
 * 
 * This class defines a Max-Heap in which each node in the max-heap contains a process
 * 
 */
import java.util.ArrayList;

//Class that will take in any variable due to the Generic <T>
public class MaxHeap<T>{

	//Creates a Generic from the Process Class and creates a variable for the heap-size
	private ArrayList<Process> maxHeap;
	private int heapSize; 

	//Creates a new generic ArrayList and sets the size to 0
	public MaxHeap() {
		
		maxHeap = new ArrayList<Process>();
		
		heapSize = 0;
	}
	
	//Method used to HeapifyUp a list to sort the elements by comparing them to one and another
	//Based on its findings, it will exchange the elements and heap up till it reaches the top
	public void maxHeapifyUp(ArrayList<Process> A ,int index) {
		if(index != 0) {
			int parent = getParentIndex(index);
			
			if(A.get(index).compareTo(A.get(parent)) == 1) {
				
				exchange(index,parent);
				
				maxHeapifyUp(A,parent);
			}
		}
	}
	

	//Method used to heapifyDown by comparing its left and right index. Will exchange and heapify 
	//down based on results
	public void maxHeapifyDown(ArrayList<Process> A, int i) {
		
		int leftIndex = getLeftIndex(i);
		int rightIndex = getRightIndex(i);
		int largestValue;
		
		if(leftIndex < A.size() && A.get(leftIndex).compareTo(A.get(i)) == 1) {
			largestValue = leftIndex;
		}
		
		else {
			largestValue = i; 
		}
		
		if(rightIndex < A.size() && A.get(rightIndex).compareTo(A.get(largestValue)) == 1) {
			largestValue = rightIndex; 
		}
		
		if(largestValue != i) {
			
			exchange(i,largestValue);
			
			maxHeapifyDown(A,largestValue);
		}		
	}
	
	//Method that will update the heap each time a new process is introduced
	//Will set new times, priorities, and move the process accordingly
	public void update(int incrementTimePriority, int topLevel) {
		
		if(maxHeap.size() != 0) {
			
			for(int i = 0; i < maxHeap.size(); i++) {
				
				maxHeap.get(i).incrementTimeNotProcessed();
				
				if(maxHeap.get(i).getTimeNotProcessed() >= incrementTimePriority) {  
					
					maxHeap.get(i).resetTimeNotProcessed();
					
					if(maxHeap.get(i).getPriority() < topLevel) {
						
						maxHeap.get(i).makePriority();
						
						maxHeapifyUp(maxHeap, i);
					}
					
				}
				
			}
			
		}
		
		
		
	}
	
	//Add method that will add a process to the top, increment size, and sort with heapifyUp
	public void add(Process p) {
		
		maxHeap.add(p);
		
		heapSize++;
		
		maxHeapifyUp(maxHeap,maxHeap.size()-1);
	}
	
	//Method used to get the left index based on heap formula and tree structure
	public int getLeftIndex(int index) {
		
		return (index*2)+1;
	}

	//Method used to get the right index based on heap formula and tree structure
	public int getRightIndex(int index) {
		
		return (1+index) * 2;
	}
	
	//Method used to get the parent index based on heap formula and tree structure
	public int getParentIndex(int index){
		
		return ((index-1)/2);
		
	}
	
	//Method that will extract a process from the heap and remove it
	public Process pullMaxHeap() {
		
		Process max = null;
		
		if(maxHeap.size() > 0) {
			
			exchange(0,maxHeap.size()-1);
			
			max = maxHeap.remove(maxHeap.size()-1);
			
			heapSize--;
			
			maxHeapifyDown(maxHeap,0);
		}
		return max;
	}

	//Method used to exchange two values
	public void exchange(int i, int j) {
		
		if(maxHeap.size() > 0 && i!=j) {
			
			Process temp = maxHeap.get(i);
			
			maxHeap.set(i,maxHeap.get(j));
			
			maxHeap.set(j, temp);
		}
	}

	//Method used to get the entire heap array
	public ArrayList<Process> getMaxHeapArray() {
		
		return maxHeap;
	}

	//Method that returns the size of the heap
	public int size() {
		
		return maxHeap.size();
	}

	//Method that will get an element in the heap based on the index
	public Process get(int index) {
		
		return maxHeap.get(index);
	}

	//Method used to set the element in the array at a specific index
	public void set(int index, Process element) {
		
		maxHeap.set(index, element);
	}

	//Method that will remove an element at a specific index
	public Process remove(int index) {
		
		return maxHeap.remove(index);
	}


}