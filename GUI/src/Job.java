
public class Job {
		
	private String assignedClient;
	private int assignedClientId;
	private int deadline;
	private int duration;
	private String status;
	private Car assignedCar;
	
	public Job(){
		status = "Requested";
		
	}
	
	public void addNewClient (String newClient, int newClientId) {
		assignedClient = newClient;
		assignedClientId = newClientId;
	}
	
	public void addNewDeadline(int newDeadline) {
		deadline = newDeadline;
	}
	
	public void addNewDuration (int newDuration) {
		duration = newDuration;
	}
	
	public void changeStatus(String newStatus) {
		status = newStatus;
	}
	
	public void assignCar(Car car) {
		assignedCar = car;
	}
	
	public String getRequestAsString() {
		return "Client: "+assignedClient+" ClientId: "+assignedClientId+" Deadline: "+deadline+" Duration: "+duration;
	}
	
	public String getJobAsString() {
		return "Job Status "+status+" Client: "+assignedClient+" ClientId: "+assignedClientId+" Deadline: "+deadline+" Duration: "+duration+" Car Model: "+assignedCar.getCarModel();
	}
}
