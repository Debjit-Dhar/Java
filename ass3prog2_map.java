import java.io.*;
import java.util.*;
class Account
{
    private int accno;
    private String name;
    private float balance;
    public Account(int a,String b,float c)
    {
        accno=a;
        name=b;
        balance=c;
    }
    public Account(Account a)
    {
        this.accno=a.accno;
        this.name=a.name;
        this.balance=a.balance;
    }
    public void display()
    {
        System.out.println("Account Number= "+accno+" Name= "+name+" balance= "+balance);
    }
    public float getBal()
    {
        return balance;
    }
    public void setBal(float balance)
    {
        this.balance=balance;
    }
    public int getno()
    {
        return  accno;
    }
    @Override
    public int hashCode() {
        return Integer.hashCode(accno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Account account = (Account) obj;
        return accno == account.accno;
    }
}
class AccountList
{
    private LinkedHashMap<Integer,Account> ac = new LinkedHashMap<Integer,Account>();  
    public void addAccount(int a,String b,float c)
    {
        Account account=new Account(a,b,c);
        ac.put(a,account);
    }
    public void displayAll()
    {
        Set<Map.Entry<Integer,Account>> set=ac.entrySet();
        for(Map.Entry<Integer,Account> entry:set)
            entry.getValue().display();
    }
    public boolean searchAccount(int n)
    {
        return ac.containsKey(n);
    }
    public void setBal(int acc,float n)
    {
        Account a;
        if(searchAccount(acc))
        {
            a=ac.get(acc);
            a.setBal(n);        
            ac.put(acc,a);
        }
        else
            System.out.println("Account DNE");
    }
}
class Bank
{
    private AccountList alob;
    public Bank()throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        alob=new AccountList();
        int ch,a;String b;float c;
        while(true)
        {
            System.out.println("Enter choice\n1.to add account\n2.to search account\n3.to set balance\n4.to display all accounts\nany other to exit");
            ch=Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                System.out.println("Enter account number");
                a=Integer.parseInt(br.readLine());
                System.out.println("Enter name");
                b=br.readLine();
                System.out.println("Enter balance");
                c=Float.parseFloat(br.readLine());
                alob.addAccount(a,b,c);
                break;
                case 2:
                System.out.println("Enter account number");
                a=Integer.parseInt(br.readLine());
                if(alob.searchAccount(a))
                    System.out.println("Account exists");
                else
                    System.out.println("Account does not exist");
                break;
                case 3:
                System.out.println("Enter account number");
                a=Integer.parseInt(br.readLine());
                System.out.println("Enter balance");
                c=Float.parseFloat(br.readLine());
                alob.setBal(a,c);
                break;
                case 4:
                alob.displayAll();
                break;
                default:
                return;
            }
        }
    }
}
class MainClass
{
    public static void main(String[] args)throws IOException {
        Bank ob=new Bank();
    }
}