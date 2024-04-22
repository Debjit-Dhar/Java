public class lab {
    static void f(int a,int b)
    {
        System.out.println("Inside f(int,int)");
    }
    static void f(char a,char b){
        System.out.println("Inside f(char,char)");
    }
    /*static void f(float a,float b){
        System.out.println("Inside f(float,float)");
    }*/
    static void f(float a,double b){
        System.out.println("Inside f(float,double)");
    }
    static void f(float a,long b){
        System.out.println("Inside f(float,long)");
    }
    public static void main(String args[])
    {
        
        int a=2;char b='2';float c=2.0f;
        f(a,b);
        f(b,a);
        f(a,c);
        f(c,a);
    }
}
