import java.util.*;
import java.io.*;

public class LinearPartition {

    public LinearPartition() {}

    public static void main(String[] args) {
        // 1 2 3 4 5 | 6 7 | 8 9
        System.out.println(partition(new int[]{1,2,3,4,5,6,7,8,9}, 2));
        // 1 1 1 | 1 1 1 | 1 1 1
        System.out.println(partition(new int[]{1,1,1,1,1,1,1,1,1}, 2));
    }

    public static int partition(int[] a, int n) {
        int[][] part = new int[a.length+20][n];
        int re = partition(a, part, 0, a.length, n);
        int last = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(Arrays.copyOfRange(a, last, part[last][i])) + ", ");
            last = part[last][i];
        }
        System.out.println(Arrays.toString(Arrays.copyOfRange(a, last, a.length)));
        return re;
    }

    // TODO: add memo for partition calculation
    // TODO: instead of memoing intervals from i to j, memo 0 to i, and work from backward, saves space
    private static int partition(int[] a, int[][] part, int i, int j, int n) {
        if (i == j) return 0;
        if (n == 0) return sum(a, i, j);
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int c = Math.max(partition(a, part, i, k, 0), partition(a, part, k, j, n-1));
            if (c < min) {
                part[i][part[0].length - n] = k;
                min = c;
            }
        }
        return min;
    }

    private static int sum(int[] a, int i, int j) {
        int re = 0;
        for (int k = i; k < j; k++) {
            re += a[k];
        }
        return re;
    }
}
