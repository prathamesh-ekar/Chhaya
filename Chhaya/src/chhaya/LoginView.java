package chhaya;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView 
{
    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Chhaya v.0.1.");
	frame.setSize(300, 270);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	JPanel panel = new JPanel();
	frame.add(panel);
	placeComponents(panel);

	frame.setVisible(true);
    }
    private static void placeComponents(JPanel panel)
    {
        panel.setLayout(null);

	JLabel userLabel = new JLabel("Username:");
	userLabel.setBounds(10, 10, 80, 25);
	panel.add(userLabel);

	JTextField userText = new JTextField(20);
	userText.setBounds(100, 10, 160, 25);
	panel.add(userText);

	JLabel passwordLabel = new JLabel("Password:");
	passwordLabel.setBounds(10, 40, 80, 25);
	panel.add(passwordLabel);

	JPasswordField passwordText = new JPasswordField(20);
	passwordText.setBounds(100, 40, 160, 25);
	panel.add(passwordText);

	JButton loginButton = new JButton("Login");
	loginButton.setBounds(10, 80, 80, 25);
	panel.add(loginButton);
		
	JButton registerButton = new JButton("Add new user");
	registerButton.setBounds(130, 80, 150, 25);
	panel.add(registerButton);
        
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("D:/pratham/Chhaya/src/Old School Photography FB Cover-710661.jpg"));
        label.setBounds(0, 120,300, 110);
        panel.add(label);
    }
}