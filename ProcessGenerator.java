/*
 * @author Alex Acevedo
 * CS 321
 * Project 2 - CPU Scheduling Simulation 
 * 
 * This Class will randomly generate a process with a given probability.  In addition
 * while generating a new process, both its priority and the required time units to finish 
 * the process are randomly generated within given ranges
 * 
 */
import java.util.Random;

public class ProcessGenerator {
	
	//Creates a variable for probability and a Random value
	private double probability;
	Random random;

	//Instantiates the variables
	public ProcessGenerator(double probability) {
		this.probability = probability;
		random = new Random();
	}
	
	//Boolean used to check if the random value is less then the value required
	public boolean query() {
		
		boolean returnValue = false;
		double randomValue = random.nextDouble();
		
		if(randomValue <= probability) {
			return true;
		}
		
		return returnValue;
	}
	
	//Process class that will create a new process 
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		
		random = new Random();
		
		int priorityLevel = random.nextInt(maxLevel) + 1;
		int timeRemaining = random.nextInt(maxProcessTime) + 1;
		
		Process newProcess = new Process(priorityLevel, timeRemaining, currentTime);
		newProcess.resetTimeNotProcessed();
		
		return newProcess;
	}

}