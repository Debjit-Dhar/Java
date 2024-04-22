
import java.io.*;
import java.util.*;
class Student implements Serializable {
    private int roll;
    private String name;
    private float cgpa;
    public Student(){}
    public Student(int a, String b, float c) {
        roll = a;
        name = b;
        cgpa = c;
    }

    public Student(Student s) {
        this.roll = s.roll;
        this.name = s.name;
        this.cgpa = s.cgpa;
    }

    public void display() {
        System.out.println("Roll No= " + roll + " Name= " + name + " CGPA =" + cgpa);
    }

    public int getRoll() {
        return roll;
    }
}

class StudentBF {
    public void write(Student s) throws IOException {
        FileOutputStream fout = new FileOutputStream("Student File.dat", true);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(s);
        oout.flush();
        oout.close();
    }
    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("Student File.dat");
        ObjectInputStream oin=null;

        try {
            while (true) {
            oin = new ObjectInputStream(fin);

                Student s = (Student) oin.readObject();
                s.display(); // Displaying each student
            }
        } catch (EOFException e) {
            // End of file reached
            System.out.println("End of file reached.");
        } finally {
            oin.close();
        }
    }
   
}
class StudentClass {
    public static void main(String args[]) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StudentBF studentBF = new StudentBF();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3 to exit");
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
                        Student s = new Student(roll, name, cgpa);
                        studentBF.write(s);
                        System.out.println("Student added successfully!");
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        studentBF.read();
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error occurred while reading from file: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 3);

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing reader: " + e.getMessage());
        }
    }
}