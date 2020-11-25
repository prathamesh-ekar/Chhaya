package chhaya;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
class ViewCustomer extends JFrame
{
    JLabel fn, ln, addr1, addr2,city,state_,pcode, phone,cust_id;
    JTextField customerid, firstname,lastname,address1,address2,citytxt,statetxt,pincode,phoneno;
    JButton search, reset, update, delete;
    ViewCustomer()
    {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setTitle("Customer Info");
        cust_id=new JLabel("Customer ID:");
        fn = new JLabel("First Name::");
        ln = new JLabel("Last Name:");
        addr1 = new JLabel("Address Line 1:");
        addr2 = new JLabel("Address Line 2:");
        city = new JLabel("City:");
        state_ = new JLabel("State:");
        pcode = new JLabel("Pincode:");
        phone = new JLabel("Phone No:"); 
        customerid=new JTextField();
        firstname = new JTextField();
        lastname = new JTextField();
        address1 = new JTextField();
        address2 = new JTextField();
        citytxt = new JTextField();
        statetxt = new JTextField();
        pincode = new JTextField();
        phoneno = new JTextField();
        search = new JButton("Search Record");
        reset = new JButton("Reset");
        update = new JButton("Update Record.");
        search.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
        Class.forName("com.mysql.jdbc.Driver");
         Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from customer where c_id="+customerid.getText());
        while(rs.next())
        {
            firstname.setText(rs.getString(2));
            lastname.setText(rs.getString(3));
            address1.setText(rs.getString(4));
            address2.setText(rs.getString(5));
            citytxt.setText(rs.getString(6));
            statetxt.setText(rs.getString(7));
            pincode.setText(rs.getString(8));
            phoneno.setText(rs.getString(9));
           
        }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
                    }                     
                }
        );
        reset.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                firstname.setEditable(true);
            lastname.setEditable(true);
            address1.setEditable(true);
            address2.setEditable(true);
            citytxt.setEditable(true);
            statetxt.setEditable(true);
            pincode.setEditable(true);
            phoneno.setEditable(true);
            firstname.setText(null);
            lastname.setText(null);
            address1.setText(null);
            address2.setText(null);
            citytxt.setText(null);
            statetxt.setText(null);
            pincode.setText(null);
            phoneno.setText(null);
            }
        });
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ShowAllCustomers mainFrame=new ShowAllCustomers();
                 mainFrame.setVisible(true);
        }});
        cust_id.setBounds(80,10,200,30);
        fn.setBounds(80, 50, 200, 30);
        ln.setBounds(80, 90, 200, 30);
        addr1.setBounds(80, 130, 200, 30);
        addr2.setBounds(80, 170, 200, 30);
        city.setBounds(80, 210, 200, 30);
        state_.setBounds(80, 250, 200, 30);
        pcode.setBounds(80, 290, 200, 30);
        phone.setBounds(80, 330, 200, 30);
        customerid.setBounds(300,10,200,30);
        firstname.setBounds(300, 50, 200, 30);
        lastname.setBounds(300, 90, 200, 30);
        address1.setBounds(300, 130, 200, 30);
        address2.setBounds(300, 170, 200, 30);
        citytxt.setBounds(300, 210, 200, 30);
        statetxt.setBounds(300, 250, 200, 30);
        pincode.setBounds(300, 290, 200, 30);
        phoneno.setBounds(300, 330, 200, 30);
        search.setBounds(80, 380, 150, 30);
        reset.setBounds(245, 380, 150, 30);
        update.setBounds(410, 380, 200, 30);
        add(cust_id);
        add(fn);
        add(ln);
        add(addr1);
        add(addr2);
        add(city);
        add(state_);
        add(pcode);
        add(phone);
        add(customerid);
        add(firstname);
        add(lastname);
        add(address1);
        add(address2);
        add(citytxt);
        add(statetxt);
        add(pincode);
        add(phoneno);
        add(search);
        add(reset);
        add(update);
        setVisible(true);
    }
}