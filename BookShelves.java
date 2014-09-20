import java.util.*;
import java.io.*;

// Skiena 8-19
public class BookShelves {

    public BookShelves() {}

    public static void main(String[] args) {
        System.out.println(shelves(4, new int[]{1,1,1,3,1,1,3,4,4})); // 1+3+4 = 0
        System.out.println(shelves(4, new int[]{1,1,1,4,1,4,5,1,1,1})); // 7
        System.out.println(shelves(4, new int[]{1,1,1,1})); // 1
        System.out.println(shelves(4, new int[]{1,2,3,4})); // 4
        System.out.println(shelves(4, new int[]{4,3,2,1})); // 4
        System.out.println(shelves(4, new int[]{1,1,7,8,6})); // 9
    }

    public static int shelves(int l, int[] h) {
        int n = h.length;
        int[] memo = new int[n+1];
        int[] splits = new int[n+1];
        splits[0] = -1;
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= Math.min(i,l); j++) {
                int c = memo[i-j] + max(i-j,i,h);
                if (min > c) {
                    min = c;
                    splits[i] = i-j;
                }
            }
            memo[i] = min;
        }
        printSplits(n, splits, h);
        System.out.println();
        return memo[n];
    }

    private static void printSplits(int n, int[] splits, int[] h) {
        if (splits[n] == -1) return;
        else {
            printSplits(splits[n], splits, h);
            System.out.print(Arrays.toString(Arrays.copyOfRange(h, Math.max(splits[n], 0), n)));
        }
    }

    private static int max(int s, int e, int[] a) {
        int max = a[s];
        for (int i = s; i < e; i++) {
            max = Math.max(max, a[i]);
        }
        return max;
    }
}
