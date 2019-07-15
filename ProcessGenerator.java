import java.util.Random;

public class ProcessGenerator {
	
	private double probability;
	Random rand;

	public ProcessGenerator(double probability) {
		this.probability = probability;
		rand = new Random();
	}
	
	

	public boolean query() {
		
		boolean retVal = false;
		double randomize = rand.nextDouble();
		
		if(randomize <= probability) {
			return true;
		}
		
		return retVal;
	}
	
	
	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {
		rand = new Random();
		
		int priorityLevel = rand.nextInt(maxLevel) + 1;
		int timeRemaining = rand.nextInt(maxProcessTime) + 1;
		
		Process newProcess = new Process(priorityLevel, timeRemaining, currentTime);
		newProcess.resetTimeNotProcessed();
		
		return newProcess;
	}

}