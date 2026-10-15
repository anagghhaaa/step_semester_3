import java.util.Scanner;

abstract class Room {
    protected double units;

    Room(double units) {
        this.units = units;
    }

    abstract double calculateBill();
}

class Single extends Room {

    Single(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 8;
    }
}

class Shared extends Room {
    private int occupants;

    Shared(double units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    double calculateBill() {
        return (units * 6) / occupants;
    }
}

class AC extends Room {

    AC(double units) {
        super(units);
    }

    double calculateBill() {
        return units * 10 + 200;
    }
}

public class HostelElectricityBill {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double units = sc.nextDouble();

            Room room;

            if (type.equals("SINGLE")) {
                room = new Single(units);
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                room = new Shared(units, occupants);
            } else {
                room = new AC(units);
            }

            double bill = room.calculateBill();

            System.out.printf("%s: %.2f%n", type, bill);

            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
