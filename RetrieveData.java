import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students"; // Επιλέγουμε όλα τα δεδομένα

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            // Ανάκτηση των μεταδεδομένων για να βρούμε τις στήλες "answerX"
            ResultSetMetaData metaData = rs.getMetaData();
            List<String> answerColumns = new ArrayList<>();

            // Εύρεση των στηλών που ξεκινούν με "answer"
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                if (columnName.startsWith("answer")) {
                    answerColumns.add(columnName);
                }
            }

            // Ανάκτηση δεδομένων ανά μαθητή
            while (rs.next()) {
                String name = rs.getString("name");
                int am = rs.getInt("am");

                // Ανάκτηση των απαντήσεων δυναμικά
                List<Integer> answers = new ArrayList<>();
                for (String col : answerColumns) {
                    answers.add(rs.getInt(col));
                }

                // Δημιουργία αντικειμένου Student και προσθήκη στη λίστα
                students.add(new Student(name, am, answers));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}
