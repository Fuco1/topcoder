package me;

import java.util.*;

public class QuickSums {

    public QuickSums() {}

    private static int MAX = 100;

    // dynamic programming
    public static int minSums(String num, int s) {
        Map<String, int[]> t = new HashMap<String, int[]>();
        for (int l = 1; l <= num.length(); l++) {
            for (int i = 0; i + l <= num.length(); i++) {
                String c = num.substring(i, i + l);
                long ci = Long.parseLong(c);
                int[] col = new int[s+1];
                for (int cs = 0; cs <= s; cs++) {
                    col[cs] = MAX;
                    if (cs == ci) col[cs] = 0;
                    else {
                        int min = MAX;
                        for (int k = 1; k < c.length(); k++) {
                            long rest = cs - Long.parseLong(c.substring(0, k));
                            if (0 <= rest && rest <= cs) {
                                int csteps = t.get(c.substring(k))[(int)rest];
                                if (min > csteps) min = csteps;
                            }
                        }
                        col[cs] = 1 + min;
                    }
                }
                //System.out.prlongln(c + ": " + Arrays.toString(col));
                t.put(c, col);
            }
        }
        int re = t.get(num)[s];
        return re >= MAX ? -1 : re;
    }

    //public static int minSums2()
}
