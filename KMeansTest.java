package GroupifyJava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KmeansTest {

    private Kmeans kmeans;

    @BeforeEach
    public void setUp() {
        kmeans = new Kmeans();
    }

    @Test
    public void testDatabaseConnection() {
        try {
            Connection conn = Kmeans.connectToDatabase();
            assertNotNull(conn, "Η σύνδεση στη βάση δεδομένων πρέπει να είναι επιτυχής.");
            conn.close();
        } catch (Exception e) {
            fail("Η σύνδεση στη βάση δεδομένων απέτυχε με εξαίρεση: " + e.getMessage());
        }
    }

    @Test
    public void testCalculateDistance() {
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {5, 4, 3, 2, 1};

        double expectedDistance = Math.sqrt(40);
        double actualDistance = Kmeans.calculateDistance(student1, student2);

        assertEquals(expectedDistance, actualDistance, 0.0001, "Η απόσταση πρέπει να υπολογίζεται σωστά.");
    }

    @Test
    public void testCalculateDistanceWithIdenticalAnswers() {
        int[] student1 = {3, 3, 3};
        int[] student2 = {3, 3, 3};

        double expectedDistance = 0.0;
        double actualDistance = Kmeans.calculateDistance(student1, student2);

        assertEquals(expectedDistance, actualDistance, 0.0001, "Η απόσταση δύο ίδιων απαντήσεων πρέπει να είναι 0.");
    }

    @Test
    public void testAreEqual() {
        int[] centroid1 = {1, 2, 3, 4, 5};
        int[] centroid2 = {1, 2, 3, 4, 5};
        int[] centroid3 = {5, 4, 3, 2, 1};

        assertTrue(Kmeans.areEqual(centroid1, centroid2), "Τα δύο κέντρα πρέπει να θεωρούνται ίσα.");
        assertFalse(Kmeans.areEqual(centroid1, centroid3), "Τα δύο κέντρα πρέπει να θεωρούνται διαφορετικά.");
    }

    @Test
    public void testKMeansClustering() {
        int[][] answers = {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1},
            {1, 1, 1, 1, 1},
            {5, 5, 5, 5, 5}
        };

        int[][] centroids = {
            {1, 2, 3, 4, 5},
            {5, 4, 3, 2, 1}
        };

        int k = 2;
        int q_n = 5;

        List<List<Integer>> clusters = Kmeans.kMeansClustering(answers, centroids, k, q_n);

        assertEquals(k, clusters.size(), "Ο αριθμός των ομάδων πρέπει να είναι ίσος με k.");
        assertFalse(clusters.get(0).isEmpty(), "Η πρώτη ομάδα δεν πρέπει να είναι κενή.");
        assertFalse(clusters.get(1).isEmpty(), "Η δεύτερη ομάδα δεν πρέπει να είναι κενή.");
        int totalStudents = Arrays.stream(answers).length;
        int assignedStudents = clusters.stream().mapToInt(List::size).sum();
        assertEquals(totalStudents, assignedStudents, "Όλοι οι φοιτητές πρέπει να ανήκουν σε ομάδες.");
    }

    @Test
    public void testRebalanceClusters() {
        List<List<Integer>> clusters = new ArrayList<>();
        clusters.add(Arrays.asList(0, 1));
        clusters.add(Arrays.asList(2, 3));

        int st_n = 4;
        int n_o_s = 2;

        List<List<Integer>> rebalancedClusters = Kmeans.rebalanceClusters(clusters, st_n, n_o_s);

        assertEquals(n_o_s, rebalancedClusters.size(), "Ο αριθμός των ομάδων πρέπει να είναι ίσος με n_o_s.");
        for (List<Integer> cluster : rebalancedClusters) {
            assertFalse(cluster.isEmpty(), "Καμία ομάδα δεν πρέπει να είναι κενή.");
        }
        
        int maxSize = rebalancedClusters.stream().mapToInt(List::size).max().orElse(0);
        int minSize = rebalancedClusters.stream().mapToInt(List::size).min().orElse(0);
        assertTrue(maxSize - minSize <= 1, "Οι ομάδες πρέπει να είναι ισορροπημένες.");
    }

    @Test
    public void testClusterResults() {
        List<String[]> mainList = new ArrayList<>();
        mainList.add(new String[]{"Μάριος", "Μάντζαρης", "8230088"});
        mainList.add(new String[]{"Άρτεμις", "Βαμβακάρη", "8230011"});
        mainList.add(new String[]{"Βασιλική-Άρτεμις", "Λυμπέρη", "8230079"});
        mainList.add(new String[]{"Θεμιστοκλής", "Μητρόπουλος", "8210219"});

        List<List<Integer>> clusters = new ArrayList<>();
        clusters.add(Arrays.asList(0, 2));
        clusters.add(Arrays.asList(1, 3));

        for (int i = 0; i < clusters.size(); i++) {
            List<Integer> cluster = clusters.get(i);
            System.out.print("Team " + (i + 1) + ": ");
            for (Integer studentIndex : cluster) {
                String[] student = mainList.get(studentIndex);
                System.out.print(student[0] + " " + student[1] + " (" + student[2] + "), ");
            }
            System.out.println();
        }

        assertEquals(2, clusters.size(), "Πρέπει να υπάρχουν 2 ομάδες.");
        assertEquals(2, clusters.get(0).size(), "Η πρώτη ομάδα πρέπει να έχει 2 μέλη.");
        assertEquals(2, clusters.get(1).size(), "Η δεύτερη ομάδα πρέπει να έχει 2 μέλη.");
    }
}


