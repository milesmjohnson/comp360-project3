import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * RegistrationSystem class for managing student registrations
 * and handling exceptions related to class capacity.
 */
public class RegistrationSystem {
    private final int MAX_SEATS = 30;
    private boolean[] seats;
    private String[] registrationDates;
    private String[] studentIds;
    private String[] studentNames;


    // Constructor for RegistrationSystem
    public RegistrationSystem() {
        seats = new boolean[MAX_SEATS];
        registrationDates = new String[MAX_SEATS];
        studentIds = new String[MAX_SEATS];
        studentNames = new String[MAX_SEATS];

        // Initialize all seats to false (unoccupied)
        for (int i = 0; i < MAX_SEATS; i++) {
            seats[i] = false;
        }
    }

    // Check if the class is full
    public boolean isClassRoomFull() {
        for (boolean seat : seats) {
            if (!seat) {
                return false;
            }
        }

        // All seats are occupied
        return true;
    }

    // Register a student
    public int register(String studentName, String studentId) throws ClassFullException{
        // Get current date
        LocalDate currentDate = LocalDate.now();
        String date = currentDate.format(DateTimeFormatter.ofPattern("d"));
        String month = currentDate.format(DateTimeFormatter.ofPattern("MMMM"));

        // Check if class is full
        if (isClassRoomFull()) {
            throw new ClassFullException(date, month);
            
        }

        // Find the first available seat
        int seatNum = - 1;
        for (int i = 0; i < seats.length;i++) {
            if (!seats[i]) {
                seats[i] = true;
                registrationDates[i] = month + " "+ date;
                studentNames[i] = studentName;
                studentIds[i] = studentId;
                seatNum = i + 1; // adding 1 to make it 1-indexed
                break;
            }
        }

        // Display Registration details
        System.out.println("Registration successful!");
        System.out.println("Student: " + studentName + " (ID: " + studentId + ")");
        System.out.println("Seat Number: " + seatNum);
        System.out.println("Registration Date: " + month + " "+ date);

        return seatNum;
    }

    // Cancel registration
    public boolean cancelRegistration(int seatNum) {
        // Check if seat number is valid
        if (seatNum < 1 || seatNum > MAX_SEATS) {
            System.out.println("Invalid seat number. Must be between 1 and " + MAX_SEATS);
            return false;
            }
        

        // Check if seat is already occupied
        int index = seatNum -1;
        if (!seats[index]) {
            System.out.println("Seat: " + seatNum + " is not currently registered.");
            return false;
        }

        // Cancel registration
        String studentName = studentNames[index];
        seats[index] = false;
        studentNames[index] = null;
        studentIds[index] = null;
        registrationDates[index] = null;

        System.out.println("Registration canceled for " + studentName+ " (Seat " + seatNum + ")");
        System.out.println("Seat Number: " + seatNum + " is now available.");

        return true;
    }

    // Getters for current number of registered students
    public int getRegisteredCount() {
        int count = 0;
        for (boolean seat : seats) {
            if (seat) {
                count++;
            }
        }
        return count;
    }

    // Getters for current number of available seats
    public int getAvailableSeats() {
        return MAX_SEATS - getRegisteredCount();
    }

    // Getters for the name of students in a specific seat
    public String getStudentName(int seatNum) {
        if (seatNum < 1 || seatNum > MAX_SEATS) {
            return null;
        }
        
        return studentNames[seatNum - 1];
    }

    // Check if specifc seat is occupied
    public boolean isSeatOccupied(int seatNum) {
        if (seatNum < 1 || seatNum > MAX_SEATS) {
            return false;
        }

        return seats[seatNum - 1];
    }

    // Get the seat number for a student by ID
    public int  findSeatByStudentId(String studentId) {
        for (int i = 0;  i < MAX_SEATS; i++) {
            if (seats[i] && studentIds[i] != null && studentIds[i].equals(studentId)) {
                return i + 1; // Return 1-indexed seat number
            }
        }
        return -1; // Not found
    }

    // Get the max number of seats
    public int getMaxSeats() {
        return MAX_SEATS;
    }

    // An array of all seats seat statuses
    public boolean[] getAllSeatStatuses() {
        return seats;
    }


    
}