import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class ServerTest {
	static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    

    private static int numOfMessagesSaved = 0;
    
    public static void main(String[] args) {
        String clientInput = "";
        String serverOutput = "";
        String response = "";
        Scanner input;
        
        
        boolean serverRunning = false;

        try {
            serverRunning = true;
            System.out.println("Server Online");
            System.out.println("Waiting for Response from Client");
            serverSocket = new ServerSocket(3000);
            socket = serverSocket.accept();
            System.out.println("User Connected");

            while (serverRunning) {
                System.out.println("Waiting for Input");

                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                
                clientInput = inputStream.readUTF();
                System.out.println("Input received");
                System.out.println(clientInput.toString());
                String[] inputData = clientInput.split(";");
                
                String output = "Input received";
                VehicalController vc = null;
                vc = vc.accessController();
                
                switch(inputData[0]) {
                
                case "OwnerCarRegister":
                	
                  Car newCar = new Car(inputData[1], inputData[2], inputData[3], inputData[4]);
                  vc.addNewCar(newCar);
                  
                  break;
                  
                case "ClientRequest":
                	
                  Job jobRequest = new Job();
                  jobRequest.addNewClient(inputData[1], Integer.parseInt(inputData[2]));
                  jobRequest.addNewDuration(Integer.parseInt(inputData[3]));
                  jobRequest.addNewDeadline(Integer.parseInt(inputData[4]));
                  
                  vc.addNewJobRequest(jobRequest);
                  
                  break;
                  
                case "AdminHome":
                    output = vc.getVCInfo();
                    break;
                    
                case "AdminRequests":
                    output = vc.getAllJobRequests();
                    break;
                    
                case "AdminCars":
                    output = vc.getListOfAvailableCars();
                    break;
                    
                case "AdminApprove":
                	
                	Job acceptedJob = new Job();
                    acceptedJob.addNewClient(inputData[1], Integer.parseInt(inputData[2]));
                    acceptedJob.addNewDuration(Integer.parseInt(inputData[3]));
                    acceptedJob.addNewDeadline(Integer.parseInt(inputData[4]));
                    Car assignedCar = new Car(inputData[5], inputData[6], inputData[7], inputData[8]);
                    vc.approveNewJob(acceptedJob,assignedCar);
                	output = "Job has been Approved";
                    break;
                    
                case "AdminDeny":
                	Job deniedJob = new Job();
                    deniedJob.addNewClient(inputData[1], Integer.parseInt(inputData[2]));
                    deniedJob.addNewDuration(Integer.parseInt(inputData[3]));
                    deniedJob.addNewDeadline(Integer.parseInt(inputData[4]));
                	vc.denyNewJob(deniedJob);
                	output = "Job has been Denied";
                    break;
                default:
                  // code block
              }
                
                
                getMessageSavedCount();
                outputStream.writeUTF(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public static void getMessageSavedCount() {
    	System.out.println("Number of Messages Saved: "+numOfMessagesSaved);
    }
    
    /*
    public static void Stuff() {
    	System.out.println("Would you like to save this message? y/n?");
        input = new Scanner(System.in);
        response = input.nextLine();
        while(!response.equals("y") || !response.equals("n"))
        {
        	if (response.toLowerCase().equals("y")) {
                System.out.println("Information accepted");
                serverOutput = "messageAccepted";
                numOfMessagesSaved++;
                break;
            }
            else if(response.toLowerCase().equals("n"))
            {
                System.out.println("Information rejected");
                serverOutput = "messageReject";
                break;
            }
            else {
                System.out.println("That is not a valid response. Please try again.");
                response = input.nextLine();
            }
        }
    }
    */
}
