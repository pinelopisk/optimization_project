public class Professor {
    private String email;
    private int numberOfStudents;
    private int registeredStudents;

    // Constructor
    public Professor(String email, int numberOfStudents, int registeredStudents) {
        this.email = email;
        this.numberOfStudents = numberOfStudents;
        this.registeredStudents = registeredStudents;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "email='" + email + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
