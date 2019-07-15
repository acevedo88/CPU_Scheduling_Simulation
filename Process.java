
public class Process implements Comparable<Process> {
	
	private int priorityLevel;
	private int timeRemaining; 
	private int arrivalTime;
	private int timeNotProcessed;
	

	public Process(int priorityLevel, int timeRemaining, int arrivalTime) {
		this.priorityLevel = priorityLevel;
		this.timeRemaining = timeRemaining;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}

	public void makePriority() {
		 priorityLevel++;
	}
	

	public int getPriority() {
		return priorityLevel;
	}
	
	
	public void setPriorityLevel(int pLevel) {
		this.priorityLevel = pLevel;
	}

	public int getTimeRemaining() {
		return timeRemaining;
	}
	

	public void setTimeRemaining(int timeToFinish) {
		this.timeRemaining = timeToFinish;
	}
	

	public int getArrivalTime() {
		return arrivalTime;
	}
	

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	
	@Override
	public int compareTo(Process o) {
		if(this.priorityLevel > o.getPriority()) {
			return 1;
		}else if(this.priorityLevel < o.getPriority()) {
			return -1;
		}else if(this.arrivalTime <= o.getArrivalTime()) {
			 
				return 1;
				
		}
		return -1;
	}
	

	public void reduceTimeRemaining() {
		timeRemaining--;
	}
	

	public boolean finish() {
		return timeRemaining == 0;
	}
	

	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	

	public void resetTimeNotProcessed() {
		timeNotProcessed = 0; 
	}

	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}



}