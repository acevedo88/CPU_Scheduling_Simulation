import java.util.ArrayList;

public class MaxHeap {

	private ArrayList<Process> heap;
	private int size;

	public MaxHeap() {
		heap = new ArrayList<Process>();
	}

	public void MaxHeapifyUp(int input) {

		if (input > 0 && input < heap.size()) {

			Process curr = heap.get(input);
			Process prev = heap.get(input - 1);

			if (curr.compareTo(prev) == 1) {
				int prevNewIndex = heap.indexOf(curr);
				heap.set(heap.indexOf(prev), curr);
				heap.set(prevNewIndex, prev);
				MaxHeapifyUp(heap.indexOf(curr));
			} else if (curr.compareTo(prev) == 0) {
				if (curr.getArrivalTime() < prev.getArrivalTime()) {
					int prevNewIndex = heap.indexOf(curr);
					heap.set(heap.indexOf(prev), curr);
					heap.set(prevNewIndex, prev);
					MaxHeapifyUp(heap.indexOf(curr));
				}
			}

		}

	}

	public int getSize() {
		return size;
	}

	public void add(Process p) {
		heap.add(p);
		MaxHeapifyUp(heap.indexOf(p));

	}

	public void remove(Process p) {
		heap.remove(p);
		if (heap.size() > 1) {
			MaxHeapifyUp(heap.size() - 1);
		}

	}

	public Process getMax() {
		if (heap.size() > 0) {
			return heap.get(0);
		} else {
			return null;
		}

	}

	public void removeMax() {
		this.remove(getMax());
		if (heap.size() > 1) {
			MaxHeapifyUp(heap.size() - 1);
		}

	}

	public void clearHeap() {
		heap.clear();
		heap.add(null);
	}

	public Process getIndex(int index) {
		return heap.get(index);
	}

	public boolean isEmpty() {
		if (heap.size() < 1) {
			return true;
		} else {
			return false;
		}
	}

}