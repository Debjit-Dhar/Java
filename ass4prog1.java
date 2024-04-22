class InrDcr
{
    int n;
    int inr;
    int dcr;
    
    boolean status=false;
    public InrDcr(int inr)
    {
        n=0;
        this.inr=inr;
        this.dcr=5;
    }
    public synchronized void increment()
    {
        while(!status)
        {
            try{
                
                wait();
            }
            catch(InterruptedException e){}
        }
        
        n=n+inr;
        System.out.println("Incremented value is "+n);
        status=false;
        notify();
    }
    public synchronized void decrement()
    {
        while(status)
        {
            try{
                
                wait();
            }
            catch(InterruptedException e){}
        }
        
        n=n-dcr;
        System.out.println("Decremented value is "+n);
        status=true;
        notify();
    }
}
class MyThread1 implements Runnable
{
    InrDcr id;
    Thread t;
    int cnt=0;
    MyThread1(InrDcr id)
    {
        this.id=id;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        while(true && cnt<=20)
        {
            id.increment();
            cnt++;
        }
    }
}
class MyThread2 implements Runnable
{
    InrDcr id;
    Thread t;
    int cnt=0;
    MyThread2(InrDcr id)
    {
        this.id=id;
        t=new Thread(this);
        t.start();
    }
    public void run()
    {
        while(true && cnt<=20)
        {
            id.decrement();
            cnt++;
        }
    }
}
class MainClass 
{
    public static void main(String[] args) {
        InrDcr id=new InrDcr(10);
        MyThread1 t1=new MyThread1(id);
        MyThread2 t2=new MyThread2(id);
    }
}