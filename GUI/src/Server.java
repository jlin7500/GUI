import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
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
                System.out.println("Would you like to save this message? y/n?");
                input = new Scanner(System.in);
                response = input.nextLine();
                while (!response.equals("y") || !response.equals("n")) {
                    if (response.toLowerCase().equals("y")) {
                        System.out.println("Information accepted");
                        serverOutput = "messageAccepted";
                        break;
                    } else if (response.toLowerCase().equals("n")) {
                        System.out.println("Information rejected");
                        serverOutput = "messageReject";
                        break;
                    } else {
                        System.out.println("That is not a valid response. Please try again.");
                        response = input.nextLine();
                    }
                }
                getMessageSavedCount();
                // outputStream.writeUTF(serverOutput);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void getMessageSavedCount() {
        System.out.print("Number of Messages Saved: " + numOfMessagesSaved);
    }

}
