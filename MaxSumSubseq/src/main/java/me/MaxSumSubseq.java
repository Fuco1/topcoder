package me;

public class MaxSumSubseq {

    public static int max(int a, int b) {
        return a < b ? b : a;
    }

    public static int mss(int[] data) {
        int max = 0;
        int c = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            c = max(0, c + data[i]);
            if (c > max) {
                max = c;
            }
        }
        return max;
    }
}
