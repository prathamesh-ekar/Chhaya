package chhaya;
import chhaya.Main;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;
public class LogReg extends JFrame
{
    private JPanel p1;
    JLabel adminLabel, adminpassLabel,imglabel1; 
    JTextField adminText;
    JPasswordField adminpassText;
    JButton adminloginButton;
    JComboBox cb;
    public LogReg()
    {
        setTitle("Welcome to Chhaya v.0.1.");
        setSize(300,270);
        setLocationRelativeTo(null);
        setBackground(Color.gray);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        p1= new JPanel();
        p1.setLayout(null);
        adminLabel = new JLabel("Admin ID:");
        adminLabel.setBounds(10, 10, 80, 25);
        p1.add(adminLabel);
        adminText = new JTextField(20);
        adminText.setBounds(100, 10, 160, 25);
        p1.add(adminText);
        adminpassLabel = new JLabel("Password:");
        adminpassLabel.setBounds(10, 40, 80, 25);
        p1.add(adminpassLabel);
        adminpassText = new JPasswordField(20);
        adminpassText.setBounds(100, 40, 160, 25);
        p1.add(adminpassText);
	adminloginButton = new JButton("Login");
	adminloginButton.setBounds(100, 80, 80, 25);
        adminloginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0) 
            {
                if(adminText.getText().equals("admin")&& adminpassText.getText().equals("123"))
                {
                   JOptionPane.showMessageDialog(null, "Welcome to Chhaya!", "", JOptionPane.INFORMATION_MESSAGE);
                   Main Mainframe = new Main();
                   Mainframe.setVisible(true);
                   dispose();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid keyword!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
                /*Connection con = null;
                try
                {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    con = DriverManager.getConnection("jdbc:sqlserver://LENOVO-PC:1443;databaseName=chhaya");                  
                }
                catch(ClassNotFoundException e)
                {
	    		System.err.println("Failed to Load Driver");
	    		e.printStackTrace();
	    	}
                catch (SQLException e)
                {
	    		System.err.println("Unable to Connect");
	    		e.printStackTrace();
                }    		
				try {				
					Statement statement = con.createStatement();
					String qry = "SELECT * FROM login WHERE username = '" + adminText.getText()
							+ "' AND password = '" + String.valueOf(adminpassText.getPassword()) + "' ";					
					ResultSet rs = statement.executeQuery(qry);
					int count = 0;
					while (rs.next()) {
						count++;
						//or count = count + 1;
					}
					statement.close();				
					if (count > 0) {
						JOptionPane.showMessageDialog(null, "Welcome to Chhaya!", "", JOptionPane.INFORMATION_MESSAGE);
						
						Main Mainframe = new Main();
						Mainframe.setVisible(true);
						
						dispose();
					} else if (count == 0) 
                                        {
						JOptionPane.showMessageDialog(null, "Invalid keyword!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}*/
            }});
	p1.add(adminloginButton);
        imglabel1 = new JLabel();
        imglabel1.setIcon(new ImageIcon("D:/pratham/Chhaya/src/chhaya/Old School Photography FB Cover-710661.jpg"));
        imglabel1.setBounds(0, 120,300, 110);
        p1.add(imglabel1);
        add(p1);
    }
}
