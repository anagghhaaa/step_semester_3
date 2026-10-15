import java.util.Scanner;

abstract class Cab {
    static final double MINIMUM_FARE = 100;
    double distance;

    Cab(double distance) {
        this.distance = distance;
    }

    abstract double calculateFare();

    double applyMinimumFare(double fare) {
        return Math.max(fare, MINIMUM_FARE);
    }
}

interface NightService {
    double applyNightCharge(double fare);
}

class Mini extends Cab {
    Mini(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 10);
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 14);
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

class SUV extends Cab implements NightService {
    SUV(double distance) {
        super(distance);
    }

    double calculateFare() {
        return applyMinimumFare(distance * 18);
    }

    public double applyNightCharge(double fare) {
        return fare * 1.20;
    }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                if (time.equals("NIGHT")) {
                    System.out.println("MINI: night service not available");
                    continue;
                }
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            double fare = cab.calculateFare();

            if (time.equals("NIGHT") && cab instanceof NightService) {
                fare = ((NightService) cab).applyNightCharge(fare);
            }

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}