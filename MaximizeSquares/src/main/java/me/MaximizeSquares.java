package me;
import java.util.*;
import java.io.*;

public class MaximizeSquares {

    public MaximizeSquares() {}

    public static int squareCount(int n) {
        if (n < 4) return 0;
        int[] tmp = getMaxPerfSquare(n);
        int psq = tmp[0];
        int step = tmp[1];
        int re = sum(psq);
        int s = 0;
        for (int i = 0; i < n - psq; i++) {
            if (i == (step+2) / 2) s = 0;
            re += s;
            s++;
        }
        return re;
    }

    // sum all perfect squares up to n
    private static int sum(int n) {
        int i = 1;
        int s = 0;
        int step = 3;
        while (i + step <= n) {
            s += i;
            i += step;
            step += 2;
        }
        return s;
    }

    // find next perfect square and step
    private static int[] getMaxPerfSquare(int n) {
        int i = 1;
        int step = 3;
        while (i + step <= n) {
            i += step;
            step += 2;
        }
        return new int[]{i, step - 2};
    }
}
