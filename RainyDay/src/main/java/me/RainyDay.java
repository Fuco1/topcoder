package me;
import java.util.*;
import java.io.*;

public class RainyDay {

    public RainyDay() {}

    // this is not greedy! of course it isn't...
    public static int minimumRainTime(String path, String forecast) {
        int n = path.length();
        int re = 0;
        int start = 0;
        int goal = 0;
        boolean canWait = forecast.contains(".");
        for (int i = 0; i < n; i++) {
            if (path.charAt(i) == 'Y') start = i;
            if (path.charAt(i) == 'H') goal = i;
        }
        path = path.replace('Y', 'C');
        path = path.replace('H', 'C');
        int off = 0;
        int i = start;
        if (goal > start) {
            while (true) {
                if (i == goal) return re;
                if (path.charAt(i+1) == 'C') i++;
                else if (canWait) {
                    if (forecast.charAt((off+i+1)%n) == '.') i++;
                    else if (path.charAt(i) != 'C') {i++; re++;}
                } else {i++; re++;}
                off++;
                // System.out.format("index %d offset %d\n", i, off);
                // System.out.println(path);
                // System.out.println(forecast.substring(off%n,n) + forecast.substring(0, off%n));
                if (forecast.charAt((off+i)%n) == 'R' &&
                    (path.charAt(i) != 'C')) re++;
            }
        } else {
            while (true) {
                if (i == goal) return re;
                if (path.charAt(i-1) == 'C') i--;
                else if (canWait) {
                    if (forecast.charAt((off+i-1)%n) == '.') i--;
                    else if (path.charAt(i) != 'C') {i--; re++;}
                } else {i--; re++;}
                off++;
                // System.out.format("index %d offset %d\n", i, off);
                // System.out.println(path);
                // System.out.println(forecast.substring(off%n,n) + forecast.substring(0, off%n));
                if (forecast.charAt((off+i)%n) == 'R' &&
                    (path.charAt(i) != 'C')) re++;
            }
        }
    }
}
