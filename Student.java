import java.time.LocalDate;

public class Student {
    private String name;
    private String id;
    private int seatNumber;
    private LocalDate registrationDate;

    public Student(String name, String id, int seatNumber, LocalDate registrationDate) {
        this.name = name;
        this.id = id;
        this.seatNumber = seatNumber;
        this.registrationDate = registrationDate;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }
}
