import java.io.*;
import java.sql.ClientInfoStatus;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class GUIWork implements ActionListener 
{
    static int integerData = 0;
    static int completionTime;
    private static JLabel userLabel;
    private static JLabel ownerLabel;
    private static JTextField userText;
    private static JTextField ownerText;

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

    //Cloud controller
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

    //Cloud controller commands
    private static JButton computeCompletionTime;
    private static JButton cloudBack;

    // Client
    private static JLabel Fillout;
    private static JLabel ClientID;
    private static JTextField ID;
    private static JLabel JobDuration;
    private static JTextField Hours;
    private static JLabel Deadline;
    private static JTextField Date;
    private static JButton SubButton;
    private static JLabel Received;
    private static JTextField ClientName;
    private static JButton clientClear;


    // Owner
    private static JLabel welcomeMessage;
    private static JLabel ownerName;
    private static JTextField name;
    private static JLabel ownerID;
    private static JTextField id;
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

    public static void main(String[] args) 
    {
        
        JFrame userFrame = new JFrame("Welcome Client !"); // client title section
        userFrame.setSize(500, 500);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setVisible(false);

        JFrame ownerFrame = new JFrame("Welcome Owner !"); // owner title section
        ownerFrame.setSize(500, 500);
        ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ownerFrame.setVisible(false);

        JFrame frame = new JFrame("Vehicular GUI"); // Home GUI title
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JFrame adminFrame = new JFrame("Cloud Controller");
        adminFrame.setSize(500,500);
        adminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminFrame.setVisible(false);

        JFrame cloudFrame = new JFrame("Vehicle Controller Functions");
        cloudFrame.setSize(500,500);
        cloudFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cloudFrame.setVisible(false);

        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setSize(500, 500);
        frame.add(panel);

        JPanel userPanel = new JPanel();
        userFrame.add(userPanel);
        userPanel.setBackground(Color.LIGHT_GRAY);

        JPanel adminPanel = new JPanel();
        adminFrame.add(adminPanel);
        adminPanel.setBackground(Color.lightGray);

        JPanel ownerPanel = new JPanel();
        ownerFrame.add(ownerPanel);
        ownerPanel.setBackground(Color.LIGHT_GRAY);

        JPanel cloudPanel = new JPanel();
        cloudFrame.add(cloudPanel);
        cloudPanel.setBackground(Color.lightGray);


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
        // Owner ID
        ownerID = new JLabel("Owner ID");
        ownerID.setBounds(10, 75, 80, 25);
        ownerPanel.add(ownerID);

        id = new JTextField();
        id.setBounds(100, 75, 165, 25);
        ownerPanel.add(id);
        // Vehicle Information
        vehicleInfo = new JLabel("Vehicle Information:");
        vehicleInfo.setBounds(10, 110, 150, 25);
        ownerPanel.add(vehicleInfo);
        // Make
        carMake = new JLabel("Make of Car");
        carMake.setBounds(10, 145, 80, 25);
        ownerPanel.add(carMake);

        make = new JTextField();
        make.setBounds(100, 145, 165, 25);
        ownerPanel.add(make);
        // Model
        carModel = new JLabel("Model of car");
        carModel.setBounds(10, 180, 80, 25);
        ownerPanel.add(carModel);

        model = new JTextField();
        model.setBounds(100, 180, 165, 25);
        ownerPanel.add(model);
        // Year
        carYear = new JLabel("Year made");
        carYear.setBounds(10, 215, 80, 25);
        ownerPanel.add(carYear);

        year = new JTextField();
        year.setBounds(100, 215, 165, 25);
        ownerPanel.add(year);

        // Location
        carLocation = new JLabel("Location of Manufacture");
        carLocation.setBounds(10, 250, 200, 25);
        ownerPanel.add(carLocation);

        location = new JTextField();
        location.setBounds(200, 250, 165, 25);
        ownerPanel.add(location);
        // Residency Time
        residencyTime = new JLabel("Residency Time of Vehicle");
        residencyTime.setBounds(10, 285, 200, 25);
        ownerPanel.add(residencyTime);

        Time = new JTextField();
        Time.setBounds(200, 285, 165, 25);
        ownerPanel.add(Time);

        // Success message
        ownerSuccess = new JLabel("");
        ownerSuccess.setBounds(210, 270, 350, 250);
        ownerPanel.add(ownerSuccess);

        message = new JLabel("Please select what you are registering for.");
        message.setBounds(130, 150, 300, 25);
        panel.add(message);

        userBack = new JButton(new AbstractAction("Back") 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                userFrame.dispose();
                frame.setVisible(true);
            }
        });

        userBack.setBounds(30, 200, 80, 25); // was set to 100
        userPanel.add(userBack);

        ownerBack = new JButton(new AbstractAction("Back") 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                ownerFrame.dispose();
                frame.setVisible(true);
                System.out.println("it works");
            }
        });


        ownerBack.setBounds(30, 350, 80, 25);
        ownerPanel.add(ownerBack);

        adminBack = new JButton(new AbstractAction("Back") 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                adminFrame.dispose();
                frame.setVisible(true);
            }
        });
        
        adminBack.setBounds(150,250,80,25);
        adminPanel.add(adminBack);

        cloudBack = new JButton(new AbstractAction("Back") 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                cloudFrame.dispose();
                adminFrame.setVisible(true);
            }
        });

        cloudBack.setBounds(150,250,80,25);
        cloudPanel.add(cloudBack);
        // Welcome info
        Fillout = new JLabel("Please fill out the following information");
        Fillout.setBounds(10, 5, 300, 25);
        userPanel.add(Fillout);

        userPanel.setLayout(null);
        userLabel = new JLabel("Client Name");
        userLabel.setBounds(10, 40, 80, 25); // was 10, 20, 80,25
        userPanel.add(userLabel);

        ClientName = new JTextField();
        ClientName.setBounds(100, 40, 165, 25);
        userPanel.add(ClientName);

        // Adding Client ID
        ClientID = new JLabel("Client ID");
        ClientID.setBounds(10, 80, 80, 25);
        userPanel.add(ClientID);

        // Adding Client ID Text field
        ID = new JTextField();
        ID.setBounds(100, 80, 165, 25);
        userPanel.add(ID);

        // Adding Approximate Job Duration
        JobDuration = new JLabel("Job Duration");
        JobDuration.setBounds(10, 120, 100, 25);
        userPanel.add(JobDuration);

        // Adding Job Duration
        Hours = new JTextField();
        Hours.setBounds(100, 120, 80, 25);
        userPanel.add(Hours);

        // Adding Job Deadline
        Deadline = new JLabel("Job Deadline");
        Deadline.setBounds(10, 160, 80, 25);
        userPanel.add(Deadline);

        // Adding Date text field
        Date = new JTextField();
        Date.setBounds(100, 160, 165, 25);
        userPanel.add(Date);

        success = new JLabel("");
        success.setBounds(200, 110, 350, 250);
        userPanel.add(success);

        adminPanel.setLayout(null);
        adminUser = new JLabel("Username");
        adminUser.setBounds(150,150,125,25);
        adminPanel.add(adminUser);

        adminUsername = new JTextField();
        adminUsername.setBounds(225,150,125,25);
        adminPanel.add(adminUsername);

        adminPass = new JLabel("Password");
        adminPass.setBounds(150,200,125,25);
        adminPanel.add(adminPass);

        adminPanel.setLayout(null);
        adminPassword = new JPasswordField();
        adminPassword.setBounds(225,200,125,25);
        adminPanel.add(adminPassword);


        adminPrompt = new JLabel("Please enter your username and password.");
        adminPrompt.setBounds(10,5,400,25);
        adminPanel.add(adminPrompt);

        adminPanel.setLayout(null);
        adminSuccess = new JLabel("");
        adminSuccess.setBounds(230,275,200,25);
        adminPanel.add(adminSuccess);


        adminInfoButton = new JButton(new AbstractAction("Submit")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {

                String adminName = adminUsername.getText();
                String adminPas = adminPassword.getText();
                String password = "test";

                if(adminName.length() > 0 && adminPas.length() > 0)
                {

                    if(adminPas.equals(password))
                    {
                        adminSuccess.setText("Successfully registered.");
                        adminFrame.dispose();
                        cloudFrame.setVisible(true);
                    }
                }
                else
                {
                    adminSuccess.setText("Username or password wrong.");
                }

                adminUsername.setText("");

                adminPassword.setText("");


            }
        });

        adminPanel.setLayout(null);
        adminInfoButton.setBounds(250,250,80,25);
        adminPanel.add(adminInfoButton);

        userInfoButton = new JButton(new AbstractAction("Submit") 
        {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String client = ID.getText();
                String time = Hours.getText();
                String dueDate = Date.getText();
                String name = ClientName.getText();

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String DateTimer = (dtf.format(now));

                if (client.length() > 0 && time.length() > 0 && dueDate.length() > 0 && name.length() > 0)
                {

                    success.setText("Login successful at " + DateTimer);

                    try
                    {
                        BufferedWriter test;
                        System.out.println("Start writing");
                        test = new BufferedWriter(new FileWriter("ClientInfo.txt", true));
                        test.append("\n");
                        test.append("Name: " + name + "\n");
                        test.append("Client ID: " + client + "\n");
                        test.append("Job Duration: " + time + "\n");
                        test.append("Job Deadline: " + dueDate + "\n");
                        test.append("Registration time: " + DateTimer + "\n");
                        test.close();
                        System.out.println("Written successfully");
                    } 
                    
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                    
                    ID.setText("");
                    Hours.setText("");
                    Date.setText("");
                    ClientName.setText("");
                } 
                else 
                {
                    success.setText("Please fill out all fields.");
                }
            }
        });

        userInfoButton.setBounds(250, 200, 80, 25);
        userPanel.add(userInfoButton);

        ownerInfoButton = new JButton(new AbstractAction("Submit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ownerName = name.getText();
                String ownerID = id.getText();
                String carMake = make.getText();
                String carModel = model.getText();
                String carYear = year.getText();
                String carLocation = location.getText();
                String residencyTime = Time.getText();

                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now1 = LocalDateTime.now();
                String DateTimer1 = (dtf1.format(now1));

                if (ownerName.length() > 0 && ownerID.length() > 0 && carMake.length() > 0 && carModel.length() > 0 &&
                        carYear.length() > 0 && carLocation.length() > 0 && residencyTime.length() > 0)
                {
                    ownerSuccess.setText("Successfully registered. " + DateTimer1);
                    try
                    {
                        BufferedWriter test;
                        System.out.println("Buffered Writer start writing");
                        test = new BufferedWriter(new FileWriter("OwnerInfo.txt", true));
                        test.append("\n");
                        test.append("Owner name: " + ownerName + "\n");
                        test.append("Owner ID: " + ownerID + "\n");
                        test.append("Car Make: " + carMake + "\n");
                        test.append("Car Model: " + carModel + "\n");
                        test.append("Car Year: " + carYear + "\n");
                        test.append("Manufactured Location: " + carLocation + "\n");
                        test.append("Residency Time: " + residencyTime + "\n");
                        test.append("Registered Successfully: "  + DateTimer1 +  "\n");
                        test.close();
                        System.out.println("Written successfully");
                    } catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }

                    name.setText("");
                    id.setText("");
                    make.setText("");
                    model.setText("");
                    year.setText("");
                    location.setText("");
                    Time.setText("");
                }
                        else
                        {
                            ownerSuccess.setText("Please fill out all the fields.");
                        }
            }
        });
        ownerInfoButton.setBounds(250, 350, 80, 25);
        ownerPanel.add(ownerInfoButton);

        
        computeCompletionTime = new JButton(new AbstractAction("Completion time") 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                File file = new File("C:\\Users\\Jonat\\IdeaProjects\\GUIWork\\ClientInfo.txt");
                String data;
                try
                {
                  Scanner sc = new Scanner(file);
          
                  while(sc.hasNextLine())
                  {
                    data = sc.nextLine();
                    if(data.indexOf("Duration") > 0)
                    {
                    
                    System.out.println(data);

                    System.out.println(data.substring(14, data.length()));

                    integerData = Integer.valueOf(data.substring(14, data.length()));
                      
                    completionTime += integerData;

                    }
                  }
                  sc.close();
                  System.out.println(completionTime);
                }
                catch (FileNotFoundException x)
                {
                  x.printStackTrace();
                }
            }
        });
        
        computeCompletionTime.setBounds(250,350,80,25);
        cloudPanel.add(computeCompletionTime);

        adminButton = new JButton(new AbstractAction("Cloud Controller")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                adminFrame.setVisible(true);
            }
        });

        panel.setLayout(null);
        adminButton.setBounds(177,240,125,25);
        panel.add(adminButton);

        userButton = new JButton(new AbstractAction("Client") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                userFrame.setVisible(true);

            }
        });

        panel.setLayout(null);
        userButton.setBounds(150, 200, 80, 25);
        panel.add(userButton);

        ownerButton = new JButton(new AbstractAction("Owner") {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                ownerFrame.setVisible(true);
            }
        });

        ownerButton.setBounds(250, 200, 80, 25);
        panel.add(ownerButton);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
