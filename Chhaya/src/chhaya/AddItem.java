package chhaya;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.zip.*;
import javax.swing.JPopupMenu;

public class AddItem extends JFrame implements ActionListener {

    JTextField id, name, cost, tax, stock;
    Container c;
    JButton add, reset, view;
    JOptionPane jp = new JOptionPane();
    JLabel cgry, lid, lname, lcost, ltax, lstock;
    JComboBox category;
    int t = 0;

    public AddItem() {
        super("Add New Item");
        setSize(700, 500);
        setLocationRelativeTo(null);
        c = getContentPane();

        c.setLayout(null);
        category = new JComboBox();
        category.addItem("Camera");
        category.addItem("Spare Parts");
        category.addItem("Equipment");
        category.addItem("Photo / Stationary.");
        category.setSelectedItem(null);
        c.add(category);
        cgry = new JLabel("Select Category");
        lid = new JLabel("Product ID :");
        lid.setForeground(Color.black);
        lname = new JLabel("Product Name :");
        lname.setForeground(Color.black);
        lcost = new JLabel("Cost:");
        lcost.setForeground(Color.black);
        ltax = new JLabel("Tax (in %):");
        ltax.setForeground(Color.black);
        lstock = new JLabel("Quantity:");
        lstock.setForeground(Color.black);
        id = new JTextField();
        id.setForeground(Color.black);
        id.setBackground(Color.white);
        name = new JTextField();
        name.setForeground(Color.black);
        name.setBackground(Color.white);
        cost = new JTextField();
        cost.setForeground(Color.black);
        cost.setBackground(Color.white);
        tax = new JTextField();
        tax.setForeground(Color.black);
        tax.setBackground(Color.white);
        stock = new JTextField();
        stock.setForeground(Color.black);
        stock.setBackground(Color.white);
        add = new JButton("Add", new ImageIcon("image/other/New.GIF"));
        add.setForeground(Color.white);
        add.setBackground(new Color(128, 0, 0));
        add.setToolTipText("To Add Item");
        reset = new JButton("Reset", new ImageIcon("image/other/New.GIF"));
        reset.setForeground(Color.white);
        reset.setBackground(new Color(128, 0, 0));
        reset.setToolTipText("To Reset Fields");
        cgry.setBounds(80, 20, 200, 30);
        category.setBounds(300, 20, 200, 30);
        lid.setBounds(80, 70, 200, 30);
        lname.setBounds(80, 110, 200, 30);
        lcost.setBounds(80, 150, 200, 30);
        ltax.setBounds(80, 190, 200, 30);
        lstock.setBounds(80, 230, 200, 30);
        id.setBounds(300, 70, 200, 30);
        name.setBounds(300, 110, 200, 30);
        cost.setBounds(300, 150, 200, 30);
        tax.setBounds(300, 190, 200, 30);
        stock.setBounds(300, 230, 200, 30);
        add.setBounds(150, 350, 100, 30);
        reset.setBounds(270, 350, 100, 30);
        add.addActionListener(this);
        reset.addActionListener(this);
        c.add(cgry);
        c.add(lid);
        c.add(lname);
        c.add(lcost);
        c.add(ltax);
        c.add(lstock);
        c.add(id);
        c.add(name);
        c.add(cost);
        c.add(tax);
        c.add(stock);
        c.add(add);
        c.add(reset);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String str1 = (String) ae.getActionCommand();
        Object source = ae.getSource();
        if (source == add) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/PhotoLab", "root", "root");
                Statement stm = c.createStatement();
                t = 0;
                if (((tax.getText().length() != 0) && (Integer.parseInt(tax.getText()) > 100 || Integer.parseInt(tax.getText()) < 0))) {
                    jp.showMessageDialog(this, "Tax Must be in between 1 to 100", "INFORMATION", jp.ERROR_MESSAGE);
                } else {
                    ResultSet rs1 = stm.executeQuery("select * from stock where p_id=" + id.getText());
                    while (rs1.next()) {
                        t = 1;
                    }
                    if (t == 0) {
                        t = 0;
                        PreparedStatement ps = c.prepareStatement("insert into stock values(?,?,?,?,?,?)");
                        if ((id.getText()).length() != 0) {
                            ps.setString(1, id.getText());
                        } else {
                            ps.setString(1, "");
                        }
                        if ((name.getText()).length() != 0) {
                            ps.setString(2, name.getText());
                        } else {
                            ps.setString(2, "");
                        }
                        if (category.getSelectedIndex() != 0) 
                        {
                            //String cat=category.getSelectedItem().toString();
                            ps.setString(3,category.getSelectedItem().toString() );
                        } 
                        else {
                            ps.setString(3, "");
                        }
                        if ((cost.getText()).length() != 0) {
                            ps.setString(4, cost.getText());
                        } else {
                            ps.setString(4, "");
                        }
                        if ((tax.getText()).length() != 0) {
                            ps.setString(5, tax.getText());
                        } else {
                            ps.setString(5, "");
                        }
                        if ((stock.getText()).length() != 0) {
                            ps.setString(6, stock.getText());
                        } else {
                            ps.setString(6, "");
                        }

                        ps.executeUpdate();
                        jp.showMessageDialog(this, "Record Inserted Successfully", "SUCCESS", jp.INFORMATION_MESSAGE);
                    } else {
                        jp.showMessageDialog(this, "Sorry, Record ID is Already Exists", "INFORMATION", jp.ERROR_MESSAGE);
                        t = 0;
                    }
                }
                c.close();
                stm.close();
            } catch (ClassNotFoundException cnf) {
                System.out.println("Cnf Exception");
            } catch (SQLException sql) {
                jp.showMessageDialog(this, sql, "EXCEPTION", jp.ERROR_MESSAGE);
            }
        }
        if (source == reset) {
            id.setEditable(true);
            name.setEditable(true);
            cost.setEditable(true);
            tax.setEditable(true);
            stock.setEditable(true);
            category.setSelectedItem(null);
            id.setText(null);
            name.setText(null);
            cost.setText(null);
            tax.setText(null);
            stock.setText(null);

        }
    }

}
