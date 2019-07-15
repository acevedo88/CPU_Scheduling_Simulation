/*
 * @author Alex Acevedo
 * CS 321
 * Project 2 - CPU Scheduling Simulation 
 * 
 * 
 * This class will define a process and will implement the comparable class
 */
public class Process implements Comparable<Process> {
	
	//Private variables used globally
	private int priorityLevel;
	private double timeRemaining; 
	private double arrivalTime;
	private double timeNotProcessed;
	
	//Instantiates the variables
	public Process(int priorityLevel, double timeRemaining, double arrivalTime) {
		this.priorityLevel = priorityLevel;
		this.timeRemaining = timeRemaining;
		this.arrivalTime = arrivalTime;
		timeNotProcessed = 0;
	}

	//Compare to method that will compare priorities or arrival time
	@Override
	public int compareTo(Process p) {
		if(this.priorityLevel > p.getPriority()) {
			return 1;
		}
		else if(this.priorityLevel < p.getPriority()) {
			return -1;
		}
		else if(this.arrivalTime <= p.getArrivalTime()) {
			
			return 1;
			
		}
		return -1;
	}
	
	//Increments priority 
	public void makePriority() {
		 priorityLevel++;
	}
	
	//Sets a priority level value
	public void setPriorityLevel(int pLevel) {
		this.priorityLevel = pLevel;
	}

	//Gets the priority value
	public int getPriority() {
		return priorityLevel;
	}
	
	//Sets the time remaining for the process
	public void setTimeRemaining(double timeToFinish) {
		this.timeRemaining = timeToFinish;
	}

	//gets the time remaining for the process
	public double getTimeRemaining() {
		return timeRemaining;
	}
	
	//Sets the arrival time for the process
	public void setArrivalTime(double arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	//gets the arrival time for the process
	public double getArrivalTime() {
		return arrivalTime;
	}
	
	//Increments the time for a process
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}

	//decrements the time remaining for the process
	public void reduceTimeRemaining() {
		timeRemaining--;
	}
	
	//sets true or false if not finished or finished
	public boolean finish() {
		return timeRemaining == 0;
	}
	
	//resets the process time to 0
	public void resetTimeNotProcessed() {
		timeNotProcessed = 0; 
	}
	
	//Gets the time for the process
	public double getTimeNotProcessed() {
		return timeNotProcessed;
	}


}