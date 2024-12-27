import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Στοιχεία σύνδεσης με τη βάση δεδομένων
    private static final String URL = "jdbc:mysql://localhost:3306/QuestionnaireDB"; 
    private static final String USER = "root";
    private static final String PASSWORD = "Rooney2003g"; 

    // Μέθοδος για σύνδεση
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
