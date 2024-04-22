/*Write a program that takes a filename from user and checks whether it exists or not. If it exists then check whether it is a directory or not. If it is a directory then show the list of files in it. If it is not a directory then show whether it can be read and/or written into. */
import java.io.*;
class FileChecker
{
    public static void main(String[] args)
    {
        File f=new File("C1.java");
        if(f.exists())
        {
            System.out.println("Exists");
            if(f.isDirectory())
            {
                System.out.println( "It is a directory");
                String[] files=f.list();
                for(int i=0;i<files.length;i++)
                   System.out.println(files[i]); 
            }
            else
            {
                System.out.println( "It is a file");
                if(f.canRead())
                    System.out.println("Can be read into");
                else
                    System.out.println("Cannot be read into");
                if(f.canWrite())
                    System.out.println("Can be written into");
                else
                    System.out.println("Cannot be written into");
            }
                
        }
        else
            System.out.println("DNE");
    }
}