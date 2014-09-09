package me;
import java.util.*;
import java.io.*;

public class StepperMotor {

    public StepperMotor() {}

    private static int mod(int n, int mod) {
        n %= mod;
        if (n < 0) n += mod;
        return n;
    }

    public static int rotateToNearest(int n, int current, int[] target) {
        int min = n;
        current = mod(current, n);
        for (int t : target) {
            int pos = mod(t, n);
            int d = pos - current;
            if (pos >= current) {
                if (d > n/2) d -= n;
            } else {
                if (d < -(n-1)/2) d += n;
            }
            if (Math.abs(d) < Math.abs(min) || d == Math.abs(min)) min = d;
        }
        return min;
    }
}
