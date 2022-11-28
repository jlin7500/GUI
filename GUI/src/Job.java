
public class Job {

	private String assignedClient;
	private String assignedClientId;
	private String deadline;
	private String duration;
	private String status;
	private Car assignedCar;

	public Job() {
		status = "Requested";

	}

	public void addNewClient(String newClient, String newClientId) {
		assignedClient = newClient;
		assignedClientId = newClientId;
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

	public void assignCar(Car car) {
		assignedCar = car;
	}

	public String getRequestAsString() {
		return "Client: " + assignedClient + " ClientId: " + assignedClientId + " Deadline: " + deadline + " Duration: "
				+ duration;
	}

	public String getJobAsString() {
		return "Job Status " + status + " Client: " + assignedClient + " ClientId: " + assignedClientId + " Deadline: "
				+ deadline + " Duration: " + duration + " Car Model: " + assignedCar.getCarModel();
	}
}
