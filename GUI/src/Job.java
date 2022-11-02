
public class Job {

	String assignedClient;
	String deadline;
	String duration;
	String status;

	public Job() {
		status = "Requested";

	}

	public void addNewClient(String newClient) {
		assignedClient = newClient;
	}

	public void addNewDeadline(String newDeadline) {
		deadline = newDeadline;
	}

	public void addNewDuration(String newDuration) {
		duration = newDuration;
	}

	public void changeStatus(String newStatus) {
		status = newStatus;
	}
}