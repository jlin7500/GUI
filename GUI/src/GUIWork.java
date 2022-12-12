import java.io.*;

import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;

import javax.imageio.ImageIO;
import javax.lang.model.util.AbstractAnnotationValueVisitor14;
import javax.swing.*;
import java.awt.Color;

import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;

public class GUIWork implements ActionListener {
    static Connection connection = null;
    static String projectUrl = "C:\\Users\\chris\\eclipse-workspace\\GUIWork\\";
    static String url = "jdbc:mysql://localhost:3306/vc3?useTimezone=true&serverTimezone=UTC";
    static String username = "root";
    static String password = "hxW3&pol12$&KltfQRY#414VvuUW9";
    static int pressed;
    static String listenServer = "listen";
    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;
    static JRadioButton[] radioList;

    static int amountOfJobs = 0;
    static int amountOfCars = 0;
    static int previousID = 0;
    static int totalDuration = 0;
    static int integerData = 0;
    static int idValueCount;
    static int completionTime;
    static String idValue;
    static int max = 9999;
    static int min = 1000;
    static int range = max - min + 1;
    static ArrayList<Integer> jobDurationList = new ArrayList<Integer>();
    static ArrayList<Integer> idList = new ArrayList<Integer>();
    private static JLabel userLabel;
    private static JLabel ownerLabel;
    private static JTextField userText;
    private static JTextField ownerText;

    private static JLabel jobInfo;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel ownerSuccess;
    private static JLabel title;
    private static JButton userButton;
    private static JButton ownerButton;
    private static JButton userInfoButton;
    private static JButton ownerInfoButton;
    private static JButton ownerBack;
    private static JButton userBack;
    private static JLabel message;

    private static JLabel userJobNum;
    private static JTextField userJobField;
    private static JTextField jobField;
    private static JTextField carField;

    private static JLabel userJobLabel;
    private static JLabel carLabel;

    private static JButton decisionBack;
    private static JButton decision;

    private static JButton accept;
    private static JButton deny;
    // Cloud controller
    private static JButton adminButton;
    private static JLabel adminUser;
    private static JLabel adminPass;
    private static JTextField adminUsername;
    private static JPasswordField adminPassword;
    private static JButton adminInfoButton;
    private static JLabel adminPrompt;
    private static JLabel adminSuccess;
    private static JButton adminClear;
    private static JButton adminBack;

    // Cloud controller commands
    private static JButton computeCompletionTime;
    private static JButton cloudBack;
    private static JButton viewJobInfo;
    private static JButton acceptJobPortal;
    private static JButton denyJobPortal;

    // Client
    private static JLabel Fillout;
    private static JLabel JobDuration;
    private static JTextField Hours;
    private static JLabel Deadline;
    private static JTextField Date;
    private static JButton SubButton;
    private static JLabel Received;
    private static JTextField ClientName;
    private static JButton clientClear;
    private static JLabel clientID;
    private static JTextField clientIDText;

    // Owner
    private static JLabel welcomeMessage;
    private static JLabel ownerName;
    private static JTextField name;
    private static JLabel vehicleInfo;
    private static JLabel carMake;
    private static JTextField make;
    private static JLabel carModel;
    private static JTextField model;
    private static JLabel carYear;
    private static JTextField year;
    private static JLabel carLocation;
    private static JTextField location;
    private static JLabel residencyTime;
    private static JTextField Time;
    private static JButton submit;
    private static JButton ownerClear;

    private static JFrame setBasicFrame(JFrame frame, int sizeX, int sizeY, boolean visability) {
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(visability);
        return frame;
    }

