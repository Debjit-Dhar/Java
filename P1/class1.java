package P1;

import java.io.IOException;
class Dbz extends ArithmeticException
{
    public String toString()
    {
        return "Division by zero";
    }
}
class A1
{
    static void accept()
    {
        
        int a=0,b;
        try{
            if(a==0)
                throw new Dbz();
            b=4/a;
        }
        catch(Dbz e)
        {
            System.out.println("2"+e);
            a=2;
            b=4/a;
        }
        catch(ArithmeticException e)
        {
            System.out.println("1"+e);
            a=2;
            b=4/a;
        }
    }
    public static void main(String[] args) {
            int x = 5;
        System.out.println("x is="+x);
        accept();
        
    }
}