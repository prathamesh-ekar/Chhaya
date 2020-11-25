/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chhaya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author prathamesh
 */
public class ShowAllEmployees extends JFrame
{
    JTextArea ta;
    JScrollPane sp;
    public ShowAllEmployees()
    {
        
        setSize(600,600);
        setLocationRelativeTo(null);
        ta=new JTextArea();
        sp=new JScrollPane(ta);
        sp.setBounds(20,100,500,500);
        add(sp);
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab","root","root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from employee");
            while(rs.next())
            {
                ta.append(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\n");
                //con.close();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        setTitle("All Customers");
        //setDefaultCloseOperation(ShowAllCustomers.EXIT_ON_CLOSE);
      setVisible(true);

       

    }
     public static void main(String[] args)
    {
        ShowAllEmployees mn=new ShowAllEmployees();
        mn.setVisible(true);
    }
}
