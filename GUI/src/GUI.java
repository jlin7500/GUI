import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener
{
    JLabel label;
    JFrame frame;
    JPanel panel;
    int count = 0;
    public GUI()
    {
        frame = new JFrame();

        JButton button = new JButton("Click me");
        button.addActionListener(this);


        label = new JLabel("Number of click: 0");

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUI");
        frame.pack();
        frame.setVisible(true);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        count++;
        label.setText("Number of click: " + count);
    }
}
