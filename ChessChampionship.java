import java.util.*;
import java.io.*;

public class ChessChampionship {

    public ChessChampionship() {}

    public static void main(String[] args) {
        System.out.println(probability(2, new double[]{0.4,0.4,0.2}, new double[]{0.4,0.4,0.2}));
    }

    // arrays are ordered: win, draw, loss
    public static double probability(int n, double[] white, double[] black) {
        double[] p = new double[2*n+3];
        // indexing is shifted 2 places so that we don't have to do boundary checks later
        p[2] = white[2];
        p[3] = white[1];
        p[4] = white[0];
        for (int i = 1; i < n; i++) {
            // indexing shifted, see note above
            for (int j = 2*n+2; j >= 2 ; j--) {
                if (i % 2 == 1) {
                    p[j] = p[j-2] * black[0] + p[j-1] * black[1] + p[j] * black[2];
                }
                else {
                    p[j] = p[j-2] * white[0] + p[j-1] * white[1] + p[j] * white[2];
                }
            }
        }
        double sum = 0;
        // indexing shifted, see note above
        for (int i = n+2; i < 2*n+3 ; i++) {
            sum += p[i];
        }
        return sum;
    }
}
