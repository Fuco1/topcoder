package me;
import java.util.*;
import java.io.*;

public class RegimentArming {

    public RegimentArming() {}

    public static int chooseGuns(int[] counts, int[] powers, int N) {
        int best = 0;
        int cur = 0;
        int total = 0;
        int[] selected = new int[counts.length];
        int l = 0;
        int h = 0;
        while (l <= h) {
            if (total < N) {
                int c = Math.min(N-total, counts[h]);
                selected[h] += c;
                total += c;
                cur += c * powers[h];
                if (cur > best) best = cur;
                if (selected[h] == Math.min(counts[h], N)) h++;
            } else {
                if (h == counts.length) return best;
                int c = Math.max(0, Math.min(counts[h] - selected[h], selected[l]));
                selected[l] -= c;
                total -= c;
                cur -= c * powers[l];
                if (selected[l] == 0) l++;
            }
        }
        return best;
    }
}
