/*Each department s described by dept code (unique), dept name, location. Each employee is described by emp code (unique), emp name , basic and dept code.  Maintain list of departments and list of employees such that one can:
i) add employee (emp code  unique and dept code must exist), add department (dept code unique)
ii) display the details  for a given emp code along with corresponding department details.
iii) display details of all employees
iv) find total basic pay for a department
v) remove an employee (given an emp code)
vi) modify basic of an employee
vii) sort the employee list -- according to basic in descending order, according to dept code, according to emp code
Design and implement the classes. Do the same once considering the list as an array like collection and again as an linked list like collection.
 */
import java.util.*;
import java.io.*;
class Department
{
    private int deptCode;
    private  String deptName;
    private String location;
    public Department(int a,String b,String c)
    {
        deptCode=a;
        deptName=b;
        location=c;
    }
    public void display()
    {
        System.out.println("Department Code= "+deptCode+" Department Name= "+deptName+ " Location= "+location);
    }
    public int getCode()
    {
        return deptCode;
    }
}
class DeptSearch implements Comparator<Department>
{
    private int code;
    public DeptSearch(int c)
    {
        code=c;
    }
    public int compare(Department x,Department y)
    {
        if (x.getCode()==code)
            return 0;
        return 1;
    }
}
class DepartmentList
{
    private ArrayList<Department> dlist = new ArrayList<>();
    public void addDept(int a,String b,String c)
    {
        Department dept=new Department(a,b,c);
        if(!exist(dept.getCode()))
            dlist.add(dept);
        else
            System.out.println("Department already exists!");
    }
    
    public boolean exist(int x)
    {
        for(Department temp : dlist)
        {
            if(temp.getCode() == x)
                return true;
        }
        return false;
    }
    public void display()
    {
        Iterator<Department> itr=dlist.iterator();
        while(itr.hasNext())
        {
            itr.next().display();
        }
    }
    public void displayDepartment(int dcode)
    {
        for(Department d:dlist)
        {
            if(d.getCode()==dcode)
                d.display();
        }
    }
}
class Employee 
{
    private int empCode;
    private String empName;
    private float basic;
    private int deptCode;
    public Employee(int a,String  b,float c,int d)
    {
        empCode = a ;
        empName=b;
        basic=c;
        deptCode=d;
    }
    public void display()
    {
        System.out.println("Employee Name= "+empName+" Employee Code= "+empCode+" Basic Salary= "+basic);
    }
    public int getCode()
    {
        return empCode;
    }
    public int getDept()
    {
        return deptCode;
    }
    public float getSalary()
    {
        return basic;
    }
    public void setBasic(float b)
    {
        basic=b;
    }
}

class EmpSearch implements Comparator<Employee>
{
    private int code;
    public EmpSearch(int c)
    {
        code=c;
    }
    public int compare(Employee x,Employee y)
    {
        if (x.getCode()==code)
            return 0;
        return 1;
    }
}
interface EmpSort extends Comparator<Employee>
{

}
class EmpSort1 implements EmpSort
{
    public int compare(Employee x,Employee y)
    {
        if(y.getSalary()>x.getSalary())
            return 1;
        else if(y.getSalary()<x.getSalary())
            return -1;
        return 0;
    }
}
class EmpSort2 implements EmpSort
{   
    public int compare(Employee x, Employee y)
    {
        return x.getDept()-y.getDept();
    }
}
class EmpSort3 implements EmpSort
{
    public int compare(Employee x, Employee y)
    {
        return x.getCode()-y.getCode();
    }
}
class EmployeeList
{
    private ArrayList<Employee> elist = new ArrayList<>();
    public void addEmp(int a,String b,float c,int d)
    {
        Employee emp=new Employee(a,b,c,d);
        if(!exist(emp.getCode()))
            elist.add(emp);
        else
            System.out.println("Department already exists!");
    }
    
