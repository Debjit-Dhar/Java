class A
{
    static void f(int...v)
    {
        System.out.println("vararg");
    }
    static void f(int v)
    {
        System.out.println("single arg");
    }
    public static void main(String[] args) {
        f(5);
        System.out.println(System.out.getClass());
    }
}
