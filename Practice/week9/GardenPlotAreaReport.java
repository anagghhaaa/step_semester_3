import java.util.Scanner;

abstract class Plot {
    abstract double calculateArea();
}

class Circle extends Plot {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    double calculateArea() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();

            Plot plot;

            if (type.equals("CIRCLE")) {
                plot = new Circle(sc.nextDouble());
            } else if (type.equals("RECTANGLE")) {
                double length = sc.nextDouble();
                double width = sc.nextDouble();
                plot = new Rectangle(length, width);
            } else {
                double base = sc.nextDouble();
                double height = sc.nextDouble();
                plot = new Triangle(base, height);
            }

            double area = plot.calculateArea();
            System.out.printf("%s (%s): %.2f%n", owner, type, area);
            total += area;
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}