    public boolean exist(int x)
    {
        for(Employee e:elist)
        {
            if(e.getCode()==x)
                return true;
        }
        return false;
    }
    public void display()
    {
        Iterator<Employee> itr=elist.iterator();
        while(itr.hasNext())
        {
            itr.next().display();
        }
    }
    public float totBasic(int dcode)
    {
        float sum=0;
        for(Employee e:elist)
            if(e.getDept()==dcode)
                sum+=e.getSalary();
        return sum;
    }
    public int displayEmployee(int ecode)
    {
        for(Employee e:elist)
        {
            if(e.getCode()==ecode)
            {
                 e.display();  
                 return e.getDept();
            }
       }
       return 0;
    }
    public void setBasic(int ecode,float basic)
    {
        for(Employee e:elist)
        {
            if(e.getCode()==ecode)
                e.setBasic(basic);            
        }
    }
    public void sortList(int choice)
    {
        EmpSort comp;
        if(choice==1)
        {
            comp=new EmpSort1();
            Collections.sort(elist,comp);
        }
        else if(choice==2)
        {
            comp=new EmpSort2();
            Collections.sort(elist,comp);
        }
        else
        {
            comp=new EmpSort3();
            Collections.sort(elist,comp);
        }
    }
    public void remove(int  ecode)
    {
        Iterator<Employee> itr = elist.iterator();
        while (itr.hasNext()) 
		{
            Employee emp = itr.next();
            if (emp.getCode() == ecode)  
			{
               itr.remove();
               return;
            }
        }
        System.out.println("Employee DNE");
    }
}
class EmploymentSystem
{
    private EmployeeList eob;
    private DepartmentList dob;
    public EmploymentSystem()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        eob=new EmployeeList();
        dob=new DepartmentList();
        int ch;
        System.out.println("Each department s described by dept code (unique), dept name, location. Each employee is described by emp code (unique), emp name , basic and dept code.  Maintain list of departments and list of employees such that one can:");
        System.out.println("(i)add department (dept code unique)");
        System.out.println("(ii) add employee (emp code  unique and dept code must exist)");        
        System.out.println("(iii) display the details  for a given emp code along with corresponding department details.");
        System.out.println("(iv) display details of all employees");
        System.out.println("(v) find total basic pay for a department");
        System.out.println("(vi) remove an employee (given an emp code)");
        System.out.println("(vii) modify basic of an employee");
        System.out.println("(viii) sort the employee list -- according to basic in descending order, according to dept code, according to emp code");
        
        int a,d;String b,c;float e;
        while(true){
            System.out.println("Enter choice");
        ch=Integer.parseInt(br.readLine());
        switch(ch)
        {
            case 1:
            System.out.println("Enter department code");
            a=Integer.parseInt(br.readLine());
            System.out.println("Enter name");
            b=br.readLine();
            System.out.println("Enter location");
            c=br.readLine();
            dob.addDept(a,b,c);
            break;
            case 2:
            System.out.println("Enter employee code");
            a=Integer.parseInt(br.readLine());
            System.out.println("Enter name");
            b=br.readLine();
            System.out.println("Enter salary");
            e=Float.parseFloat(br.readLine());
            System.out.println("Enter department code");
            d=Integer.parseInt(br.readLine());
            if(dob.exist(d))
                eob.addEmp(a,b,e,d);
            else
                System.out.println( "Department does not exist.");
            break;
            case 3:
            System.out.println("Enter employee code");
            a=Integer.parseInt(br.readLine());
            d=eob.displayEmployee(a);
            if(d!=0)
                dob.displayDepartment(d);
            break;
            case 4:
            eob.display();
            break;
            case 5:
            System.out.println("Enter department code");
            a=Integer.parseInt(br.readLine());
            System.out.println(eob.totBasic(a));
            break;
            case 6:
            System.out.println("Enter employee code");
            a=Integer.parseInt(br.readLine());
            eob.remove(a);
            break;
            case 7:
            System.out.println("Enter employee code");
            a=Integer.parseInt(br.readLine());
            System.out.println("Enter basic");
            e=Float.parseFloat(br.readLine());
            eob.setBasic(a,e);
            break;
            case 8:
            System.out.println("Enter sort choice");
            a=Integer.parseInt(br.readLine());
            eob.sortList(a);
            break;
            default:
            return;
        }
        }
    }
}
class ImplementEmployeeSystem
{
    public static void main(String[] args)throws IOException {
        EmploymentSystem es=new EmploymentSystem();
    }
}