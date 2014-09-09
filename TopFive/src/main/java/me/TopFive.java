package me;
import java.util.*;
import java.io.*;

public class TopFive {

    public TopFive() {}

    public static double findProbability(String[] results, String[] accuracies, int points) {
        int[][] r = new int[results.length][3];
        double[][] a = new double[results.length][3];
        for (int i = 0; i < results.length; i++) {
            String[] res = results[i].split(" ");
            String[] acc = accuracies[i].split(" ");
            for (int j = 0; j < 3; j++) {
                r[i][j] = Integer.parseInt(res[j]);
                a[i][j] = Double.parseDouble(acc[j]) / 100;
            }
        }
        double[] better = new double[6];
        better[0] = 1;
        for (int i = 0; i < results.length; i++) {
            double tc = 0;
            for (int j = 0; j < 8; j++) {
                int p = 0;
                double cc = 1;
                if ((j & 1) == 0) {
                    cc *= 1 - a[i][0];
                } else {
                    p += r[i][0];
                    cc *= a[i][0];
                }
                if ((j & 2) == 0) {
                    cc *= 1 - a[i][1];
                } else {
                    p += r[i][1];
                    cc *= a[i][1];
                }
                if ((j & 4) == 0) {
                    cc *= 1 - a[i][2];
                } else {
                    p += r[i][2];
                    cc *= a[i][2];
                }
                if (p < points) {
                    tc += cc;
                }
            }
            for (int k = 5; k > 0 ; k--) {
                better[k] = better[k-1] * (1-tc) + better[k] * tc;
            }
            better[0] = better[0] * tc;
        }
        double re = 0;
        for (int i = 0; i < 5; i++) {
            re += better[i];
        }
        return re;
    }
}
