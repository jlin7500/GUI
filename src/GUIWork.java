import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

/* Project: GUI Incomplete
   Class: GUIWork.java
   Author: Jonathan Lin
   Date: September 27,2022
   This program currently allows a user to login with their username and password, it also tells the date and time they logged in.
*/
public class GUIWork implements ActionListener
{
    //variables so we can use them later, some may be unused for now.
    private static JLabel userLabel;
    private static JTextField userText;
    private static JTextField ownerText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel title;

    public static void main(String[] args)
    {
        //creating the frame, setting its size and making it visible.
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //creates a panel and adds it to the frame.
        JPanel panel = new JPanel();
        frame.add(panel);

        //creates a new label for "User" and adds it to the panel
        panel.setLayout(null);
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        //adds text for the owner to type in
        ownerText = new JTextField();
        ownerText.setBounds(100,50,165,25);
        panel.add(ownerText);

        //creates a new label for "Owner" and adds it to the panel
        JLabel ownerLabel = new JLabel("Owner");
        ownerLabel.setBounds(10,50,80,25);
        panel.add(ownerLabel);

        //adds text for the user to type in
        userText = new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        //adds a password label
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,80,80,25);
        panel.add(passwordLabel);

        //adds a password to type in
        passwordText = new JPasswordField();
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        //creates the login button
        JButton button = new JButton("Login");
        button.setBounds(10,120,70,25);
        button.addActionListener(new GUIWork());
        panel.add(button);

        //text for login either success/failure message and sets it visible
        success = new JLabel("");
        success.setBounds(10,150,300,25);
        panel.add(success);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //a date and time formatter for when the user logs in
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));

        //gets the text from the variable
        String owner = ownerText.getText();
        String user = userText.getText();
        String userPassword = passwordText.getText();
        System.out.println(user + ", " + userPassword);

        //tests if the user and password(case-sensitive) are correct and that there is nothing in the owner section
        if(user.equalsIgnoreCase("Jonathan") && userPassword.equals("Test") && (owner.length() == 0))
        {
            success.setText("Login successful at " + DateTimer);
        }
        //attempting to log into multiple accounts
        else if(user.length() != 0 && owner.length() != 0)
        {
            success.setText("You are attempting to log in on multiple accounts.");
        }
        //wrong password/user
        else
        {
            success.setText("Wrong username or password, please try again.");
        }

    }
}
