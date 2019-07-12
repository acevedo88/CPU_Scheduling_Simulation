import java.util.Random;

public class Process {

	Random rand = new Random();
	private int timeLeft;
	private int priority;
	private int startingTime;
	private int timeNotProcessed;

	public Process(int startingTime, int timeLeft, int priority) {

		this.timeNotProcessed = 0;
		this.startingTime = startingTime;
		this.priority = rand.nextInt(priority) + 1;
		this.timeLeft = rand.nextInt(timeLeft) + 1;

	}

	public int compareTo(Process p) {                              
		if (this.priority < p.priority) {
			return -1;
		} else if (this.priority > p.priority) {
			return 1;
		} else{
			if (this.getArrivalTime() <= p.getArrivalTime()) { 
				return 1;
			} else{
				return -1; 
			}
		}
	}

	public int getPriority() {
		return priority;
	}

	public int getTimeRemaining() { 
		return this.timeLeft;
	}

	public void reduceTimeRemaining() {
		timeLeft--;
	}

	public int getTimeNotProcessed() {
		return timeNotProcessed;
	}
	
	public boolean finish() { 
		if (this.timeLeft == 0) {
			
			return true;
		} else {
			return false;
		}
	}

	public int getArrivalTime() { 
		return this.startingTime;
	}
	
	public void incrementTimeNotProcessed() {
		timeNotProcessed++;
	}

	public void resetTimeNotProcessed() { 
		timeNotProcessed = 0;

	}

	public void incrementPriority() {
		priority++;
		resetTimeNotProcessed();
	}
	
	


}