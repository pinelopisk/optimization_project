import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class KMeansTest {

    public static String DB_URL = "jdbc:mysql://localhost:3306/QuestionnaireDB";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "password";
    
    private Connection connectToDatabase() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Test
    void testKMeansClusteringFromDatabase() {
        try (Connection conn = connectToDatabase()) {
            String sql = "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 " +
                         "FROM responses";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                List<int[]> answersList = new ArrayList<>();
                while (rs.next()) {
                    int[] answers = new int[20];
                    for (int i = 0; i < 20; i++) {
                        answers[i] = rs.getInt("q" + (i + 1));
                    }
                    answersList.add(answers);
                }

                assertTrue(answersList.size() > 0, "Δεν βρέθηκαν δεδομένα μαθητών");
                int[][] answers = answersList.toArray(new int[0][0]);
                int k = answersList.size() / 2; 
                int[][] centroids = new int[k][20]; // 20 ερωτήσεις
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < 20; j++) {
                        centroids[i][j] = (int) (Math.random() * 5) + 1;
                    }
                }

                List<List<Integer>> clusters = Kmeans.kMeansClustering(answers, centroids, k, 20);
                assertTrue(clusters.size() > 0, "Πρέπει να δημιουργηθούν ομάδες");
                for (List<Integer> cluster : clusters) {
                    assertTrue(cluster.size() > 0, "Μία ομάδα δεν περιέχει κανέναν μαθητή");
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Η σύνδεση με τη βάση ή η εκτέλεση του ερωτήματος απέτυχε.");
        }
    }

    @Test
    void testCalculateDistance() {
        try (Connection conn = connectToDatabase()) {
            String sql = "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 " +
                         "FROM responses";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                
                List<int[]> answersList = new ArrayList<>();
                while (rs.next()) {
                    int[] answers = new int[20]; 
                    for (int i = 0; i < 20; i++) {
                        answers[i] = rs.getInt("q" + (i + 1));
                    }
                    answersList.add(answers);
                }
                
                assertTrue(answersList.size() > 1, "Δεν υπάρχουν αρκετά δεδομένα μαθητών για να υπολογίσουμε απόσταση");
                int[] student1 = answersList.get(0);
                int[] student2 = answersList.get(1);

                double distance = Kmeans.calculateDistance(student1, student2);

                // Έλεγχος ότι η απόσταση υπολογίζεται σωστά
                assertTrue(distance >= 0, "Η απόσταση πρέπει να είναι θετική ή μηδέν");
            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Η σύνδεση με τη βάση ή η εκτέλεση του ερωτήματος απέτυχε.");
        }
    }

    @Test
    void testAreEqual() {
        try (Connection conn = connectToDatabase()) {
            String sql = "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 " +
                         "FROM responses";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                
                List<int[]> answersList = new ArrayList<>();
                while (rs.next()) {
                    int[] answers = new int[20];
                    for (int i = 0; i < 20; i++) {
                        answers[i] = rs.getInt("q" + (i + 1));
                    }
                    answersList.add(answers);
                }
                assertTrue(answersList.size() > 1, "Δεν υπάρχουν αρκετά δεδομένα μαθητών για σύγκριση");
                int[] student1 = answersList.get(0);
                int[] student2 = answersList.get(0);
                boolean result = Kmeans.areEqual(student1, student2);
                assertTrue(result, "Τα δεδομένα πρέπει να είναι ίδια");

            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Η σύνδεση με τη βάση ή η εκτέλεση του ερωτήματος απέτυχε.");
        }
    }

    @Test
    void testRebalanceClusters() {
        try (Connection conn = connectToDatabase()) {
            String sql = "SELECT q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 " +
                         "FROM responses";
            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                List<int[]> answersList = new ArrayList<>();
                while (rs.next()) {
                    int[] answers = new int[20]; // 20 ερωτήσεις
                    for (int i = 0; i < 20; i++) {
                        answers[i] = rs.getInt("q" + (i + 1));
                    }
                    answersList.add(answers);
                }

                assertTrue(answersList.size() > 0, "Δεν υπάρχουν αρκετά δεδομένα μαθητών");
                int k = answersList.size() / 2;
                int[][] centroids = new int[k][20];
                for (int i = 0; i < k; i++) {
                    for (int j = 0; j < 20; j++) {
                        centroids[i][j] = (int) (Math.random() * 5) + 1;
                    }
                }
                List<List<Integer>> clusters = Kmeans.kMeansClustering(answersList.toArray(new int[0][0]), centroids, k, 20);
                List<List<Integer>> rebalancedClusters = Kmeans.rebalanceClusters(clusters, answersList.size(), k);
                assertTrue(rebalancedClusters.size() > 0, "Πρέπει να υπάρχουν ανακατανεμημένες ομάδες");
                assertTrue(rebalancedClusters.size() == clusters.size(), "Η ανακατανομή πρέπει να έχει το ίδιο μέγεθος ομάδων");

            }
        } catch (Exception e) {
            e.printStackTrace();
            fail("Η σύνδεση με τη βάση ή η εκτέλεση του ερωτήματος απέτυχε.");
        }
    }
}



