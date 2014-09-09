package me;
import java.util.*;
import java.io.*;

public class UnsealTheSafe {

    public UnsealTheSafe() {}

    public static long countPasswords(int n) {
        long[][] keypad = {{0,0,0,0,0},
                          {0,1,1,1,0},
                          {0,1,1,1,0},
                          {0,1,1,1,0},
                          {0,1,0,0,0},
                          {0,0,0,0,0}};
        long[][] next = new long[6][5];
        while (n > 1) {
            for (int r = 1; r < 4; r++) {
                for (int c = 1; c < 4; c++) {
                    next[r][c] = keypad[r-1][c] + keypad[r+1][c] + keypad[r][c-1] + keypad[r][c+1];
                }
            }
            next[4][1] = keypad[3][1];
            n--;
            long[][] tmp = keypad;
            keypad = next;
            next = tmp;
        }
        long re = 0;
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 5; c++) {
                re += keypad[r][c];
            }
        }
        return re;
    }
}
