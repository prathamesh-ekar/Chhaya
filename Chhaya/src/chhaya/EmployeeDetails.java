/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chhaya;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
class EmployeeDetails extends JFrame
{
    JLabel fn, ln, desgn, addr,city,state_,pcode, phone,emp_id;
    JTextField employeeid, firstname,lastname,designation,address,citytxt,statetxt,pincode,phoneno;
    JButton submit, clear, update, search;
    EmployeeDetails()
     {
         setSize(700, 500);
         setLayout(null);
         setResizable(false);
         setLocationRelativeTo(null);
         setTitle("Employee Registration Form.");
         emp_id=new JLabel("Employee ID:");
        fn = new JLabel("First Name::");
        ln = new JLabel("Last Name:");
        desgn = new JLabel("Designation:");
        addr = new JLabel("Address: ");
        city = new JLabel("City/Town:");
        state_ = new JLabel("State:");
        pcode = new JLabel("Pincode:");
        phone = new JLabel("Phone No:"); 
        employeeid=new JTextField();
        firstname = new JTextField();
        lastname = new JTextField();
        designation = new JTextField();
        address= new JTextField();
        citytxt = new JTextField();
        statetxt = new JTextField();
        pincode = new JTextField();
        phoneno = new JTextField();
        submit = new JButton("Add Employee");
        clear = new JButton("Reset");
        search = new JButton("Search Record");
        update = new JButton("Update Record.");
        submit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int x = 0;
            String c1=employeeid.getText();
            String s1 = firstname.getText();
            String s2 = lastname.getText();
            String s3 = designation.getText();
            String s4 = address.getText(); 
            String s5 = citytxt.getText();
            String s6 = statetxt.getText();
            String s7 = pincode.getText();
            String s8 = phoneno.getText();
            try
     {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
     Statement st=con.createStatement();
     PreparedStatement ptstmt=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?);");
     ptstmt.setString(1,c1);
     ptstmt.setString(2,s1);
     ptstmt.setString(3,s2);
     ptstmt.setString(4,s3);
     ptstmt.setString(5,s4);
     ptstmt.setString(6,s5);
     ptstmt.setString(7,s6);
     ptstmt.setString(8,s7);
     ptstmt.setString(9,s8);
     int status=ptstmt.executeUpdate();
     if(status>0)
         JOptionPane.showMessageDialog(null,"Record Inserted Successfully");
     }
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
        }
    });
        clear.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            firstname.setEditable(true);
            lastname.setEditable(true);
            designation.setEditable(true);
            address.setEditable(true);
            citytxt.setEditable(true);
            statetxt.setEditable(true);
            pincode.setEditable(true);
            phoneno.setEditable(true);
            firstname.setText(null);
            lastname.setText(null);
            designation.setText(null);
            address.setText(null);
            citytxt.setText(null);
            statetxt.setText(null);
            pincode.setText(null);
            phoneno.setText(null);
        }}
        );
        search = new JButton("Search");
        update = new JButton("Update");
        search.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                        try
                        {
        Class.forName("com.mysql.jdbc.Driver");
         Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from employee where e_id="+employeeid.getText());
        while(rs.next())
        {
            firstname.setText(rs.getString(2));
            lastname.setText(rs.getString(3));
            designation.setText(rs.getString(4));
            address.setText(rs.getString(5));
            citytxt.setText(rs.getString(6));
            statetxt.setText(rs.getString(7));
            pincode.setText(rs.getString(8));
            phoneno.setText(rs.getString(9));
            con.close();
        }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
                    }                     
                }
        );
        update.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                        {
        Class.forName("com.mysql.jdbc.Driver");
         Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("update employee set e_fname="+firstname.getText()+",e_lname="+lastname.getText()+",e_desgn="+designation.getText()+"address="+address.getText()+",city="+citytxt.getText()+",state="+statetxt.getText()+",pincode="+pincode.getText()+",phone="+phoneno.getText()+" where e_id="+employeeid.getText());

            }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        }});
        emp_id.setBounds(80,10,200,30);
        fn.setBounds(80, 50, 200, 30);
        ln.setBounds(80, 90, 200, 30);
        desgn.setBounds(80, 130, 200, 30);
        addr.setBounds(80, 170, 200, 30);
        city.setBounds(80, 210, 200, 30);
        state_.setBounds(80, 250, 200, 30);
        pcode.setBounds(80, 290, 200, 30);
        phone.setBounds(80, 330, 200, 30);       
        employeeid.setBounds(300,10,200,30);
        firstname.setBounds(300, 50, 200, 30);
        lastname.setBounds(300, 90, 200, 30);
        designation.setBounds(300, 130, 200, 30);
        address.setBounds(300, 170, 200, 30);
        citytxt.setBounds(300, 210, 200, 30);
        statetxt.setBounds(300, 250, 200, 30);
        pincode.setBounds(300, 290, 200, 30);
        phoneno.setBounds(300, 330, 200, 30);
        submit.setBounds(80, 380, 150, 30);
        clear.setBounds(240, 380, 100, 30);
        search.setBounds(350, 380, 100, 30);
        update.setBounds(460, 380, 100, 30);
        add(emp_id);
        add(fn);
        add(ln);
        add(desgn);
        add(addr);
        add(city);
        add(state_);
        add(pcode);
        add(phone);
        add(employeeid);
        add(firstname);
        add(lastname);
        add(designation);
        add(address);
        add(citytxt);
        add(statetxt);
        add(pincode);
        add(phoneno);
        add(submit);
        add(clear);
        add(search);
        add(update);
        setVisible(true);
    }
}