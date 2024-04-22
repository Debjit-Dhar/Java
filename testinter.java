
interface In1
{
    class A
    {
        public void display()
        {
            System.out.println("Hello");
        }
    }
    A aob=new A();
}
class Main implements In1
{
    public static void main(String args[])
    {
        In1 m=new jtest();
        aob.display();
    }
}