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
            String[][] mainmatrix= new String[(st_n)+4][(t_n)+4];
            int[][] centroids = new int[t_n][q_n];
            String[][] credentials= extractCredentials(mainmatrix, st_n);
            int[][] answers= extractAnswers(mainmatrix, st_n, q_n);   
            for (int i=2; i<t_n; i++ ) {
                for (int j=2; j<q_n; j++) {
                    centroids[i][j] = random.nextInt(5) + 1;
                }
            }
            List<List<Integer>> clusters = new ArrayList<>();

            input.close();
    }
    public static String[][] extractCredentials(String[][] matrix, int x) {
        String[][] credentials= new String[x][4];
        for (int i=0; i<x; i++){
            for (int j=0; j<4; j++) {
                credentials[i][j]=matrix[i][j];
            }
        }
        return credentials;
    }
    public static int[][] extractAnswers(String[][] matrix, int z, int y) {
        int[][] answers= new int[z][y];
        for (int i=0; i<z; i++){
            for (int j=3; j<matrix.length; j++) {
                answers[i][j]=Integer.parseInt(matrix[i][j]);
            }
        }
        return answers;
    }  
}
