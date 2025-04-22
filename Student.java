public class Student {
    private String name;
    private String id;

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    // Optional: Useful for printing
    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