    private static JFrame setBasicFrame2(JFrame frame, int sizeX, int sizeY, boolean visability) {
        frame.setSize(sizeX, sizeY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(visability);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().layout();
        return frame;
    }

    private static JLabel setBackground(JLabel panel, JFrame frame, String imageFileName) {
        ImageIcon img9 = new ImageIcon(projectUrl + imageFileName);// "Background6.png"
        panel = new JLabel("", img9, JLabel.CENTER);
        frame.add(panel);
        return panel;
    }

    private static void setImage(JLabel panel, int imageScaleX, int imageScaleY, int UpBoundX, int UpBoundY,
            int LowBoundX, int LowBoundY, String imageFileName) throws IOException {
        BufferedImage img4 = ImageIO.read(new File(projectUrl + imageFileName));
        Image image4 = img4.getScaledInstance(imageScaleX, imageScaleY, Image.SCALE_SMOOTH);
        ImageIcon icon4 = new ImageIcon(image4);
        JLabel pic4 = new JLabel();
        pic4.setIcon(icon4);
        pic4.setBounds(UpBoundX, UpBoundY, LowBoundX, LowBoundY);// Above the message
        panel.add(pic4);
    }

    public static void main(String[] args) throws IOException {
        // Server Socket
        socket = new Socket("localhost", 3000);
        inputStream = new DataInputStream(socket.getInputStream());
        outputStream = new DataOutputStream(socket.getOutputStream());

        JFrame userFrame = setBasicFrame(new JFrame("Welcome Client !"), 500, 500, false);// client title section
        JFrame ownerFrame = setBasicFrame(new JFrame("Welcome Owner !"), 500, 500, false); // owner title section
        JFrame frame = setBasicFrame(new JFrame("Vehicular GUI"), 600, 600, true); // Home GUI title
        JFrame adminFrame = setBasicFrame(new JFrame("Cloud Controller"), 500, 500, false);

        JFrame jobAcceptFrame = setBasicFrame2(new JFrame("Job Request Accept Form"), 500, 500, false);// Admin Job
                                                                                                       // Request Accept
                                                                                                       // Frame
        JFrame jobDenyFrame = setBasicFrame2(new JFrame("Job Request Deny Form"), 500, 500, false); // Admin Job Request
                                                                                                    // Denial Frame
        JFrame cloudFrame = setBasicFrame2(new JFrame("Vehicle Controller Functions"), 700, 625, false);// Cloud Frame
                                                                                                        // with Table
        JFrame decisionFrame = setBasicFrame2(new JFrame("Accept or Deny"),500,500,false);
        JLabel panel = setBackground(new JLabel(), frame, "background5.png"); // Background
        JLabel userPanel = setBackground(new JLabel(), userFrame, "background4.png"); // Background for client
        JLabel adminPanel = setBackground(new JLabel(), adminFrame, "background.png"); // Background for Admin
        JLabel ownerPanel = setBackground(new JLabel(), ownerFrame, "background6.png");// Background for Owner
        JLabel cloudPanel = setBackground(new JLabel(), cloudFrame, "background6.png");// Background for Cloud
        JLabel acceptPanel = setBackground(new JLabel(), jobAcceptFrame, "background6.png"); // Background for Accept
        JLabel denyPanel = setBackground(new JLabel(), jobDenyFrame, "background6.png"); // Background for Deny


        setImage(panel, /* Image Scale */ 71, 71, /* Bounds */ 200, 145, 80, 100, "Client.png");// Main GUI images
        // (150,210,80,100) under client button

        setImage(panel, /* Image Scale */ 71, 71, /* Bounds */ 320, 145, 80, 100, "Owner.png");// GUI image 2
        // above owner button

        setImage(panel, /* Image Scale */ 117, 117, /* Bounds */ 236, 255, 175, 125, "VCcontroller.png");// GUI image 3
        // above VC button

        setImage(panel, /* Image Scale */ 100, 100, /* Bounds */ 245, 0, 150, 150, "cloud.png");// GUI image 4
        // Above the message

        decisionBack = new JButton(new AbstractAction("Back")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                decisionFrame.setVisible(false);
            }
        });

    

