import java.util.*;
import java.io.*;

// Skiena 8-12
public class StringBreaking {

    public StringBreaking() {}

    private static int[][] memo;
    private static int[] breakPoints;

    public static void main(String[] args) {
        System.out.println(breakCost(20, new int[]{3,8,10}));
        System.out.println(breakCost(20, new int[]{2,5,6,7,11,17}));
        System.out.println(breakCost(20, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}));
    }

    public static int breakCost(int n, int[] points) {
        breakPoints = points;
        memo = new int[n+1][n+1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        int re = doBreakCost(0, n, n);
        printTable(memo);
        return re;
    }

    private static int doBreakCost(int i, int j, int n) {
        if (memo[i][j] != -1) return memo[i][j];
        if (i >= j) return 0;
        int min = 1000000;
        for (int k = 0; k < breakPoints.length; k++) {
            if (i < breakPoints[k] && breakPoints[k] < j) {
                int c = (j - i) + doBreakCost(i, breakPoints[k], n) + doBreakCost(breakPoints[k], j, n);
                if (min > c) min = c;
            }
        }
        // if no split is possible, cost is zero
        if (min == 1000000) min = 0;
        return memo[i][j] = min;
    }

    private static void printTable(int[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                System.out.format("%5d",table[j][i]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
