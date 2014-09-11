import java.util.*;
import java.io.*;

public class Sampling {

    public Sampling() {}

    public static void main(String[] args) {
        int[] stats = new int[100];
        for (int i = 0; i < 1000000; i++) {
            int[] re = getSample(10, 100);
            for (int j : re) {
                stats[j]++;
            }
        }
        System.out.println(Arrays.toString(stats));
    }

    // return n random numbers from 1 to m (a stream of length m)
    private static int[] getSample(int n, int m) {
        int[] re = new int[n];
        for (int i = 0; i < n; i++) {
            re[i] = i;
        }
        Random r = new Random();
        for (int i = n; i < m; i++) {
            int c = r.nextInt(i+1);
            if (c < n) {
                re[c] = i;
            }
        }
        return re;
    }
}
