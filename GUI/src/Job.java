
public class Job {
		
	Client assignedClient;
	String deadline;
	String duration;
	String status;
	
	public Job(){
		status = "Requested";
		
	}
	
	private void addNewClient (Client newClient) {
		assignedClient = newClient;
	}
	
	private void addNewDeadline(String newDeadline) {
		deadline = newDeadline;
	}
	
	private void addNewDuration (String newDuration) {
		duration = newDuration;
	}
	
	private void changeStatus(String newStatus) {
		status = newStatus;
	}
}
