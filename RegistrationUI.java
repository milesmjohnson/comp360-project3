import java.util.Scanner;

public class RegistrationUI {
    public static void main(String[] args) {
        RegistrationSystem system = new RegistrationSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n==== COMP 360 Registration System ====");
            System.out.println("1. Register a student");
            System.out.println("2. Cancel registration");
            System.out.println("3. View registered count");
            System.out.println("4. View available seats");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter student ID: ");
                    String id = scanner.nextLine();

                    try {
                        system.register(name, id);
                    } catch (ClassFullException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter seat number to cancel: ");
                    int seatNum = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    system.cancelRegistration(seatNum);
                    break;

                case 3:
                    System.out.println("Registered students: " + system.getRegisteredCount());
                    break;

                case 4:
                    System.out.println("Available seats: " + system.getAvailableSeats());
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Registration System.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}
