import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class RetrieveData {

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM responses";

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String am = rs.getString("am");

                List<Integer> answers = new ArrayList<>();
                for (int i = 4; i <= 23; i++) {
                    answers.add(rs.getInt(i));
                }

                students.add(new Student(name, surname, am, answers));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

    public static Professor getProfessorData() {
        String sql = "SELECT email, arithmos_atomwn FROM professors LIMIT 1";
        int registeredStudents = 0;

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM responses");
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                registeredStudents = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try (Connection conn = DatabaseConnection.connect();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                String email = rs.getString("email");
                int numberOfTeams = rs.getInt("arithmos_omadon");

                return new Professor(email, numberOfStudents, registeredStudents);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
