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
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


class AddCustomer extends JFrame
{
    JLabel fn, ln, addr1, addr2,city,state_,pcode, phone,cust_id;
    JTextField customerid, firstname,lastname,address1,address2,citytxt,statetxt,pincode,phoneno;
    JButton submit, clear;
    AddCustomer()
     {
         setSize(700, 500);
         setLayout(null);
         setResizable(false);
         setLocationRelativeTo(null);
         setTitle("Customer Registration Form.");
         cust_id=new JLabel("Customer ID:");
        fn = new JLabel("First Name::");
        ln = new JLabel("Last Name:");
        addr1 = new JLabel("Address Line 1:");
        addr2 = new JLabel("Address Line 2:");
        city = new JLabel("City/Town:");
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
        submit = new JButton("Add Customer");
        clear = new JButton("Reset");
        submit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int x = 0;
            String c1=customerid.getText();
            String s1 = firstname.getText();
            String s2 = lastname.getText();
            String s3 = address1.getText();
            String s4 = address2.getText(); 
            String s5 = citytxt.getText();
            String s6 = statetxt.getText();
            String s7 = pincode.getText();
            String s8 = phoneno.getText();
            try
     {
     Class.forName("com.mysql.jdbc.Driver");
     Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
     Statement st=con.createStatement();
     PreparedStatement ptstmt=con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?);");
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
        }}
        );
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
        submit.setBounds(80, 380, 150, 30);
        clear.setBounds(450, 380, 100, 30);
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
        add(submit);
        add(clear);
        setVisible(true);
    }
}