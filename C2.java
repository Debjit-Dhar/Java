package P2;
class C2 extends P1.C1{
    int c2ele;
    C2(int a,int b)
    {
        super(a);
        c2ele=b;
    }
    public static void main(String args[])
    {
        C2 c2ob=new C2(2,3);
        System.out.println(c2ob.c1ele+c2ob.c2ele);
    }
}