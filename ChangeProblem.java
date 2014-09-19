import java.util.*;
import java.io.*;

public class ChangeProblem {

    public ChangeProblem() {}

    public static void main(String[] args) {
        System.out.println(possibleChange(20, new int[]{1,6,10}));
        // see: http://www.maa.org/frank-morgans-math-chat-293-ways-to-make-change-for-a-dollar
        System.out.println(possibleChange(100, new int[]{1,5,10,25,50}));
        System.out.println(possibleChange(200, new int[]{1,5,10,25,50,100}));
        System.out.println(possibleChange(500, new int[]{1,5,10,25,50,100,200}));
        System.out.println(possibleChange(10000, new int[]{1,5,10,25,50,100,200,500,1000,2000,5000}));
    }

    public static long possibleChange(int k, int[] denom) {
        long[][] t = new long[k+1][denom.length];
        for (int i = 0; i < denom.length; i++) {
            t[0][i] = 1;
        }
        for (int i = 0; i < denom.length; i++) {
            for (int j = 1; j <= k; j++) {
                long c = 0;
                if (i > 0) c+= t[j][i-1];
                if (j - denom[i] >= 0) c+= t[j-denom[i]][i];
                t[j][i] = c;
            }
        }
        //printTable(t);
        return t[k][denom.length-1];
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
