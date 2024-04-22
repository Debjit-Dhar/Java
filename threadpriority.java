

class MyThread implements Runnable
{
    Thread t;
    long time=0;
    private volatile boolean running=true;
    public MyThread(int p)
    {
        t=new Thread(this);
        t.setPriority(p);
    }
    public void run()
    {
        while(running)
            time++;
    }
    public void stop()
    {
        running=false;
    }
    public void start()
    {
        t.start();
    }
}
class MainClass
{
    public static void main(String[] args)throws InterruptedException {
        System.out.println("Hello");
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        MyThread t1=new MyThread(4);
        MyThread t2=new MyThread(8); 
        System.out.println("Thread 1= "+t1.time);
        System.out.println("Thread 2= "+t2.time);       
        t1.start();
        t2.start();
        Thread.sleep(10000);
        /*if(t1.t.isAlive())
            t1.t.join();
        if(t2.t.isAlive())
            t2.t.join();*/
        System.out.println("Thread 1= "+t1.time);
        System.out.println("Thread 2= "+t2.time);
    }
}