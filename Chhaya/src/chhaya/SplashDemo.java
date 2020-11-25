package chhaya;
import com.sun.javafx.applet.Splash;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class SplashDemo extends JFrame 
{
    private static JProgressBar pbar;
    Thread t = null;
    public SplashDemo() 
    {
        super("Splash");
        setSize(300, 330);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setLayout(null);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon("D:/pratham/Chhaya/src/images/77ded5298373864055684d5c06e01a9f-01.jpg"));
        label.setBounds(0, 10,300, 300);
        add(label);
        pbar = new JProgressBar();
        pbar.setMinimum(0);
        pbar.setMaximum(100);
        pbar.setStringPainted(true);
        pbar.setForeground(Color.BLACK);
        pbar.setPreferredSize(new Dimension(300, 30));
        pbar.setBounds(0, 310, 300, 20);
        add(pbar);
        Thread t = new Thread() 
        {
            public void run() 
            {
                int i = 0;
                while (i <= 100) 
                {
                    pbar.setValue(i);
                    try 
                    {
                        sleep(85);
                    } catch (InterruptedException ex) 
                    {
                        Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    i++;
                }
            }
        };
        t.start();
    }
        public static void main(String args[])throws Exception
    {
        SplashDemo s=new SplashDemo();
        s.setVisible(true);
        Thread t=Thread.currentThread();
        t.sleep(10000);
        s.dispose();
        SwingUtilities.invokeLater(new Runnable(){
            public void run()
            {
                 LogReg mainFrame=new LogReg();
                 mainFrame.setVisible(true);
            }
        }
        );
    }
}
        
