package me;
import java.util.*;
import java.io.*;

public class PartialSeries {

    public PartialSeries() {}

    public static int ubound = 9999999;
    public static int lbound = 0;
    public static int[] best;

    public static int[] getFirst(int[] series, int[] available) {
        Arrays.sort(available);
        ubound = 9999999;
        lbound = numberOfUnFilledExtrema(series);
        print(series);
        doGetFirst(series, available);
        return best;
    }

    private static boolean doGetFirst(int[] series, int[] available) {
        int ex = numberOfExtrema(series);
        if (ex >= ubound) return false;
        int i = getFirstMissing(series, 0);
        if (i >= 0) {
            for (int j = getFirstAvailable(available, 0); j >= 0 ; j = getFirstAvailable(available, j+1)) {
                // int[] scopy = Arrays.copyOf(series, series.length);
                // int[] acopy = Arrays.copyOf(available, available.length);
                // scopy[i] = acopy[j];
                // acopy[j] = -1;
                //System.out.print("level " + level);
                //print(scopy);
                //print(acopy);
                //boolean re = doGetFirst(scopy, acopy);
                series[i] = available[j];
                available[j] = -1;
                //print(series);
                // print(available);
                boolean re = doGetFirst(series, available);
                available[j] = series[i];
                series[i] = -1;
                if (re) return true;
            }
        } else {
            int re = numberOfExtrema(series);
            if (re == lbound) {
                System.out.format("Lower bound %d attained\n", lbound);
                best = Arrays.copyOf(series, series.length);
                return true;
            }
            if (re < ubound) {
                System.out.format("Old ubound: %d new ubound: %d\n", ubound, re);
                ubound = re;
                best = Arrays.copyOf(series, series.length);
            }
        }
        return false;
    }

    private static int numberOfExtrema(int[] series) {
        int re = 0;
        for (int i = 1; i < series.length - 1; i++) {
            if (series[i] == -1 || series[i+1] == -1) break;
            if ((series[i-1] < series[i] && series[i] > series[i+1]) ||
                (series[i-1] > series[i] && series[i] < series[i+1])) {
                re++;
            }
        }
        return re;
    }

    private static int numberOfUnFilledExtrema(int[] series) {
        int re = 0;
        for (int i = 1; i < series.length - 1; i++) {
            if ((series[i-1] != -1 && series[i] != -1 && series[i+1] != -1) &&
                ((series[i-1] < series[i] && series[i] > series[i+1]) ||
                 (series[i-1] > series[i] && series[i] < series[i+1]))) {
                re++;
            }
        }
        return re;
    }

    private static boolean isExtrema(int[] series, int i) {
        return ((series[i-1] < series[i] && series[i] > series[i+1]) ||
                (series[i-1] > series[i] && series[i] < series[i+1]));
    }

    private static int getFirstMissing(int[] series, int n) {
        for (int i = n; i < series.length; i++) {
            if (series[i] == -1) return i;
        }
        return -1;
    }

    private static int getFirstAvailable(int[] available, int n) {
        for (int i = n; i < available.length; i++) {
            if (available[i] != -1) return i;
        }
        return -1;
    }

    private static void print(int[] series) {
        System.out.print("[");
        for (int i = 0; i < series.length; i++) {
            System.out.format("%2d", series[i]);
            if (i + 1 != series.length) System.out.print(",");
        }
        System.out.println("]");
    }
}
