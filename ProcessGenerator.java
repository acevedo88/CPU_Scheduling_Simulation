import java.util.Random;

public class ProcessGenerator {

	private Random rand = new Random();

	private double probability;

	public ProcessGenerator(double probability) {

		this.probability = probability;

	}

	public Process getNewProcess(int arrivalTime, int processTime, int priorityLevel) {

		int pLevel = rand.nextInt(priorityLevel) + 1;
		int timeProcess = rand.nextInt(processTime) + 1;
		Process process = new Process(arrivalTime, timeProcess, pLevel);
		return process;

	}

	public boolean query() {

		if (probability <= rand.nextDouble()) {
			
			return true;
			
		} 
		else {
			
			return false;
			
		}
	}

}