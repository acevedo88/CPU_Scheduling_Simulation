import java.util.Random;

public class ProcessGenerator {

	private Random rand;

	private double probability;

	public ProcessGenerator(double probability) {

		this.probability = probability;

		rand = new Random();

	}

	public ProcessGenerator(double probability, long seed) {

		this.probability = probability;

		rand = new Random(seed);

	}

	public Process getNewProcess(int arrivalTime, int processTime, int priorityLevel) {

		return new Process(arrivalTime, rand.nextInt(processTime) + 1, rand.nextInt(priorityLevel) + 1);

	}

	public boolean query() {

		return rand.nextDouble() <= probability;

	}

}