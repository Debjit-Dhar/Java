class A 
{
    static void f(int...v)
    {
        System.out.println("int vararg");
    }
    static void f(boolean...v)
    {
        System.out.println("boolean vararg");
    }
    static void f(short v)
    {
        System.out.println("int");
    }
    static void f1(float v1,int...v2)
    {
        System.out.print("float,int vararg");
    }
    static void f1(int  v1,float...v2)
    {
        System.out.print("int,float vararg");
    }
    public static void main(String[] args)
    {
        f(0);//if f(int v) not there then it will call f(int...v) otherwise it will call f(int v) even if f(long v) instead of f(int v) then also f(long v) called but if short or byte then f(int...v) called
        //f1(2);ambiguity
        f1(2.3f);//calls  f1(float v1,int...v)
    }
}