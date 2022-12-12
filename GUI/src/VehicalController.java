import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VehicalController {

	static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/vc3?useTimezone=true&serverTimezone=UTC";
	private static String username = "root";
	private static String password = "hxW3&pol12$&KltfQRY#414VvuUW9";
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
		if (CURRENT_MODEL == null) {
			sendToDatabase("DELETE FROM jobrequests");
			sendToDatabase("DELETE FROM cars");
			sendToDatabase("DELETE FROM jobs");
			CURRENT_MODEL = new VehicalController();
		}
			
		return CURRENT_MODEL;
	}

	public static String getAllJobRequests() {
		ArrayList<Job> requestList = CURRENT_MODEL.JOB_REQUESTS;
		String output = "";
		if (requestList.size() == 0)
			output = "No Current Job Requests<br/>";
		else {
			for (int i = 0; requestList.size() > i; i++) {
				output = output + "Request "+(i+1)+". "+requestList.get(i).getRequestAsString() + "<br/>";
			}
		}
		return output;
	}

	public static String getListOfAvailableCars() {
		ArrayList<Car> carList = CURRENT_MODEL.CAR_LIST;
		String output = "";
		if (carList.size() == 0)
			output = "No Cars Available<br/>";
		else {
			for (int i = 0; carList.size() > i; i++) {
				output = output + "Car "+(i+1)+". "+carList.get(i).getCarAsString() + "<br/>";
			}
		}
		return output;
	}

	public static String getAllCurrentJobs() {
		ArrayList<Job> jobList = CURRENT_MODEL.CURRENT_JOBS;
		String output = "";
		if (jobList.size() == 0)
			output = "No Current Ongoing Jobs<br/>";
		else {
			for (int i = 0; jobList.size() > i; i++) {
				output = output + jobList.get(i).getJobAsString() + "<br/>";
			}
		}
		return output;
	}

	public static String getVCInfo() {
		return "<html>JOB REQUESTS: <br/>" + CURRENT_MODEL.getAllJobRequests() + "\nLIST OF AVAILABLE CARS: <br/>"
				+ CURRENT_MODEL.getListOfAvailableCars() + "\nCURRENT JOBS: <br/>" + CURRENT_MODEL.getAllJobRequests()+"</html>";
	}

	public static void addNewJobRequest(Job request) {
		CURRENT_MODEL.JOB_REQUESTS.add(request);
	}

	public static Job removeJobRequest(int request) {
		return CURRENT_MODEL.JOB_REQUESTS.remove(request);
	}

	public static void addNewCar(Car newCar) {
		CURRENT_MODEL.CAR_LIST.add(newCar);
	}

	public static String denyNewJob(int jobIndex) {
		//System.out.print("not works");
		Job job = JOB_REQUESTS.remove(jobIndex);
		//System.out.print("works");
		job.changeStatus("denied");
		archieveJob(job);
		return job.getRequestAsString();
	}

	public static String approveNewJob(int jobIndex, int carIndex) {
		Job job = removeJobRequest(jobIndex);
		Car car=CURRENT_MODEL.CAR_LIST.remove(carIndex);
		job.changeStatus("ongoing");
		car.changeStatus("in use");
		job.assignCar(car);
		// job.addNewDeadline(newDeadline);
		// job.addNewDuration(newDuration);
		CURRENT_MODEL.CURRENT_JOBS.add(job);
		//CURRENT_MODEL.CAR_LIST.add(car);
		return job.getRequestAsString();
		
	}

	private static void archieveJob(Job job) {
		CURRENT_MODEL.ARCHIEVE_JOBS.add(job);
	}
	
	public static int getRequestListSize() {
		return JOB_REQUESTS.size();
	}
	
	public static int getCarListSize() {
		return CAR_LIST.size();
	}
	
	public static int getJobListSize() {
		return CURRENT_JOBS.size();
	}
	
	public static void sendToDatabase(String sqlCommand) {
        try {
            // System.out.print("sql start");
            // declares a connection to your database
            connection = DriverManager.getConnection(url, username, password);
            // creates an insert query
            String sql = sqlCommand;
            // establishes the connection session
            Statement statement = connection.createStatement();
            // executes the query
            int row = statement.executeUpdate(sql);
            // the return value is the indication of success or failure of the query
            // execution
            if (row > 0)
                System.out.println("Data was inserted!");
            // System.out.print("sql end");
            connection.close();

        } catch (SQLException f) {
            System.out.print("sql failure");
            f.getMessage();

        }

    }
}
