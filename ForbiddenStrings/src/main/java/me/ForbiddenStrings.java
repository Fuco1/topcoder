package me;
import java.util.*;
import java.io.*;

public class ForbiddenStrings {

    public ForbiddenStrings() {}

    private static long[][][] memo;

    public static long countNotForbidden(int n) {
        memo = new long[n+1][4][4];
        return doit(0, 0, 0, n);
    }

    private static long doit(int ind, int prev, int nprev, int n) {
        if (ind == n) return memo[ind][prev][nprev] = 1;
        if (memo[ind][prev][nprev] != 0L) return memo[ind][prev][nprev];
        long re = 0;
        for (int k = 1; k <= 3; k++) {
            if (prev == nprev || nprev == 0 || k == prev || k == nprev) {
                re += doit(ind+1, k, prev, n);
            }
        }
        return memo[ind][prev][nprev] = re;
    }
}
