import java.util.Scanner; // Import Scanner for user input

class Customer {
    private int customerId;
    private String name;
    private float currAmt;
    private int phNo;

    // Constructor to initialize Customer object
    Customer(int a, String b, float c, int d) {
        customerId = a;
        name = b;
        currAmt = c;
        phNo = d;
    }

    // Method to print customer details
    void print() {
        System.out.println("Customer ID\tName\tCurrent Amount\tPhone Number");
        System.out.println(customerId + "\t\t" + name + "\t\t" + currAmt + '\t' + phNo);
    }

    // Method to get current amount
    float getAmt() {
        return currAmt;
    }

    // Method to set current amount
    void setAmt(float incr) {
        currAmt += incr;
    }
}

class NormalCustomer extends Customer {
    private static float credLim = 1000;

    // Constructor to initialize NormalCustomer object
    NormalCustomer(int a, String b, float c, int d) {
        super(a, b, c, d);
    }

    // Method to request a loan for NormalCustomer
    void reqLoan(float incr) {
        if (super.getAmt() + incr <= credLim)
            super.setAmt(incr);
        else
            System.out.println("Limit reached");
        super.print();
    }

    // Method to get the maximum loan limit for NormalCustomer
    float getMax() {
        return credLim - super.getAmt();
    }

    // Method to get the credit limit for NormalCustomer
    static float getCredLim() {
        return credLim;
    }
}

class PriveledgedCustomer extends Customer {
    private static float credLim = 10000;

    // Constructor to initialize PriveledgedCustomer object
    PriveledgedCustomer(int a, String b, float c, int d) {
        super(a, b, c, d);
    }

    // Method to request a loan for PriveledgedCustomer
    void reqLoan(float incr) {
        if (super.getAmt() + incr <= credLim)
            super.setAmt(incr);
        else
            System.out.println("Limit reached");
        super.print();
    }

    // Method to get the maximum loan limit for PriveledgedCustomer
    float getMax() {
        return credLim - super.getAmt();
    }

    // Method to get the credit limit for PriveledgedCustomer
    static float getCredLim() {
        return credLim;
    }
}

class Bank {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int a;String b;float c;int d;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Normal Customer");
            System.out.println("2. Priveledged Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            
            // Read user choice
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(NormalCustomer.getCredLim());
                    System.out.println("Enter customer ID");
                    a=sc.nextInt();
                    System.out.println("Name");
                    b=sc.next();
                    System.out.println("Current Amount");
                    c=sc.nextFloat();
                    System.out.println("Phone Number");
                    d=sc.nextInt();
                    NormalCustomer norm=new NormalCustomer(a,b,c,d);
                    norm.print();
                    System.out.println(norm.getMax());
                    System.out.println("Enter Loan");
                    c=sc.nextFloat();
                    norm.reqLoan(c);
                    norm.print();
                    break;
                case 2:
                    System.out.println(PriveledgedCustomer.getCredLim());
                    System.out.println("Enter customer ID");
                    a=sc.nextInt();
                    System.out.println("Name");
                    b=sc.next();
                    System.out.println("Current Amount");
                    c=sc.nextFloat();
                    System.out.println("Phone Number");
                    d=sc.nextInt();
                    PriveledgedCustomer priv=new PriveledgedCustomer(a,b,c,d);
                    priv.print();
                    System.out.println(priv.getMax());
                    System.out.println("Enter Loan");
                    c=sc.nextFloat();
                    priv.reqLoan(c);
                    priv.print();
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Exiting Bank application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 3);
        
        sc.close(); // Close the scanner to prevent resource leak
    }
}
