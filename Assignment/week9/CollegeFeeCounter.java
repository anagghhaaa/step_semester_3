import java.util.Scanner;

abstract class Student {
    static final double TUITION_FEE = 40000;
    static final double TRANSPORT_FEE = 12000;

    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double calculateFee();
}

interface BusUser {
    double getTransportFee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return TUITION_FEE + getTransportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double calculateFee() {
        return TUITION_FEE + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    public double getTransportFee() {
        return TRANSPORT_FEE;
    }

    double calculateFee() {
        return (TUITION_FEE / 2) + getTransportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            Student student;

            if (type.equals("DAY_SCHOLAR")) {
                student = new DayScholar(name);
            } else if (type.equals("HOSTELLER")) {
                student = new Hosteller(name);
            } else {
                student = new Scholar(name);
            }

            double fee = student.calculateFee();

            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}