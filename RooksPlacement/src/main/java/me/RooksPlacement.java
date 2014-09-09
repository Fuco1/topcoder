package me;
import java.util.*;
import java.io.*;

public class RooksPlacement {

    public RooksPlacement() {}

    public static int countPlacements(int n, int m, int k) {
        long[][][] memo = new long[51][51][101];
        for (int r = 0; r <= n; r++) {
            for (int c = 0; c <= m; c++) {
                memo[r][c][0] = 1;
                for (int i = 1; i <= k && i <= r * c; i++) {
                    if (r >= 1) {
                        memo[r][c][i] += memo[r-1][c][i];
                    }
                    if (r >= 1 && c >= 2 && i >= 2) {
                        memo[r][c][i] += (c * (c - 1) / 2) * memo[r-1][c-2][i-2];
                    }
                    if (r >= 2 && c >= 1 && i >= 2) {
                        memo[r][c][i] += (r - 1) * c * memo[r-2][c-1][i-2];
                    }
                    if (r >= 1 && c >= 1 && i >= 1) {
                        memo[r][c][i] += c * memo[r-1][c-1][i-1];
                    }
                    memo[r][c][i] %= 1000001;
                }
            }
        }
        return (int)memo[n][m][k];
    }
}
