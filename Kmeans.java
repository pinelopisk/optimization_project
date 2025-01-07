package GroupifyJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
 

 
public class Kmeans {
 
    public static String DB_URL = "jdbc:mysql://localhost:3306/QuestionnaireDB";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "Rooney2003g";
 
    public static void main(String[] args) {
        String prof_mail = "";
        int st_n = 0;
        int n_o_s = 0;
        int k = st_n/n_o_s;
        int q_n = 20;

        List<String[]> mainList = new ArrayList<>();
        List<int[]> answersList = new ArrayList<>();
 
        try (Connection conn = connectToDatabase()) {
           
            String sqlProfessor = "SELECT email, foitites, arithmos_atomwn FROM professors LIMIT 1";
            try (PreparedStatement stmt = conn.prepareStatement(sqlProfessor);
                 ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    prof_mail = rs.getString("email");
                    st_n = rs.getInt("foitites");
                    n_o_s = rs.getInt("arithmos_atomwn");
                }
            }
 
            String sqlResponses = "SELECT name, surname, am, q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15, q16, q17, q18, q19, q20 FROM responses";
            try (PreparedStatement stmt = conn.prepareStatement(sqlResponses);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String surname = rs.getString("surname");
                    String am = rs.getString("am");
                    mainList.add(new String[]{name, surname, am});
 
                    int[] answers = new int[20];
                    for (int i = 0; i < 20; i++) {
                        answers[i] = rs.getInt("q" + (i + 1));
                    }
                    answersList.add(answers);
                }
            }
 
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        
       
    
 
        
        
        Random random = new Random();
        int[][] centroids = new int[k][q_n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < q_n; j++) {
                centroids[i][j] = random.nextInt(5) + 1;
            }
        }
 
 
        int[][] answers = answersList.toArray(new int[0][0]);
 
        List<List<Integer>> clusters = kMeansClustering(answers, centroids, k, q_n);
        clusters = rebalanceClusters(clusters, st_n, k);
        System.out.println("Team results:");
        System.out.println("Total teams: " + clusters.size());
        for (int i = 0; i < clusters.size(); i++) {
            System.out.print("team " + (i + 1) + ": ");
            for (Integer studentIndex : clusters.get(i)) {
                // Εκτύπωση του ονόματος, επωνύμου και κωδικού μαθητή
                String[] student = mainList.get(studentIndex);
                System.out.print(student[0] + " " + student[1] + " (" + student[2] + "), ");
            }
            System.out.println();
        }
        
    }
 
    public static Connection connectToDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
   
    
 
    public static List<List<Integer>> kMeansClustering(int[][] answers, int[][] centroids, int k, int q_n) {
        int numStudents = answers.length;
        boolean converged = false;
        List<List<Integer>> clusters = new ArrayList<>();
 
        while (!converged) {
            clusters = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                clusters.add(new ArrayList<>());
            }
 
            for (int i = 0; i < numStudents; i++) {
                int closestCentroidIndex = 0;
                double minDistance = calculateDistance(answers[i], centroids[0]);
 
                for (int j = 1; j < k; j++) {
                    double distance = calculateDistance(answers[i], centroids[j]);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestCentroidIndex = j;
                    }
                }
 
                clusters.get(closestCentroidIndex).add(i);
            }
 
            int[][] newCentroids = new int[k][q_n];
            for (int i = 0; i < k; i++) {
                List<Integer> cluster = clusters.get(i);
                if (!cluster.isEmpty()) {
                    for (int studentIndex : cluster) {
                        for (int j = 0; j < q_n; j++) {
                            newCentroids[i][j] += answers[studentIndex][j];
                        }
                    }
                    for (int j = 0; j < q_n; j++) {
                        newCentroids[i][j] /= cluster.size();
                    }
                } else {
                    newCentroids[i] = centroids[i];
                }
            }
 
            converged = true;
            for (int i = 0; i < k; i++) {
                if (!areEqual(centroids[i], newCentroids[i])) {
                    converged = false;
                    break;
                }
            }
            centroids = newCentroids;
        }
 
        return clusters;
    }
 
    public static double calculateDistance(int[] student1, int[] student2) {
        double sum = 0;
        for (int i = 0; i < student1.length; i++) {
            sum += Math.pow(student1[i] - student2[i], 2);
        }
        return Math.sqrt(sum);
    }
 
    public static boolean areEqual(int[] centroid1, int[] centroid2) {
        for (int i = 0; i < centroid1.length; i++) {
            if (centroid1[i] != centroid2[i]) {
                return false;
            }
        }
        return true;
    }
    public static List<List<Integer>> rebalanceClusters(List<List<Integer>> clusters, int st_n, int n_o_s) {
        List<List<Integer>> rebalancedClusters = new ArrayList<>();
    
        
        for (int i = 0; i < n_o_s; i++) {
            rebalancedClusters.add(new ArrayList<>());
        }
    
        int groupIndex = 0;
        for (List<Integer> cluster : clusters) {
            for (Integer studentIndex : cluster) {
                rebalancedClusters.get(groupIndex).add(studentIndex);
                groupIndex = (groupIndex + 1) % n_o_s;
            }
        }
    
        return rebalancedClusters;
    }
    
    
    }
 
