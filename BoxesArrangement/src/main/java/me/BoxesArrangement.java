package me;
import java.util.*;
import java.io.*;

public class BoxesArrangement {

    public BoxesArrangement() {}

    private static int[][][][][] memo;
    private static int[] count;
    private static String input;
    private static int INF = 1000000;

    public static int maxUnouched(String boxes) {
        int l = boxes.length() + 1;
        count = new int[3];
        input = boxes;
        memo = new int[l][l][l][3][3];
        for (int a = 0; a < l; a++) {
            for (int b = 0; b < l; b++) {
                for (int c = 0; c < l; c++) {
                    for (int d = 0; d < 3; d++) {
                        for (int e = 0; e < 3; e++) {
                            memo[a][b][c][d][e] = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < boxes.length(); i++) {
            count[boxes.charAt(i) - 'A']++;
        }
        System.out.println(boxes);
        int re = doMaxUnouched(0,0,0,-1,0);
        if (re >= 0) return re;
        return -1;
    }

    private static int doMaxUnouched(int a, int b, int c, int prev, int rep) {
        if (rep == 3) return -INF;
        if (a > count[0] || b > count[1] || c > count[2]) return -INF;
        if (a + b + c == input.length()) return 0;
        if (prev >= 0) {
            int mem = memo[a][b][c][prev][rep];
            if (mem != -1) return mem;
        }
        int r1 = ((input.charAt(a+b+c) == 'A')?1:0) + doMaxUnouched(a+1, b, c, 0, prev==0 ? rep+1 : 1);
        int r2 = ((input.charAt(a+b+c) == 'B')?1:0) + doMaxUnouched(a, b+1, c, 1, prev==1 ? rep+1 : 1);
        int r3 = ((input.charAt(a+b+c) == 'C')?1:0) + doMaxUnouched(a, b, c+1, 2, prev==2 ? rep+1 : 1);
        int re = Math.max(r1, Math.max(r2, r3));
        if (prev >= 0) memo[a][b][c][prev][rep] = re;
        return re;
    }
}
