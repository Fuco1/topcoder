package me;
import java.util.*;
import java.io.*;

public class NumericalSequence {

    public NumericalSequence() {}

    private static int[][] t;

    public static int makePalindrome(int[] sequence) {
        int n = sequence.length;
        t = new int[n][n];
        for (int[] i : t) {
            Arrays.fill(i, -1);
        }
        return doit(sequence, 0, n-1);
    }

    private static int doit(int[] s, int i, int j) {
        if (i >= j) return 0;
        if (t[i][j] != -1) return t[i][j];
        int min = Integer.MAX_VALUE;
        if (s[i] == s[j]) {
            min = Math.min(min, doit(s, i+1, j-1));
        }
        int[] sc = Arrays.copyOf(s, s.length);
        sc[i+1] = s[i] + s[i+1];
        min = Math.min(min, 1 + doit(sc, i+1, j));
        sc = Arrays.copyOf(s, s.length);
        sc[j-1] = s[j] + s[j-1];
        min = Math.min(min, 1 + doit(sc, i, j-1));
        return t[i][j] = min;
    }
}
