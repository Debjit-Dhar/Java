/*4. Write a program to create a text file to store a list of names and then read the content. */
import java.io.*;
import java.util.*;
class NameList
{
    private String list[];
    private int size;
    public NameList(int s)
    {
        size=s;
        list=new String[size];
    }
    public void addName()throws IOException
    {
        System.out.println("Enter names");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int i;
        for(i=0;i<size;i++)
            list[i]=br.readLine();
    }
    public void write()throws IOException
    {
        FileWriter fw=new FileWriter("Names.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        int i;
        for(i=0;i<size;i++)
            pw.println(list[i]);
        pw.close();
    }
    public void read() throws IOException
    {
        FileReader fr=new FileReader("Names.txt");
        BufferedReader br= new BufferedReader(fr);
        String line="";
        while((line=br.readLine())!=null)
            System.out.println(line);
        br.close();
    }
}
class NameFile
{
    public static void main(String[] args)throws IOException
    {
        NameList ob=new NameList(5);
        ob.addName();
        ob.write();
        ob.read();
    }
}