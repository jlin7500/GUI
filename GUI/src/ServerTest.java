import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;



public class ServerTest {
	static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    
    private static String clientNotification;
    private static int numOfMessagesSaved = 0;
    
    public static void main(String[] args) {
        String clientInput = "";
        String serverOutput = "";
        String response = "";
        Scanner input;
        
        
        boolean serverRunning = false;

        try {
        	clientNotification = " ";
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
                	
                  Car newCar = new Car(inputData[3], inputData[4], inputData[5], inputData[6], Integer.parseInt(inputData[7]));
                  vc.addNewCar(newCar);
                  
                  break;
                  
                case "ClientNotifications":
                	
                	clientNotification="<html>"+clientNotification+"</html>";
                    output = clientNotification;
                    clientNotification = "";
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
                    
                case "AdminJobSize":
                    output = String.valueOf(vc.getRequestListSize());
                    break;
                case "AdminCarSize":
                    output = String.valueOf(vc.getCarListSize());
                    break;
                    
                case "AdminRequests":
                    output = vc.getAllJobRequests();
                    break;
                    
                case "AdminCars":
                    output = vc.getListOfAvailableCars();
                    break;
                    
                case "AdminApprove":
                	
                	clientNotification = clientNotification + 
                	"Your job request: "+
                			vc.approveNewJob(Integer.parseInt(inputData[1])-1,Integer.parseInt(inputData[2])-1)
                	+ "was approved";
                	output = "Job has been Approved<br/>";
                    break;
                    
                case "AdminDeny":
                	clientNotification = clientNotification + 
                	"Your job request: "+
                		vc.denyNewJob(Integer.parseInt(inputData[1])-1)
                	+"has been denied <br/>";
                	output = "had been Denied";
                    break;
                default:
                  // code block
              }
                
                numOfMessagesSaved = numOfMessagesSaved  + 1;
                getMessageSavedCount();
                outputStream.writeUTF(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    public static void getMessageSavedCount() {
    	System.out.println("Number of Messages Processed: "+numOfMessagesSaved);
    }
}
