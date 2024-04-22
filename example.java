class Example
{
    public static void main(String[] args) {
        String a="xy",b="xyz";
        if(a==b)
            System.out.println("1:a==b");
        if(a.equals(b))
            System.out.println("1:a equals b");
        a+="z";
        if(a==b)
            System.out.println("2:a==b");
        if(a.equals(b))
            System.out.println("2:a equals b");
        System.out.println(a);
        System.out.println(b);
     }
}