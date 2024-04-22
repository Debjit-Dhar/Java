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
    public void display()
    {
        System.out.println("Account Number= "+accno+" Name= "+name+" balance= "+balance);
    }
    public float getBal()
    {
        return balance;
    }
    public void setBal(int balance)
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
class Equality implements Comparator<Account>
{
    public int compare(Account x,Account y)
    {
        return x.getno()-y.getno();
    }
}
class AccountList
{
    Comparator<Account> comp=new Equality();
    private LinkedHashSet<Account> ac = new LinkedHashSet<>();  
    public void addAccount(int a,String b,float c)
    {
        Account account=new Account(a,b,c);
        ac.add(account);
    }
    public void displayAll()
    {
        for(Account account:ac)
            account.display();
    }
    public boolean searchAccount(int n)
    {
        Account account=new Account(n,"",0);
        return ac.contains(account);
    }
    public void setBal(int n)
    {
        
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
                alob.setBal(a);
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