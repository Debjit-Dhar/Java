import java.util.*;
import java.io.*;
class Student 
{
    private int roll;
    private String name;
    private float cgpa;
    public Student(int a,String b,float c)
    {
        roll=a;name=b;cgpa=c;
    }
    public Student(Student s)
    {
        this.roll=s.roll;
        this.name=s.name;
        this.cgpa=s.cgpa;
    }
    public void display()
    {
        System.out.println("Roll No= "+roll+" Name= "+name+ " CGPA ="+cgpa);
    }
    public int getRoll()
    {
        return roll;
    }
    public String toString()
    {
        return roll+"\t"+name+"\t"+cgpa;
    }
}
class StudentTF
{
    public void write(Student s)throws IOException
    {
        FileWriter fw=new FileWriter("Student Text File.txt",true);
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        String line=s.toString();
        pw.println(line);
        pw.close();
    }
    public void read()throws IOException
    {
        FileReader fr=new FileReader("Student Text File.txt");
        BufferedReader br=new BufferedReader(fr);
        String line="";
        int r;
        StringTokenizer st;
        while((line=br.readLine())!=null)
        {
            st=new StringTokenizer(line);
            r=Integer.parseInt(st.nextToken());
            if(r!=-1)
                System.out.println("Roll No= "+r+" Name= "+st.nextToken()+"  CGPA ="+st.nextToken());
        }
            
        br.close();
    }
    public void deleteFile()
    {
        File f=new File("Student Text File.txt");
        if(f.exists())
            f.delete();
    }
    
}
class MainClass {
    public static void main(String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StudentTF studentTF = new StudentTF();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Delete Student File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error reading input: " + e.getMessage());
                choice = -1;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter roll number: ");
                        int roll = Integer.parseInt(reader.readLine());
                        System.out.print("Enter name: ");
                        String name = reader.readLine();
                        System.out.print("Enter CGPA: ");
                        float cgpa = Float.parseFloat(reader.readLine());
                        Student s=new Student(roll,name,cgpa);
                        studentTF.write(s);
                        System.out.println("Student added successfully!");
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        studentTF.read();
                    } catch (IOException e) {
                        System.out.println("Error occurred while reading from file: " + e.getMessage());
                    }
                    break;
                case 3:
                    studentTF.deleteFile();
                    System.out.println("Student file deleted successfully!");
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 4);

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing reader: " + e.getMessage());
        }
    }
}