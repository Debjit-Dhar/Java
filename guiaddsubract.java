import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class Computer extends JFrame
{
    //componenets
    private JPanel p;
    private JLabel l1,l2;
    private JTextField t1,t2;
    private JButton b1,b2;
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int v1,v2,res;
            String x=t1.getText();
            String y=t2.getText();
            if (x.equals("")||y.equals("")) 
                JOptionPane.showMessageDialog(p, "Input field is empty!","Error",JOptionPane.ERROR_MESSAGE);
            else
            {
                v1=Integer.parseInt(x);
                v2=Integer.parseInt(y);
                if(e.getSource()==b1)
                    res=v1+v2;
                else
                    res=v1-v2;
                JOptionPane.showMessageDialog(p,"Result is "+res,"Result",JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }
    public Computer()
    {
        super("Compute");
        super.setSize(400,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel();
        super.add(p);
        super.setVisible(true);
    }
    public void panel()
    {
        p=new JPanel();
        l1=new  JLabel("Enter Number 1 : ");
        t1=new  JTextField(5);
        l2=new JLabel("Enter Number 2 : ");        
        t2=new JTextField(6);
        b1=new  JButton("Add");
        b2=new JButton("Subtract");
        b1.addActionListener(new MyActionListener());
        b2.addActionListener(new MyActionListener());
        p.add(l1);
        p.add(t1);
        p.add(l2);        
        p.add(t2);
        p.add(b1);
        p.add(b2);
    }
}
class MainClass
{
    public static void main(String[] args)
    {
        Computer comp=new Computer();
        
    }
}