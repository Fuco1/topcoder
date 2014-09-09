package me;
import java.util.*;
import java.io.*;

public class ComboBoxKeystrokes {

    public ComboBoxKeystrokes() {}

    public static int minimumKeystrokes(String[] elements) {
        int n = elements.length;
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = elements[i].substring(0,1).toLowerCase().charAt(0) - 'a';
        }
        int[][] dist = new int[n][n];
        int[] counter;
        for (int r = 0; r < n; r++) {
            counter = new int[26];
            for (int c = r+1; c < n + r; c++) {
                counter[items[c%n]]++;
                dist[r][c%n] = counter[items[c%n]];
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int max = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (dist[r][c] > max) {
                    max = dist[r][c];
                }
            }
        }
        return max;
    }
}
