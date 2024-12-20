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

            ResultSetMetaData metaData = rs.getMetaData();
            List<String> answerColumns = new ArrayList<>();

            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String columnName = metaData.getColumnName(i);
                if (columnName.startsWith("answer")) {
                    answerColumns.add(columnName);
                }
            }

            while (rs.next()) {
                String name = rs.getString("name");
                int am = rs.getInt("am");

                List<Integer> answers = new ArrayList<>();
                for (String col : answerColumns) {
                    answers.add(rs.getInt(col));
                }

                students.add(new Student(name, am, answers));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }
}
