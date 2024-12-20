import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.*;

public class MainMethod {
    public static void main(String[] args) {
        List<Students> students = RetrieveData.getStudents();
        String prof_mail;
        int st_n;
        int t_n;
        int k = t_n;
        int q_n = 20;
        Random random = new Random();
        String[][] mainmatrix = new String[(st_n)][(t_n) + 4];
        int[][] centroids = new int[k][q_n];
        String[][] credentials = extractCredentials(mainmatrix, st_n);
        int[][] answers = extractAnswers(mainmatrix, st_n, q_n);
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < q_n; j++) {
                centroids[i][j] = random.nextInt(5) + 1;
            }
        }
        List<List<Integer>> clusters = kMeansClustering(answers, centroids, k, q_n);
        String results = formatClusters(clusters, credentials);
        String subject = "Clustering results";
        String recipient = prof_mail;
        sendEmail(recipient, subject, results);
    }

    public static String[][] extractCredentials(String[][] matrix, int x) {
        String[][] credentials = new String[x][4];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 3; j++) {
                credentials[i][j] = matrix[i][j];
            }
        }
        return credentials;
    }

    public static int[][] extractAnswers(String[][] matrix, int z, int y) {
        int[][] answers = new int[z][y];
        for (int i = 0; i < z; i++) {
            for (int j = 3; j < matrix.length; j++) {
                answers[i][j] = Integer.parseInt(matrix[i][j]);
            }
        }
        return answers;
    }

    public static String formatClusters(List<List<Integer>> clusters, String[][] credentials) {
        StringBuilder sb = new StringBuilder();
        sb.append("Clustering Results: \n");
        for (int i = 0; i < clusters.size(); i++) {
            sb.append("Team ").append(i + 1).append(":\n");
            for (int studentIndex : clusters.get(i)) {
                for (String value : credentials[studentIndex]) {
                    sb.append(value).append("\t");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void sendEmail(String recipient, String subject, String messageBody) {
        final String senderEmail = "groupify.9@gmail.com";
        final String senderPassword = "123456789.groupify";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
        message.setSubject(subject);
        message.setText(messageBody);
        Transport.send(message);
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
}
