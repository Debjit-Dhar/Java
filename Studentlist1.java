import java.util.*;
class StuComp implements Comparator<Student>{
    public int compare(Student s1, Student s2) {
        return Float.compare(s1.getcgpa(), s2.getcgpa());
    }
}
class Student {
    private int roll;
    private float cgpa;
    private String name;
    public Student(int a,String b,float c) {
        this.roll=a;
        this.name =b;
        this.cgpa=c;
        }
    public void display()
    {
        System.out.print( "Roll No.: "+roll);
        System.out.println(" Name: "+name+" CGPA: "+cgpa);
    }
    public int getroll()
    {
        return roll;
    }
    public float getcgpa()
    {
        return cgpa;
    }
}
class Studentlist
{
    ArrayList<Student> list;
    Iterator<Student> it;
    public Studentlist()
    {   
        list = new ArrayList<Student>();
    }
    public void addstudent(int r,String n,float c)  //method to add student details in the array
    {
        Student s=new Student(r,n,c);
        list.add(s);
    }
    public float averagecgpa()
    {
        it = list.iterator();
        float s=0;
        while (it.hasNext())
            s+=(float)it.next().getcgpa();
        return s/list.size();
        
    }
    public void displaylist()
    {
        it = list.iterator();
        float s=0;
        while (it.hasNext())
            it.next().display();
    }
    public void sortStudent(){
        Comparator<Student> comp=new StuComp();
        Collections.sort(list,comp);
    }
}
class TestList
{
    public static void main(String args[])
    {
        Studentlist ob;
        ob=new Studentlist();
        ob.addstudent(1,"ghgh",9.0f);
        ob.addstudent(4,"debjit dhar",9.4f);
        ob.addstudent(8,"gjhjvha",9.2f);
        ob.displaylist();
        ob.sortStudent();
        ob.displaylist();
        System.out.println("Average CGPA is "+ob.averagecgpa());
    }
}
