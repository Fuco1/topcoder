package me;
import java.util.*;
import java.io.*;

public class RemissiveSwaps {

    public RemissiveSwaps() {}

    public static int findMaximum(int n) {
        boolean[] visited = new boolean[1000001];
        int[] memo = new int[1000001];
        int[] cur = new int[7];
        int end = 0;
        int last = 0;
        memo[0] = n;
        visited[n] = true;
        int max = n;
        while (last <= end) {
            int c = memo[last];
            for (int i = 6; i >= 0; i--) {
                cur[i] = c % 10;
                c /= 10;
            }
            for (int i = 0; i < 7; i++) {
                for (int j = i+1; j < 7; j++) {
                    if (cur[i] > 0 && cur[j] > 0) {
                        int tmp = cur[i];
                        cur[i] = cur[j] - 1;
                        cur[j] = tmp - 1;
                        int next = getInt(cur);
                        if (next > max) max = next;
                        if (!visited[next]) {
                            visited[next] = true;
                            end++;
                            memo[end] = next;
                        }
                        tmp = cur[i];
                        cur[i] = cur[j] + 1;
                        cur[j] = tmp + 1;
                    }
                }
            }
            last++;
        }
        return max;
    }

    // recursive version
    // public static int findMaximum(int n) {
    //     char[] tmp = Integer.toString(n).toCharArray();
    //     int[] digits = new int[tmp.length];
    //     for (int i = 0; i < tmp.length; i++) {
    //         digits[i] = tmp[i] - '0';
    //     }
    //     return doFindMaximum(digits, new HashMap<Integer, Integer>(1000));
    // }

    private static int doFindMaximum(int[] digits, Map<Integer, Integer> memo) {
        int c = getInt(digits);
        //System.out.println(c);
        if (memo.containsKey(c)) {
            return memo.get(c);
        }
        int max = c;
        for (int i = 0; i < digits.length - 1; i++) {
            for (int j = i+1; j < digits.length; j++) {
                if (digits[i] > 0 && digits[j] > 0) {
                    int tmp = digits[i];
                    digits[i] = digits[j] - 1;
                    digits[j] = tmp - 1;
                    int re = doFindMaximum(digits, memo);
                    if (max < re) max = re;
                    tmp = digits[i];
                    digits[i] = digits[j] + 1;
                    digits[j] = tmp + 1;
                }
            }
        }
        memo.put(c, max);
        return max;
    }

    private static int getInt(int[] digits) {
        int re = 0;
        for (int i = 0; i < digits.length; i++) {
            re = (re*10) + digits[i];
        }
        return re;
    }
}
