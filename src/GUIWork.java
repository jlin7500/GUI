import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class GUIWork implements ActionListener
{
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

    //Client
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

    //Owner
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
    long time = System.currentTimeMillis();


    public static void main(String[] args)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));

        JFrame userFrame = new JFrame("Welcome Client !");//client title section
        userFrame.setSize(600,600);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setVisible(false);

        JFrame ownerFrame = new JFrame("Welcome Owner !");//owner title section
        ownerFrame.setSize(600,600);
        ownerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setVisible(false);

        JFrame frame = new JFrame("Vehicular GUI");// Home GUI title
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);

        JPanel userPanel = new JPanel();
        userFrame.add(userPanel);

        JPanel ownerPanel = new JPanel();
        ownerFrame.add(ownerPanel);

        ownerPanel.setLayout(null);
        //Welcome message
        welcomeMessage = new JLabel ("Please fill out the following information");
        welcomeMessage.setBounds(10, 5, 300, 25);
        ownerPanel.add(welcomeMessage);
        //Owner name
        ownerName = new JLabel("Owner Name");
        ownerName.setBounds(10,40,80,25);
        ownerPanel.add(ownerName);

        name = new JTextField();
        name.setBounds(100,40,165,25);
        ownerPanel.add(name);
        //Owner ID
        ownerID = new JLabel("Owner ID");
        ownerID.setBounds(10,75,80,25);
        ownerPanel.add(ownerID);

        id = new JTextField();
        id.setBounds(100,75,165,25);
        ownerPanel.add(id);
        //Vehicle Information
        vehicleInfo = new JLabel("Vehicle Information:");
        vehicleInfo.setBounds(10,110,150,25);
        ownerPanel.add(vehicleInfo);
        //Make
        carMake = new JLabel("Make of Car");
        carMake.setBounds(10,145,80,25);
        ownerPanel.add(carMake);

        make = new JTextField();
        make.setBounds(100,145,165,25);
        ownerPanel.add(make);
        //Model
        carModel = new JLabel("Model of car");
        carModel.setBounds(10,180,80,25);
        ownerPanel.add(carModel);

        model = new JTextField();
        model.setBounds(100,180,165,25);
        ownerPanel.add(model);
        //Year
        carYear = new JLabel("Year made");
        carYear.setBounds(10,215,80,25);
        ownerPanel.add(carYear);

        year = new JTextField();
        year.setBounds(100,215,165,25);
        ownerPanel.add(year);
        //Location
        carLocation = new JLabel("Location of Manufacture");
        carLocation.setBounds(10,250,200,25);
        ownerPanel.add(carLocation);

        location = new JTextField();
        location.setBounds(200,250,165,25);
        ownerPanel.add(location);
        //Residency Time
        residencyTime = new JLabel("Residency Time of Vehicle");
        residencyTime.setBounds(10,285,200,25);
        ownerPanel.add(residencyTime);

        Time = new JTextField();
        Time.setBounds(200,285,165,25);
        ownerPanel.add(Time);

        //Sucess message
        ownerSuccess = new JLabel("");
        ownerSuccess.setBounds(250,270,250,250);
        ownerPanel.add(ownerSuccess);

        userBack = new JButton(new AbstractAction("Back")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                userFrame.dispose();
                frame.setVisible(true);
            }
        });

        userBack.setBounds(30,200,80,25); // was set to 100
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

        ownerBack.setBounds(30,350,80,25);
        ownerPanel.add(ownerBack);

        //Welcome info
        Fillout = new JLabel ("Please fill out the following information");
        Fillout.setBounds(10, 5, 300, 25);
        userPanel.add(Fillout);

        userPanel.setLayout(null);
        userLabel = new JLabel("Client Name");
        userLabel.setBounds(10, 40, 80, 25);// was 10, 20, 80,25
        userPanel.add(userLabel);

        ClientName = new JTextField();
        ClientName.setBounds(100,40,165,25);
        userPanel.add(ClientName);

        // Adding Client ID
        ClientID = new JLabel("Client ID");
        ClientID.setBounds(10, 80, 80, 25);
        userPanel.add(ClientID);

        //Adding Client ID Text field
        ID = new JTextField();
        ID.setBounds(100, 80, 165, 25);
        userPanel.add(ID);

        //Adding Approximate Job Duration
        JobDuration = new JLabel("Job Duration");
        JobDuration.setBounds(10, 120, 100, 25);
        userPanel.add(JobDuration);

        //Adding Job Duration
        Hours = new JTextField();
        Hours.setBounds(100, 120, 80, 25);
        userPanel.add(Hours);

        //Adding Job Deadline
        Deadline = new JLabel("Job Deadline");
        Deadline.setBounds(10, 160, 80, 25);
        userPanel.add(Deadline);

        //Adding Date text field
        Date = new JTextField();
        Date.setBounds(100, 160, 165, 25);
        userPanel.add(Date);

        success = new JLabel("");
        success.setBounds(200,110,250,250);
        userPanel.add(success);

        userInfoButton = new JButton(new AbstractAction("Submit")
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String client = ID.getText();
                String time = Hours.getText();
                String dueDate = Date.getText();
                String name = ClientName.getText();
                if(client.length() > 0 && time.length() > 0 && dueDate.length() > 0 && name.length() > 0)
                {
                    success.setText("Login successful at " + DateTimer);
                    try
                    {
                        BufferedWriter test;
                        System.out.println("Buffered Writer start writing");
                        test = new BufferedWriter(new FileWriter("ClientInfo.txt",true));
                        test.append(name);
                        test.append(", ");
                        test.append(client);
                        test.append(", ");
                        test.append(time + " ");
                        test.append(" " + DateTimer  + "\n");
                        test.close();
                        System.out.println("Written successfully");
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });

        userInfoButton.setBounds(250,200,80,25);
        userPanel.add(userInfoButton);

        ownerInfoButton = new JButton(new AbstractAction("Submit")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String ownerName = name.getText();
                String ownerID = id.getText();
                String carMake = make.getText();
                String carModel = model.getText();
                String carYear = year.getText();
                String carLocation = location.getText();
                String residencyTime = Time.getText();
                if(ownerName.length() > 0 && ownerID.length() > 0 && carMake.length() > 0 && carModel.length() > 0 && carYear.length() > 0 && carLocation.length() > 0 && residencyTime.length() > 0)
                {
                    ownerSuccess.setText("Login successful at " + DateTimer);
                    try
                    {
                        BufferedWriter test;
                        System.out.println("Buffered Writer start writing");
                        test = new BufferedWriter(new FileWriter("OwnerInfo.txt",true));
                        test.append(ownerName);
                        test.append(", ");
                        test.append(ownerID);
                        test.append(", ");
                        test.append(carMake);
                        test.append(", ");
                        test.append(carModel);
                        test.append(", ");
                        test.append(carYear);
                        test.append(", ");
                        test.append(carLocation);
                        test.append(", ");
                        test.append(residencyTime + " ");
                        test.append(" " + DateTimer  + "\n");
                        test.close();
                        System.out.println("Written successfully");
                    }
                    catch (IOException ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        ownerInfoButton.setBounds(250,350,80,25);
        ownerPanel.add(ownerInfoButton);
        userButton = new JButton(new AbstractAction("Client")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                userFrame.setVisible(true);

            }
        });

        userButton.setBounds(10,80,80,25);
        panel.add(userButton);



        ownerButton = new JButton(new AbstractAction("Owner")
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                ownerFrame.setVisible(true);
            }
        });

        ownerButton.setBounds(100,80,80,25);
        panel.add(ownerButton);



        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        String newUser = userText.getText();
        String newPassword = passwordText.getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));

        String user = userText.getText();
        String password = passwordText.getText();

        /*
        if (user.equalsIgnoreCase("Jonathan") && password.equals("Testt"))
        {
            success.setText("Login successful at " + DateTimer);
            title.setText("Owner");
            //writeToFile("newFileY", newUser, newPassword);
            try
            {
                tester = new FileWriter("TEST.txt");
                BufferedWriter test = new BufferedWriter(tester);
                System.out.println("Buffered Writer start writing :)");
                test.write(user);
                test.write(",");
                test.write(password);
                test.close();
                System.out.println("Written successfully");
            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
            */

        if(user.length() > 0 && password.length() > 0)
        {
            success.setText("Login successful at " + DateTimer);
            try
            {
                BufferedWriter test;
                System.out.println("Buffered Writer start writing :)");
                test = new BufferedWriter(new FileWriter("UserInfo.txt",true));
                test.append(user);
                test.append(",");
                test.append(password);
                test.append(DateTimer  + "\n");
                test.close();
                System.out.println("Written successfully");
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        else
        {
            success.setText("Wrong username or password, please try again.");
        }
    }
}