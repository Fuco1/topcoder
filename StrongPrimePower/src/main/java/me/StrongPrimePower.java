package me;
import java.util.*;
import java.io.*;

public class StrongPrimePower {

    public StrongPrimePower() {}

    public static int[] baseAndExponent(String num) {
        long n = Long.parseLong(num);
        long sq = 4;
        long step = 5;
        while (n % sq != 0) {
            sq += step;
            step += 2;
        }
        int p = (int)Math.round(Math.sqrt(sq));
        long pp = p;
        int q = 1;
        while (pp < n) {
            pp *= p;
            q++;
        }
        if (pp != n) return new int[0];
        return new int[]{p, q};
    }
}
