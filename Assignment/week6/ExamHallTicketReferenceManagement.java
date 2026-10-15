class HallTicket {

    String studentName;
    int seatNumber;

    HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketReferenceManagement {

    public static void main(String[] args) {

        HallTicket priya = new HallTicket("Priya", 30);

        HallTicket copy = priya;

        copy.seatNumber = 45;

        System.out.println("Student: " + priya.studentName);
        System.out.println("Seat Number: " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);

        System.out.println("separate == priya: " + (separate == priya));
    }
}
