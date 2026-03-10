import java.util.*;

class Attendance {

    int id;
    String studentName;
    String rollNumber;
    String courseName;
    String date;
    String status;

    Attendance(int id, String studentName, String rollNumber, String courseName, String date, String status) {
        this.id = id;
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.courseName = courseName;
        this.date = date;
        this.status = status;
    }

    public String toString() {
        return id + " | " + studentName + " | " + rollNumber + " | " + courseName + " | " + date + " | " + status;
    }
}

public class AttendanceConsoleApp {

    static ArrayList<Attendance> records = new ArrayList<>();
    static int idCounter = 1;

    static Scanner sc = new Scanner(System.in);

    public static void addAttendance() {

        System.out.print("Student Name: ");
        String name = sc.nextLine();

        System.out.print("Roll Number: ");
        String roll = sc.nextLine();

        System.out.print("Course Name: ");
        String course = sc.nextLine();

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Status (Present/Absent): ");
        String status = sc.nextLine();

        Attendance a = new Attendance(idCounter++, name, roll, course, date, status);

        records.add(a);

        System.out.println("Attendance Added!");
    }

    public static void viewAttendance() {

        for (Attendance a : records) {
            System.out.println(a);
        }
    }

    public static void deleteAttendance() {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        records.removeIf(a -> a.id == id);

        System.out.println("Deleted!");
    }

    public static void searchAttendance() {

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        for (Attendance a : records) {
            if (a.studentName.toLowerCase().contains(name.toLowerCase())) {
                System.out.println(a);
            }
        }
    }

    public static void main(String[] args) {

        while (true) {

            System.out.println("\nAttendance Management System");

            System.out.println("1. Add Attendance");
            System.out.println("2. View Attendance");
            System.out.println("3. Delete Attendance");
            System.out.println("4. Search Attendance");
            System.out.println("5. Exit");

            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addAttendance();
                    break;

                case 2:
                    viewAttendance();
                    break;

                case 3:
                    deleteAttendance();
                    break;

                case 4:
                    searchAttendance();
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}