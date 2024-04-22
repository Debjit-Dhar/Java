import java.io.*;
import java.util.*;

class MainClass {
    public static void main(String args[]) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StudentBF studentBF = new StudentBF();

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Delete Student File");
            System.out.println("6. Exit");
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
                    try {
                        System.out.print("Enter roll number to search: ");
                        int rollToSearch = Integer.parseInt(reader.readLine());
                        long position = studentBF.search(rollToSearch);
                        if (position != -1)
                            System.out.println("Student found at position: " + position);
                        else
                            System.out.println("Student not found.");
                    } catch (IOException | NumberFormatException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.print("Enter roll number to delete: ");
                        int rollToDelete = Integer.parseInt(reader.readLine());
                        studentBF.logicalDeletion(rollToDelete);
                        System.out.println("Student deleted successfully!");
                    } catch (IOException | ClassNotFoundException | NumberFormatException e) {
                        System.out.println("Error occurred: " + e.getMessage());
                    }
                    break;
                case 5:
                    if (studentBF.deleteFile())
                        System.out.println("Student file deleted successfully!");
                    else
                        System.out.println("Student file not found.");
                    break;
                case 6:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        } while (choice != 6);

        try {
            reader.close();
        } catch (IOException e) {
            System.out.println("Error closing reader: " + e.getMessage());
        }
    }
}

class Student implements Serializable {
    private int roll;
    private String name;
    private float cgpa;

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
        FileOutputStream fout = new FileOutputStream("Student Binary File.dat", true);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(s);
        oout.close();
    }

    public void read() throws IOException, ClassNotFoundException {
        FileInputStream fin = new FileInputStream("Student Binary File.dat");
        ObjectInputStream oin = new ObjectInputStream(fin);
        try {
            while (true) {
                Student s = (Student) oin.readObject();
                if (s != null && s.getRoll() != -1)
                    s.display();
            }
        } catch (EOFException e) {
            // End of file reached, do nothing
        } finally {
            oin.close();
        }
    }

    public long search(int r) throws IOException {
        RandomAccessFile ra = new RandomAccessFile("Student Binary File.dat", "rw");
        long n = ra.length() / 8;
        for (long i = 0; i < n; i++) {
            ra.seek(i * 8);
            int x = ra.readInt();
            if (x == r) {
                ra.close();
                return i;
            }
        }
        ra.close();
        return -1;
    }

    public void logicalDeletion(int r) throws IOException, ClassNotFoundException {
        RandomAccessFile ra = new RandomAccessFile("Student Binary File.dat", "rw");
        ra.seek(search(r) * 8);
        ra.writeInt(-1);
        ra.close();
    }

    public boolean deleteFile() {
        File f = new File("Student Binary File.dat");
        if (f.exists()) {
            f.delete();
            return true;
        }
        return false;
    }
}
