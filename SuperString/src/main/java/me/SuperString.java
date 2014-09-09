package me;
import java.util.*;
import java.io.*;

public class SuperString {

    public SuperString() {}

    // basically optimal, we probably don't even need to store the 'd' thing
    public static String goodnessSubstring(String[] superstring) {
        String s = "";
        for (String ss : superstring) s += ss;
        //System.out.println(s);
        int[] in = new int[s.length()];
        for (int i = 0; i < in.length; i++) {
            in[i] = s.charAt(i) - 'A';
        }
        int l = 0;
        int h = 0;
        String re = "";
        int best = 0;
        int cur = 0;
        int curi = 0;
        int[] q = new int[26];
        int[] d = new int[in.length];
        d[0] = 1;
        q[in[0]]++;
        for (int i = 1; i < in.length; i++) {
            q[in[i]]++;
            if (q[in[i]] == 1) d[i] = d[i-1] + 1;
            else if (q[in[i]] == 2) d[i] = d[i-1] - 1;
            else d[i] = d[i-1];
        }
        for (int j = 0; j < in.length; j++) {
            if (d[j] > cur) {
                cur = d[j];
                curi = j;
            }
        }
        re = s.substring(0, curi+1);
        best = cur;
        for (int i = 1; i < in.length; i++) {
            cur = 0;
            int j = i;
            while (j < in.length && in[j] != in[i-1]) {
                d[j]--;
                j++;
            }
            if (j < in.length) d[j]++;
            j++;
            while (j < in.length && in[j] != in[i-1]) {
                d[j]++;
                j++;
            }
            for (int k = i; k < in.length; k++) {
                if (d[k] > cur) {
                    cur = d[k];
                    curi = k;
                }
            }
            if (cur > best) {
                re = s.substring(i, curi+1);
                best = cur;
            } else if (cur == best) {
                if (s.substring(i, curi+1).compareTo(re) < 0) re = s.substring(i, curi+1);
            }
        }
        return re;
    }
}
