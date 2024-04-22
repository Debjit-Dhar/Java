import java.util.Scanner;
class Stack<T>
{
    private T[] stack;
    private int size;
    private int top;
    @SuppressWarnings("unchecked")
    public Stack(int s)
    {
        size=s;
        stack= (T[]) new Object[size];
        //stack=new T[size];
        top=-1;
    }
    public int push(T item)
    {
        if(top<size-1)
        {
            stack[++top]=item;
            return top;
        }
        return -1;
    }
    public T pop()
    {
        if(top==-1)
            return  null;//return null for object type
            else
                return stack[top--];
   }

    public int getTop()
    {
        return top;
    }
}
class TestStack {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();
        Stack<Integer> s = new Stack<Integer>(size);

        int choice;
        do {
            System.out.println("\nStack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int elementToPush = scanner.nextInt();
                    int pushedIndex = s.push(elementToPush);
                    if (pushedIndex != -1) {
                        System.out.println("Element " + elementToPush + " pushed at index " + pushedIndex);
                    } else {
                        System.out.println("Stack Overflow");
                    }
                    break;
                case 2:
                    Integer poppedElement = s.pop();
                    if (poppedElement != null) {
                        System.out.println("Popped element: " + poppedElement);
                    } else {
                        System.out.println("Stack Undeflow");
                    }
                    break;
                case 3:
                    if(s.getTop() == -1){
                        System.out.println("The Stack is Empty.");
                        break;
                    }
                    System.out.println("Stack elements:");
                    s.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}