import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Student implements Serializable {
    private int roll;
    private String name;
    private double score;

    public Student(int roll, String name, double score) {
        this.roll = roll;
        this.name = name;
        this.score = score;
    }

    public int getRoll() {
        return roll;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

class jtest {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", 85.5));
        students.add(new Student(2, "Bob", 75.3));
        students.add(new Student(3, "Charlie", 90.0));

        // Write objects to file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("students.dat"))) {
            for (Student student : students) {
                outputStream.writeObject(student);
            }
            System.out.println("Objects written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read objects from file
        List<Student> readStudents = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("students.dat"))) {
            while (true) {
                try {
                    Student student = (Student) inputStream.readObject();
                    readStudents.add(student);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Display read objects
        System.out.println("Objects read from file:");
        for (Student student : readStudents) {
            System.out.println(student);
        }
    }
}
