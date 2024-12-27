public class Professor {
    private String email;
    private int numberOfTeams;
    private int registeredStudents;

    // Constructor
    public Professor(String email, int numberOfTeams, int registeredStudents) {
        this.email = email;
        this.numberOfTeams = numberOfTeams;
        this.registeredStudents = registeredStudents;
    }

    // Getters
    public String getEmail() {
        return email;
    }

    public int getNumberOfTeams() {
        return numberOfTeams;
    }

    public int getRegisteredStudents() {
        return registeredStudents;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "email='" + email + '\'' +
                ", numberOfTeams=" + numberOfTeams +
                ", registeredStudents=" + registeredStudents +
                '}';
    }
}
