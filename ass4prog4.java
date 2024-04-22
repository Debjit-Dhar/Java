import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Employee
{
    private int ecode;
    private String ename;
    private float basic;
    private char grade;
    private int dcode;
    public Employee(int a,String b,float c,char d,int e)
    {
        ecode=a;
        ename=b;
        basic=c;
        grade=d;
        dcode=e;
    }
    public void display()
    {
        System.out.println("Employee Code : "+ecode);
        System.out.println("Name :   "+ename);
        System.out.println("Basic Salary :  "+basic);
        System.out.println("Grade :  "+grade);
        System.out.println("Department Code :  "+dcode);
    }
    public int getecode()
    {
        return ecode;
    }
}

class EmployeeList
{
    private ArrayList<Employee> elist;
    public EmployeeList()
    {
        elist=new ArrayList<Employee>();
    }
    public void add(Employee e)
    {
        elist.add(e);
    }
    public boolean search(int x)
    {
        for(Employee e:elist)
        {
            if(e.getecode()==x)
            {
                e.display();
                return true;
            }
        }
        return false;
    }
    public void displayAll()
    {
        for(Employee e:elist)
            e.display();
    }
}
class EmployeeGUI1 extends JFrame
{
    private JPanel p;
    private JLabel l1,l2,l3,l4,l5;
    private JTextField t1,t2,t3,t4;
    private JRadioButtion rb1,rb2,rb3;
    private ButtonGroup bg;
    private JButton b1;
    private boolean confirm;
    public EmployeeGUI1()
    {
        super("Employee Entry");
        super.setSize(400,200);
        panel();
        super.add(p);
        super.setVisible(true);
    }
    public Employee getEmployee()
    {
        char grade;
        if(rb1.isSelected())
            grade='A';
        else if(rb2.isSelected())
            grade='B';
        else
            grade='C';
        Employee e=new Employee(Integer.parseInt(t1.getText()),t2.getText(),Float.parseFloat(t3.getText()),grade,Integer.parseInt(t4.getText()));
        return e;
    }
    
    private void panel()
    {
        confirm=false;
        p=new JPanel();
        l1=new JLabel("Enter Employee Code : ");
        l2=new JLabel("Enter Employee Name : ");
        l3=new JLabel("Enter Employee Basic : ");
        l4=new JLabel("Enter Employee Grade : ");
        l5=new JLabel("Enter Employee Department : ");
        t1=new JTextField(5);
        t2=new JTextField(5);
        t3=new JTextField(5);
        t4=new JTextField(5);
        bg = new ButtonGroup();
        rb1=new JRadioButton("A");
        rb2=new JRadioButton("B");
        rb3=new JRadioButton("C");
        b1=new JButton("Save");
        bg.add(rb1);
        bg.add(rb2);
        bg.add(rb3);
        p.add(l1);p.add(t1);
        p.add(l2);p.add(t2);
        p.add(l3);p.add(t3);
        p.add(l4);p.add(rb1);p.add(rb2);p.add(rb3);
        p.add(l5);p.add(t4);
        b1.addActionListener(new MyListener1());
    }
    public boolean getConfirm()
    {
        return confirm;
    }
    public void errorMsg()
    {
        JOptionPane.showMessageDialog(p,"Employee already exists", "Error", JOptionPane.ERROR_MESSAGE);
    }
    private class MyListener1 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int x;
            if(e.getSource()==b1)
            {
                x=JOptionPane.showConfirmDialog(p, "Confirmation Submission", "Confirmation Message", JOptionPane.YES_NO_OPTION);
                if(x==JOptionPane.YES_OPTION)
                    confirm=true;
                else
                    confirm=false;
            }
        }
    }
}
class EmployeeSystem
{
    private EmployeeList listob;
    private EmployeeGUI1 gui1;
    public EmployeeSystem()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        listob=new EmployeeList();
        Employee e;
        int ch;
        while(true)
        {
            System.out.println("Enter choice 1. to add 2. to search any other to exit.");
            ch=Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                    gui1=new EmployeeGUI1();
                    e=gui1.getEmployee();
                    if(!listob.search(e.getecode()))
                        listob.add(e);
                    else
                        gui1.errorMsg();
                    listob.displayAll();
                break;
                case 2:
                break;
                default:
                return;
            }
        }
    }
}
class MainClass
{

}