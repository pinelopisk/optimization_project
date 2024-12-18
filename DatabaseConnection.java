import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Στοιχεία σύνδεσης με τη βάση δεδομένων
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name"; // Άλλαξε το όνομα της βάσης
    private static final String USER = "root"; // Το username σου για τη βάση
    private static final String PASSWORD = "password"; // Ο κωδικός σου για τη βάση

    // Μέθοδος για σύνδεση
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