        // Table
        JTable timeTable = new JTable();
        Object[] column = { "Job ID", "Duration (hrs)" };
        DefaultTableModel timeModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // False
                return false;

            }
        }; // table non-editable

        timeTable.setRowSelectionAllowed(false);

        timeModel.setColumnIdentifiers(column);
        timeTable.setModel(timeModel);

        timeTable.setBackground(Color.white);
        timeTable.setForeground(Color.black);
        timeTable.setGridColor(Color.gray);
        timeTable.setFont(new Font("Times New Roman", Font.PLAIN, 17)); // Change font
        timeTable.setRowHeight(30);
        timeTable.setAutoCreateRowSorter(true);

        JScrollPane scroll = new JScrollPane(timeTable);
        scroll.setForeground(Color.blue);
        scroll.setBackground(Color.white);
        scroll.setBounds(100, 50, 500, 300);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        cloudPanel.add(scroll);

        // Row
        Object[] valueRow = new Object[2];


        // Welcome message
        ownerPanel.setLayout(null);
        welcomeMessage = new JLabel("Please fill out the following information");
        welcomeMessage.setBounds(10, 5, 300, 25);
        ownerPanel.add(welcomeMessage);
        // Owner name
        ownerName = new JLabel("Owner Name");
        ownerName.setBounds(10, 40, 80, 25);
        ownerPanel.add(ownerName);

        name = new JTextField();
        name.setBounds(100, 40, 165, 25);
        ownerPanel.add(name);

        // Vehicle Information
        vehicleInfo = new JLabel("Vehicle Information:");
        vehicleInfo.setBounds(10, 75, 150, 25);
        ownerPanel.add(vehicleInfo);

        // Make
        carMake = new JLabel("Make of Car");
        carMake.setBounds(10, 110, 80, 25);
        ownerPanel.add(carMake);

        make = new JTextField();
        make.setBounds(100, 110, 165, 25);
        ownerPanel.add(make);
        // Model
        carModel = new JLabel("Model of car");
        carModel.setBounds(10, 145, 80, 25);
        ownerPanel.add(carModel);

        model = new JTextField();
        model.setBounds(100, 145, 165, 25);
        ownerPanel.add(model);
        // Year
        carYear = new JLabel("Year made");
        carYear.setBounds(10, 180, 80, 25);
        ownerPanel.add(carYear);

        year = new JTextField();
        year.setBounds(100, 180, 165, 25);
        ownerPanel.add(year);

        // Location
        carLocation = new JLabel("Location of Manufacture");
        carLocation.setBounds(10, 215, 200, 25);
        ownerPanel.add(carLocation);

        location = new JTextField();
        location.setBounds(200, 215, 165, 25);
        ownerPanel.add(location);
        // Residency Time
        residencyTime = new JLabel("Residency Time of Vehicle");
        residencyTime.setBounds(10, 250, 200, 25);
        ownerPanel.add(residencyTime);

        Time = new JTextField();
        Time.setBounds(200, 250, 165, 25);
        ownerPanel.add(Time);

        // Cloud stuff acknowledge
        JLabel jobInfo = new JLabel("");
        jobInfo.setBounds(50, 290, 210, 250);
        cloudPanel.add(jobInfo);

        // Success message
        ownerSuccess = new JLabel("");
        ownerSuccess.setBounds(210, 250, 350, 250);
        ownerPanel.add(ownerSuccess);

        message = new JLabel("Please select what you are registering for.");
        message.setBounds(174, 121, 300, 25);
        panel.add(message);

        userBack = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                userFrame.dispose();
                frame.setVisible(true);
                success.setText("");
            }
        });

        userBack.setBounds(30, 250, 80, 25); // was set to 100 user back button
        userPanel.add(userBack);

        ownerBack = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                ownerFrame.dispose();
                frame.setVisible(true);
                System.out.println("it works");
                ownerSuccess.setText("");
            }
        });

        ownerBack.setBounds(30, 300, 80, 25);// owner back button
        ownerPanel.add(ownerBack);

        adminBack = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminFrame.dispose();
                frame.setVisible(true);
                adminSuccess.setText("");
            }
        });

        adminBack.setBounds(150, 250, 80, 25); // admin back button
        adminPanel.add(adminBack);

        cloudBack = new JButton(new AbstractAction("Back") {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (timeModel.getRowCount() > 0) {
                    timeModel.removeRow(0);
                    timeModel.fireTableDataChanged();
                }

                cloudFrame.dispose();
                jobInfo.setText("");
                adminFrame.setVisible(true);
            }

        });

        cloudBack.setBounds(125, 5, 80, 25); // cloud back button
        cloudPanel.add(cloudBack);

        jobField = new JTextField();
        jobField.setBounds(450,450,80,25);
        cloudPanel.add(jobField);

        carField = new JTextField();
        carField.setBounds(280,450,80,25);
        cloudPanel.add(carField);
 
        userJobLabel = new JLabel("Client Number");
        userJobLabel.setBounds(450,400,120,25);
        cloudPanel.add(userJobLabel);

        carLabel = new JLabel("Car Number");
        carLabel.setBounds(280,400,120,25);
        cloudPanel.add(carLabel);

        // Welcome info
        Fillout = new JLabel("Please fill out the following information");
        Fillout.setBounds(10, 5, 300, 25);
        userPanel.add(Fillout);

        userPanel.setLayout(null);
        userLabel = new JLabel("Client Name");
        userLabel.setBounds(10, 40, 80, 25); // was 10, 20, 80,25
        userPanel.add(userLabel);

        userPanel.setLayout(null);
        clientID = new JLabel("Client ID");
        clientID.setBounds(10, 75, 80, 25);
        userPanel.add(clientID);

        clientIDText = new JTextField();
        clientIDText.setBounds(100, 75, 165, 25);
        userPanel.add(clientIDText);

        ClientName = new JTextField();
        ClientName.setBounds(100, 40, 165, 25);
        userPanel.add(ClientName);

        userJobNum = new JLabel("Job Number");
        userJobNum.setBounds(10,180,80,25);
        userPanel.add(userJobNum);

        userJobField = new JTextField();
        userJobField.setBounds(100,180,80,25);
        userPanel.add(userJobField);
        // Adding Approximate Job Duration
        JobDuration = new JLabel("Job Duration");
        JobDuration.setBounds(10, 110, 100, 25);
        userPanel.add(JobDuration);

        // Adding Job Duration
        Hours = new JTextField();
        Hours.setBounds(100, 110, 80, 25);
        userPanel.add(Hours);

        // Adding Job Deadline
        Deadline = new JLabel("Job Deadline");
        Deadline.setBounds(10, 145, 80, 25);
        userPanel.add(Deadline);

        // Adding Date text field
        Date = new JTextField();
        Date.setBounds(100, 145, 165, 25);
        userPanel.add(Date);

        success = new JLabel("");
        success.setBounds(200, 200, 350, 250);
        userPanel.add(success);

        adminPanel.setLayout(null);
        adminUser = new JLabel("Username");
        adminUser.setBounds(150, 150, 125, 25);
        adminPanel.add(adminUser);

        adminUsername = new JTextField();
        adminUsername.setBounds(225, 150, 125, 25);
        adminPanel.add(adminUsername);

        adminPass = new JLabel("Password");
        adminPass.setBounds(150, 200, 125, 25);
        adminPanel.add(adminPass);

        adminPanel.setLayout(null);
        adminPassword = new JPasswordField();
        adminPassword.setBounds(225, 200, 125, 25);
        adminPanel.add(adminPassword);

        adminPrompt = new JLabel("Please enter your username and password.");
        adminPrompt.setBounds(10, 5, 400, 25);
        adminPanel.add(adminPrompt);

        adminPanel.setLayout(null);
        adminSuccess = new JLabel("");
        adminSuccess.setBounds(230, 275, 200, 25);
        adminPanel.add(adminSuccess);

        adminInfoButton = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {

                String adminName = adminUsername.getText();
                String adminPas = adminPassword.getText();
                String password = "test";

                if (adminName.length() > 0 && adminPas.length() > 0) {

                    if (adminPas.equals(password)) {
                        adminSuccess.setText("Successfully registered.");
                        adminFrame.dispose();
                        cloudFrame.setVisible(true);
                        amountOfJobs = Integer.parseInt(callServer("AdminJobSize"));
                        amountOfCars = Integer.parseInt(callServer("AdminCarSize"));
                        jobInfo.setText("p"+amountOfJobs);
                    }
                } else {
                    adminSuccess.setText("Username or password wrong.");
                }
                adminUsername.setText("");

                adminPassword.setText("");
            }
        });

        adminPanel.setLayout(null);
        adminInfoButton.setBounds(250, 250, 80, 25);
        adminPanel.add(adminInfoButton);

        userInfoButton = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
            	

                String time = Hours.getText();
                String dueDate = Date.getText();
                String name = ClientName.getText();
                String clientIDValue = clientIDText.getText();
                //String userNumber = userJobField.getText();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String dateTimer = (dtf.format(now));

                if (time.length() > 0 && dueDate.length() > 0 && name.length() > 0) {

                    
                 
                        try {
                            BufferedWriter test;
                            System.out.println("Start writing");
                            test = new BufferedWriter(new FileWriter(projectUrl + "ClientInfo.txt", true));
                            test.append("\n");
                            test.append("Name: " + name + "\n");
                            test.append("Client id: " + clientIDValue + "\n");

                            idValueCount = (int) (Math.random() * range) + min;
                            idList.add(idValueCount);
                            idValueCount = (int) (Math.random() * range) + min;
                            if (idList.contains(idValueCount)) {
                                previousID = idValueCount;

                                idValueCount = (int) (Math.random() * range) + min;
                                if (previousID != idValueCount) {
                                    test.append("Job ID: " + idValueCount + "\n");
                                }
                            } else {
                                test.append("Job ID: " + idValueCount + "\n");
                            }
                            test.append("Job Duration: " + time + "\n");
                            test.append("Job Deadline: " + dueDate + "\n");
                            test.append("Registration time: " + dateTimer + "\n");
                            test.close();
                            System.out.println("Written successfully");
                            success.setText("Registered successful at " + dateTimer);

                            listenServer = callServer("ClientRequest;" + name + ";" + idValueCount + ";" + time + ";" + dueDate);
                            sendToDatabase("INSERT INTO jobrequests"
                                    + "(clientID , name , jobDuration , jobDeadline , requestTime)" + "VALUES ("
                                    + idValueCount + ", '" + name + "', '" + time + "', '" + dueDate + "', '"
                                    + dateTimer + "')");
                        }

                        catch (IOException ex) {
                            ex.printStackTrace();
                        }

                        Hours.setText("");
                        Date.setText("");
                        ClientName.setText("");
                        clientIDText.setText("");
                        userJobField.setText("");

                    
                } else {
                    success.setText("Please fill out all fields.");
                }
            }
        });

        userInfoButton.setBounds(250, 250, 80, 25);
        userPanel.add(userInfoButton);

        ownerInfoButton = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {

                int min = 1000;
                int max = 9999;
                int i = (int) Math.floor(Math.random() * (max - min + 1) + min);
                String s = String.valueOf(i);
                String ownerName = name.getText();
                String carMake = make.getText();
                String carModel = model.getText();
                String carYear = year.getText();
                String carLocation = location.getText();
                String residencyTime = Time.getText();

                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now1 = LocalDateTime.now();
                String DateTimer1 = (dtf1.format(now1));

                if (ownerName.length() > 0 && carMake.length() > 0 && carModel.length() > 0 && carYear.length() > 0
                        && carLocation.length() > 0 && residencyTime.length() > 0) {
                    if (ownerName.length() > 0 && carMake.length() > 0 && carModel.length() > 0 && carYear.length() > 0
                            && carLocation.length() > 0 && residencyTime.length() > 0) {
                        
                            
                            
                                    try {
                                        BufferedWriter test;
                                        System.out.println("Buffered Writer start writing");
                                        test = new BufferedWriter(new FileWriter(projectUrl + "ClientInfo.txt", true));
                                        test.append("\n");
                                        test.append("Owner name: " + ownerName + "\n");
                                        test.append("Owner ID: " + s + "\n");
                                        test.append("Car Make: " + carMake + "\n");
                                        test.append("Car Model: " + carModel + "\n");
                                        test.append("Car Year: " + carYear + "\n");
                                        test.append("Manufactured Location: " + carLocation + "\n");
                                        test.append("Residency Time: " + residencyTime + "\n");
                                        test.append("Registered Successfully: " + DateTimer1 + "\n");
                                        test.close();
                                        System.out.println("Written successfully");

                                        callServer("OwnerCarRegister;" + ownerName + ";" + s + ";" + carMake
                                        + ";" + carModel +";" + carYear + " " + carLocation + ";" + residencyTime + ";"+ DateTimer1);
                                        name.setText("");
                                        make.setText("");
                                        model.setText("");
                                        year.setText("");
                                        location.setText("");
                                        Time.setText("");
                                        ownerSuccess.setText("Registered successful at " + DateTimer1);

                                        sendToDatabase("INSERT INTO cars"
                                                + "(carMake , carModel , carYear , carLocation , status ,  ownerName , ownerID)"
                                                + "VALUES ('" + carMake + "', '" + carModel + "', '" + carYear + "', '"
                                                + carLocation + "', 'available',  '" + ownerName + "', '" + s + "')");

                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }

                          

                                

                            

                    }

                    else {
                        ownerSuccess.setText("Please fill out all the fields.");
                    }
                }
            }
        });
        ownerInfoButton.setBounds(250, 300, 80, 25);
        ownerPanel.add(ownerInfoButton);
        accept = new JButton(new AbstractAction("Accept") {
            @Override
            public void actionPerformed(ActionEvent e)
            {

            }
            
        });
        
        acceptJobPortal = new JButton(new AbstractAction("Accept a Job") {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String jobIndex = jobField.getText();
                String carIndex = carField.getText();
                
                if(!isNumeric(jobIndex)||!isNumeric(carIndex)) {
                	jobInfo.setText("Input not a valid index");
                }else if((Integer.parseInt(jobIndex)>0)&&(Integer.parseInt(jobIndex)<=amountOfJobs)&&(Integer.parseInt(carIndex)>0)&&(Integer.parseInt(carIndex)<=amountOfCars)) {
                	jobInfo.setText("<html>"+callServer("AdminApprove;" + jobIndex + ";" + carIndex)+"</html>");
                }
                else jobInfo.setText("Inputted index too high");

            }

        });
        acceptJobPortal.setBounds(448, 355, 145, 25);
        cloudPanel.add(acceptJobPortal);

        denyJobPortal = new JButton(new AbstractAction("Deny a Job") {

            @Override
            public void actionPerformed(ActionEvent e) {
            	String jobIndex = jobField.getText();
            	if(!isNumeric(jobIndex)) {
                	jobInfo.setText("Input not a valid index");
                }else if((Integer.parseInt(jobIndex)>0)&&(Integer.parseInt(jobIndex)<=amountOfJobs)) {
                	jobInfo.setText("<html>"+callServer("AdminDeny;" + jobIndex)+"</html>");
                }
                else jobInfo.setText("Inputted index too high");
            }

        });
        denyJobPortal.setBounds(280, 355, 145, 25);
        cloudPanel.add(denyJobPortal);

        viewJobInfo = new JButton(new AbstractAction("View Job Info") {

            @Override
            public void actionPerformed(ActionEvent e) {
                String info = callServer("AdminHome");
                
                jobInfo.setText(info);
                
            }

        });

        viewJobInfo.setBounds(400, 5, 145, 25);
        cloudPanel.add(viewJobInfo);

        computeCompletionTime = new JButton(new AbstractAction("Completion time") {
            @Override
            public void actionPerformed(ActionEvent e) {

                File file = new File(projectUrl + "ClientInfo.txt");
                String data;
                integerData = 0;
                jobDurationList.clear();
                completionTime = 0;
                idValueCount = 0;
                idList.clear();
                totalDuration = 0;
                timeModel.setRowCount(0);
                timeModel.fireTableDataChanged();

                try {
                    Scanner sc = new Scanner(file);

                    while (sc.hasNextLine()) {
                        data = sc.nextLine();
                        if (data.indexOf("Duration") > 0) {

                            integerData = Integer.valueOf(data.substring(14, data.length()));
                            jobDurationList.add(integerData);
                            completionTime += integerData;

                        }
                    }
                    sc.close();
                } catch (FileNotFoundException x) {
                    x.printStackTrace();
                }
                try {
                    Scanner idScan = new Scanner(file);
                    while (idScan.hasNextLine()) {
                        idValue = idScan.nextLine();
                        if (idValue.indexOf("ID") > 0) {
                            idValueCount = Integer.valueOf(idValue.substring(11, idValue.length()));
                            idList.add(idValueCount);

                        }
                    }

                    for (int j = 0; j < idList.size(); j++) {
                        valueRow[0] = idList.get(j);
                        totalDuration += jobDurationList.get(j);
                        valueRow[1] = totalDuration;
                        timeModel.addRow(valueRow);

                    }
                    idScan.close();
                } catch (FileNotFoundException y) {
                    y.printStackTrace();
                }

            }

        });

        computeCompletionTime.setBounds(230, 5, 145, 25); // 250,350,80,25 , 250,350,150,25
        cloudPanel.add(computeCompletionTime);

        adminButton = new JButton(new AbstractAction("Cloud Controller") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                adminFrame.setVisible(true);
            }
        });

        panel.setLayout(null);
        adminButton.setBounds(206, 370, 175, 25);// (150,300,175,25) controller button
        panel.add(adminButton);

        userButton = new JButton(new AbstractAction("Client") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String notifications = callServer("ClientNotifications");
                success.setText(notifications);
                userFrame.setVisible(true);

            }
        });

        panel.setLayout(null);
        userButton.setBounds(194, 235, 80, 25); // ( 150,200,80,25) client button
        panel.add(userButton);

        ownerButton = new JButton(new AbstractAction("Owner") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ownerFrame.setVisible(true);
            }
        });

        ownerButton.setBounds(314, 235, 80, 25); // (250,200,80,25) owner button
        panel.add(ownerButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

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

    private static String callServer(String serverInput) {
        String serverResponse = "Could not connect to Server";

        try {
            outputStream.writeUTF(serverInput);

            try {
                serverResponse = inputStream.readUTF();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return serverResponse;
    }

    private static void makeRadiolist(String info, String emptyStatement, JFrame frame) {

        String[] infoArray = info.split("<br/>");
        radioList = new JRadioButton[infoArray.length];
        if (infoArray[0] != emptyStatement) {
            for (int i = 0; i < infoArray.length; i++) {
                radioList[i] = new JRadioButton(infoArray[i]);
                radioList[i].setBounds(20, 40 + (i * 40), 100, 40);
                frame.add(radioList[i]);
            }
        } else
            frame.add(new JLabel(emptyStatement));
    }
    
    public static boolean isNumeric(String str) { 
    	  try {  
    	    Double.parseDouble(str);  
    	    return true;
    	  } catch(NumberFormatException e){  
    	    return false;  
    	  }  
    	}
}