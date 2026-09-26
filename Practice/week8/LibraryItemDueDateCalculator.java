import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;
    protected LocalDate currentDate;

    LibraryItem(String title, LocalDate currentDate) {
        this.title = title;
        this.currentDate = currentDate;
    }

    abstract LocalDate calculateDueDate();
}

class Book extends LibraryItem {

    Book(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {

    DVD(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title, LocalDate currentDate) {
        super(title, currentDate);
    }

    LocalDate calculateDueDate() {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String title = sc.nextLine().trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title, currentDate);
            } else if (type.equals("DVD")) {
                item = new DVD(title, currentDate);
            } else {
                item = new Magazine(title, currentDate);
            }

            System.out.println(title + ": " + item.calculateDueDate());
        }

        sc.close();
    }
}
