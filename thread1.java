class A extends Thread
{
    public void setname()
    {
        Thread.currentThread().setName("eagle apache");
    }
    public void run()
    {
        setname();
        System.out.println("Thread name is: "+Thread.currentThread().getName());
    }
}
class B implements Runnable
{
    public void setname()
    {
        Thread.currentThread().setName("apache hunter");
    }
    public void run()
    {
        setname();
        System.out.println("Thread name is: "+Thread.currentThread().getName());
    }
}
class MainClass
{
    public static void main(String[] args)
    {
        A thread=new A();
        
        B runner=new B();
        Thread t=new Thread(runner);
        t.start();
        thread.start();
    }
}