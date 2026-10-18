import java.util.Scanner;

class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int sum = 0;

        for (int mark : marks) {
            sum += mark;
        }

        return (double) sum / marks.length;
    }

    char calculateGrade(double average) {
        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void display() {
        double average = calculateAverage();
        char grade = calculateGrade(average);

        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(), average, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 2; i++) {
            String name = sc.next();
            int[] marks = new int[3];

            for (int j = 0; j < 3; j++) {
                marks[j] = sc.nextInt();
            }

            Student student = new Student(name, marks);
            student.display();
        }

        sc.close();
    }
}