package GroupifyJava;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;

public class KMeansTest {

    @Test
    public void testCalculateDistance() {
        int[] student1 = {1, 2, 3};
        int[] student2 = {4, 5, 6};
        
        double expected = Math.sqrt(Math.pow(1 - 4, 2) + Math.pow(2 - 5, 2) + Math.pow(3 - 6, 2));
        double actual = KMeans.calculateDistance(student1, student2);
        
        assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testAreEqual() {
        int[] centroid1 = {1, 2, 3};
        int[] centroid2 = {1, 2, 3};
        
        assertTrue(KMeans.areEqual(centroid1, centroid2));
        
        int[] centroid3 = {4, 5, 6};
        assertFalse(KMeans.areEqual(centroid1, centroid3));
    }

    @Test
    public void testKMeansClustering() {
        int[][] answers = {
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 1},
            {4, 5, 1, 2, 3},
            {5, 4, 3, 2, 1}
        };
        int[][] centroids = {
            {2, 3, 4, 5, 1},
            {4, 5, 1, 2, 3}
        };
        
        List<List<Integer>> clusters = KMeans.kMeansClustering(answers, centroids, 2, 5);
        
        assertNotNull(clusters);
        assertEquals(2, clusters.size());
    }

    @Test
    public void testRebalanceClusters() {
        List<List<Integer>> clusters = List.of(
            List.of(0, 1),
            List.of(2, 3, 4)
        );
        
        int st_n = 6;
        int n_o_s = 2;
        
        List<List<Integer>> rebalanced = KMeans.rebalanceClusters(clusters, st_n, n_o_s);
        
        // Ensure clusters are rebalanced
        assertEquals(n_o_s, rebalanced.size());
        assertTrue(rebalanced.get(0).size() <= 3);
        assertTrue(rebalanced.get(1).size() <= 3);
    }
    
    @Test
    public void testConnectToDatabase() {
        try {
            assertNotNull(KMeans.connectToDatabase());
        } catch (Exception e) {
            fail("Database connection failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testMainMethod() {
        try {
            KMeans.main(new String[]{});
        } catch (Exception e) {
            fail("Main method failed: " + e.getMessage());
        }
    }
}
