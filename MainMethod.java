import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class MainMethod {
    public static void main(String [] args) {
            Scanner input = new Scanner(System.in);
            int st_n= input.nextInt();
            int t_n=input.nextInt();
            int k=t_n;
            int q_n=20;
            Random random= new Random();
            int[][] mainmatrix= new int[(st_n)+2][(t_n)+2];
            int[][] centroids = new int[t_n][q_n];
            for (int i=2; i<t_n; i++ ) {
                for (int j=2; j<q_n; j++) {
                    centroids[i][j] = random.nextInt(5) + 1;
                }
            }
            List<List<Integer>> clusters = new ArrayList<>();

            input.close();
    }
}