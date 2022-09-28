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
    private static JLabel userLabel;
    //private static JLabel ownerLabel;
    private static JTextField userText;
    private static JTextField ownerText;
    private static JLabel passwordLabel;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private static JLabel title;

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        frame.add(panel);


        panel.setLayout(null);
        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        ownerText = new JTextField();
        ownerText.setBounds(100,50,165,25);
        panel.add(ownerText);

        JLabel ownerLabel = new JLabel("Owner");
        ownerLabel.setBounds(10,50,80,25);
        panel.add(ownerLabel);

        userText = new JTextField();
        userText.setBounds(100,20,165,25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10,80,80,25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 80, 165, 25);
        panel.add(passwordText);

        JButton button = new JButton("Login");
        button.setBounds(10,120,70,25);
        button.addActionListener(new GUIWork());
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10,150,300,25);
        panel.add(success);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String DateTimer = (dtf.format(now));

        String owner = ownerText.getText();

        String user = userText.getText();
        String userPassword = passwordText.getText();
        System.out.println(user + ", " + userPassword);

        if(user.equalsIgnoreCase("Jonathan") && userPassword.equals("Test") && (owner.length() == 0))
        {
            success.setText("Login successful at " + DateTimer);
        }
        else if(user.length() != 0 && owner.length() != 0)
        {
            success.setText("You are attempting to log in on multiple accounts.");
        }
        else
        {
            success.setText("Wrong username or password, please try again.");
        }

    }
}
