class A 
{
    static void f(int v)
    {
        System.out.println("int");
    }
}
class B extends A
{
    static void f(int v)
    {
        System.out.println("Integer");
    }
}
interface i1
{

}
interface i2
{

}
interface i3 extends i1,i2
{
    
}
class MainClass
{
    public static void main(String[] args) {
        A a=new A();
        a=new B();
        a.f(5);        
    }
}