package chhaya;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
public class Main extends JFrame
{
    JMenuBar jmb;
    JMenu Customer,Employee,Stock,Transaction,Tools,notepad,Help,Exit;
    JMenuItem Addcustomer, Viewcustomer;
    JMenuItem AddEmployee, ViewEmployee;
    JMenuItem AddStock, ViewStock;
    JMenuItem NewTransaction;
    JMenuItem calculator,opennotepad;
    JMenuItem About;
    JMenuItem Logout,exit;
    public Main() 
    {
        setTitle("Welcome to Chhaya v.0.1.");
    setSize(Toolkit.getDefaultToolkit().getScreenSize());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jmb = new JMenuBar();
    JLabel background=new JLabel(new ImageIcon("D:/pratham/Chhaya/src/images/637639.jpg"));
	add(background);
	background.setLayout(new FlowLayout());
    Customer = new JMenu("Customer");
    Addcustomer=new JMenuItem("Add new Customer.");
    Addcustomer.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            AddCustomer adc=new AddCustomer();
            adc.show(true);
        }
    });
    Customer.add(Addcustomer);
    Customer.addSeparator();
    Viewcustomer=new JMenuItem("View Customer");
    Viewcustomer.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            ViewCustomer vc=new ViewCustomer();
            vc.show(true);
        }
    });
    Customer.add(Viewcustomer);
    jmb.add(Customer);
    Employee = new JMenu("Employee");
    AddEmployee=new JMenuItem("Add new employee.");
    AddEmployee.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            EmployeeDetails emp=new EmployeeDetails();
            emp.show(true);
        }
       
    });
    Employee.add(AddEmployee);
    jmb.add(Employee);
    Stock = new JMenu("Stock");
    AddStock = new JMenuItem("Add new item(s).");
    AddStock.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            AddItem adi=new AddItem();
            adi.show(true);
        }
    });
    Stock.add(AddStock);
    jmb.add(Stock);
   /* Transaction = new JMenu("Transaction");
    NewTransaction=new JMenuItem("New Transaction.");
    NewTransaction.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            GenerateBill adi=new GenerateBill();
            adi.show(true);
        }
    });
    Transaction.add(NewTransaction);
    jmb.add(Transaction);*/
    Tools = new JMenu("Tools");
    calculator = new JMenuItem("Calculator");
    calculator.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Runtime rt=Runtime.getRuntime();
        try {
            rt.exec("c:/WINDOWS/system32/calc.exe");
           
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    });
    Tools.add(calculator);
    Tools.addSeparator();
    opennotepad=new JMenuItem("Notepad");
    opennotepad.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Runtime rt=Runtime.getRuntime();
        try {
            rt.exec("c:/WINDOWS/system32/notepad.exe");
           
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    });
    Tools.add(opennotepad);
    jmb.add(Tools);
    Help = new JMenu("Help");
    About = new JMenuItem("About");
    About.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            String oc="Chhaya Photo Studio Management Software.";
            oc+="\nVersion: 0.1.";
            oc+="\nFront-end developed in: NetBeans IDE 8.2";
            oc+="\nDatabase managed using: MySQL 5.7.";
            oc+="\nApplication developed by: Prathamesh Rajesh Ekar, Shailesh Kale & Yogesh Navathe.";
            
            ImageIcon icon = new ImageIcon("D:/pratham/Chhaya/src/images/77ded5298373864055684d5c06e01a9f-01.jpg");
        JOptionPane.showMessageDialog(new JFrame(),
                oc, "About Chhaya",
                JOptionPane.INFORMATION_MESSAGE, icon);
        }
    });
    Help.add(About);
    jmb.add(Help);
    Exit=new JMenu("Exit");
    Logout=new JMenuItem("Logout");
    Logout.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            LogReg loginframe = new LogReg();
            loginframe.setVisible(true);
            dispose();
                   
        }
    });
    Exit.add(Logout);
    exit=new JMenuItem("Exit Chhaya");
    exit.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            int a=JOptionPane.showConfirmDialog(new JFrame(),"Are you sure you want to exit?");
            if(a==JOptionPane.YES_OPTION)
            {
                System.exit(0);
            }
                   
        }
    });
    Exit.add(exit);
    jmb.add(Exit);
    setJMenuBar(jmb);
    setBackground(Color.LIGHT_GRAY);
    setVisible(true);
    }
    public static void main(String[] args)
    {
        Main mn=new Main();
        mn.setVisible(true);
    }
  }