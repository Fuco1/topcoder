package me;
import java.util.*;
import java.io.*;

public class RedundantStrings {

    public RedundantStrings() {}

    public static int howMany(int length) {
        if (length == 1) return 0;
        List<Integer> divisors = new ArrayList<Integer>();
        for (int i = 2; i <= length / 2; i++) {
            if (length % i == 0) divisors.add(i);
        }
        int[] sums = new int[divisors.size()];
        for (int i = 0; i < divisors.size(); i++) {
            sums[i] = (int)Math.pow(2, divisors.get(i)) - 2;
            for (int j = 0; j < i; j++) {
                if (divisors.get(i) % divisors.get(j) == 0) {
                    sums[i] -= sums[j];
                }
            }
        }
        int sum = 2;
        for (int i = 0; i < sums.length; i++) {
            sum += sums[i];
        }
        return sum;
    }
}
