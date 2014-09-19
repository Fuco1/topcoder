import java.util.*;
import java.io.*;

public class LongestCommonSubstring {

    public LongestCommonSubstring() {}

    public static void main(String[] args) {
        System.out.println(lss("ab", "ba"));
        System.out.println(lss("steve", "setva"));
        System.out.println(lss("kitten", "sitting"));
        System.out.println(lss("dbc", "abc"));
    }

    public static String lss(String a, String b) {
        return doLss((" "+a).toCharArray(), (" "+b).toCharArray());
    }

    private static String doLss(char[] a, char[] b) {
        int[][] t = new int[a.length][b.length];
        int max = 0;
        int maxi = 0;
        int maxj = 0;
        for (int i = 0; i < a.length; i++) t[i][0] = 0;
        for (int j = 0; j < b.length; j++) t[0][j] = 0;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) t[i][j] = t[i-1][j-1] + 1;
                else t[i][j] = 0;
                if (t[i][j] > max) {
                    max = t[i][j];
                    maxi = i;
                    maxj = j;
                }
            }
        }
        printTable(t);
        return new String(Arrays.copyOfRange(a, maxi - t[maxi][maxj]+1, maxi+1));
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
