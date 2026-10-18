import java.util.Scanner;

abstract class Travel {
    static final double BOOKING_FEE = 50.0;
    double distance;

    Travel(double distance) {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class Bus extends Travel {
    Bus(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 2.0;
    }
}

class Train extends Travel {
    Train(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return distance * 1.5;
    }
}

class Flight extends Travel {
    Flight(double distance) {
        super(distance);
    }

    double calculateBaseFare() {
        return 2500 + distance * 4.0;
    }
}

public class TravelBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            Travel travel;

            if (mode.equals("BUS")) {
                travel = new Bus(distance);
            } else if (mode.equals("TRAIN")) {
                travel = new Train(distance);
            } else {
                travel = new Flight(distance);
            }

            double fare = travel.calculateTotalFare();
            System.out.printf("%s: %.2f%n", mode, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}