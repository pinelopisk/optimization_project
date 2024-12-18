import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Ανάκτηση των δεδομένων των μαθητών
        List<Student> students = RetrieveData.getStudents();

        // Εμφάνιση των δεδομένων
        System.out.println("Students' Data:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
