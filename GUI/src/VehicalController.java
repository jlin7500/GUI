import java.util.ArrayList;

public class VehicalController {

	private static VehicalController CURRENT_MODEL;
	private static ArrayList<Job> JOB_REQUESTS;
	private static ArrayList<Job> CURRENT_JOBS;
	private static ArrayList<Job> ARCHIEVE_JOBS;
	private static ArrayList<Client> CLIENT_LIST;
	private static ArrayList<Car> CAR_LIST;

	private VehicalController() {
		JOB_REQUESTS = new ArrayList<Job>();
		CURRENT_JOBS = new ArrayList<Job>();
		ARCHIEVE_JOBS = new ArrayList<Job>();
		CLIENT_LIST = new ArrayList<Client>();
		CAR_LIST = new ArrayList<Car>();
	}

	public static VehicalController accessController() {
		if (CURRENT_MODEL == null)
			CURRENT_MODEL = new VehicalController();
		return CURRENT_MODEL;
	}

	public static String getAllJobRequests() {
		ArrayList<Job> requestList = CURRENT_MODEL.JOB_REQUESTS;
		String output = "";
		if (requestList.size() == 0)
			output = "No Current Job Requests";
		else {
			for (int i = 0; requestList.size() > i; i++) {
				output = output + requestList.get(i).getRequestAsString() + "\n";
			}
		}
		return output;
	}

	public static String getListOfAvailableCars() {
		ArrayList<Car> carList = CURRENT_MODEL.CAR_LIST;
		String output = "";
		if (carList.size() == 0)
			output = "No Cars Available";
		else {
			for (int i = 0; carList.size() > i; i++) {
				output = output + carList.get(i).getCarAsString() + "\n";
			}
		}
		return output;
	}

	public static String getAllCurrentJobs() {
		ArrayList<Job> jobList = CURRENT_MODEL.CURRENT_JOBS;
		String output = "";
		if (jobList.size() == 0)
			output = "No Current Ongoing Jobs";
		else {
			for (int i = 0; jobList.size() > i; i++) {
				output = output + jobList.get(i).getJobAsString() + "\n";
			}
		}
		return output;
	}

	public static String getVCInfo() {
		return "JOB REQUESTS: \n" + CURRENT_MODEL.getAllJobRequests() + "\nLIST OF AVAILABLE CARS: \n"
				+ CURRENT_MODEL.getListOfAvailableCars() + "\nCURRENT JOBS: \n" + CURRENT_MODEL.getAllJobRequests();
	}

	public static void addNewJobRequest(Job request) {
		CURRENT_MODEL.JOB_REQUESTS.add(request);
	}

	public static void removeJobRequest(Job request) {
		CURRENT_MODEL.JOB_REQUESTS.remove(request);
	}

	public static void addNewCar(Car newCar) {
		CURRENT_MODEL.CAR_LIST.add(newCar);
	}

	public static void denyNewJob(Job job) {
		job.changeStatus("denied");
		archieveJob(job);
	}

	public static void approveNewJob(Job job, Car car) {
		removeJobRequest(job);
		job.changeStatus("ongoing");
		car.changeStatus("in use");
		job.assignCar(car);
		// job.addNewDeadline(newDeadline);
		// job.addNewDuration(newDuration);
		CURRENT_MODEL.CURRENT_JOBS.add(job);
	}

	private static void archieveJob(Job job) {
		CURRENT_MODEL.ARCHIEVE_JOBS.add(job);
	}
}
