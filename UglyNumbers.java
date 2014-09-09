import java.util.*;

public class UglyNumbers {

    public UglyNumbers() {}

    public static void main(String[] args) {
        numbers(new int[]{2,3,5}, 1000);
    }

    private static long min(long[] array) {
        long min = Long.MAX_VALUE;
        for (long i : array) {
            if (i < min) min = i;
        }
        return min;
    }

    public static void numbers(int[] primes, int n) {
        int[] last = new int[primes.length];
        long[] cur = new long[primes.length];
        for (int i = 0; i < primes.length; i++) {
            cur[i] = primes[i];
        }
        long[] re = new long[n];
        int m = 0;
        re[0] = 1;
        while (m < n - 1) {
            re[++m] = min(cur);
            for (int i = 0; i < primes.length; i++) {
                if (cur[i] == re[m]) {
                    cur[i] = re[last[i] + 1] * primes[i];
                    last[i]++;
                }
            }
        }
        System.out.println(Arrays.toString(re));
    }
}
