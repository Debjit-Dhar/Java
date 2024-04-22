import java.io.IOException;
import javax.swing.*;

import javax.swing.JOptionPane;
class GUI1
{
    public static void main(String[] args)throws IOException {
        String x=JOptionPane.showInputDialog(null,"Enter Integer","Integer Entry",JOptionPane.QUESTION_MESSAGE);
        int a;
        if(x!=null)
        {
            a=Integer.parseInt(x);
            System.out.println("Integer entered is: "+a);
        }
    }
}