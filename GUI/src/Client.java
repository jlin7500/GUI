import java.util.ArrayList;

public class Client extends User {

	private ArrayList<Job> jobs;

	public Client(String newName, String newId, int newPhoneNumber) {
		super(newName, newId, newPhoneNumber);
	}

	public void registerForNewJob() {
		Job newJob = new Job();
		newJob.addNewClient(name, id);
		jobs.add(newJob);
	}

}
