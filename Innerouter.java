class A
{
    class B
    {
        private int a1;
        protected int b1;
        int  c1;
        public int d1;
        public void access1()
        {
            a2=1;b2=2;c2=3;d2=4;
        }
    }
    private int a2;
    protected int b2;
    int c2;
    public int d2;
    B b=new B();
    public void access()
    {
        b.a1=1;b.b1=2;b.c1=3;b.d1=4;
        b.access1();
    }
    
}
class implement
{
    public static void main(String[] args) {
        A  obj = new A();
        obj.a2=12;obj.b2=22;obj.c2=32;obj.d2=42;
        obj.b.a1=11;obj.b.b1=21;obj.b.c1=31;obj.b.d1=41;
    }
}