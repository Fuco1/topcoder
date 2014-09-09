package me;
import java.util.*;
import java.io.*;

public class RoundOfEleven {

    public RoundOfEleven() {}

    private static long sum;

    public static long maxIncome(int n, int money) {
        char[] tmp = Integer.toString(n).toCharArray();
        int[] digits = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            digits[i] = tmp[i] - '0';
        }
        sum = 0;
        //doit(digits, money, new HashSet<Integer>());
        doit(n, money, new HashSet<Integer>());
        return sum;
    }

    //private static void doit(int[] digits, int money, Set<Integer> used) {
    private static void doit(int n, int money, Set<Integer> used) {
        Deque<Item> q = new ArrayDeque<Item>();
        q.add(new Item(n, money));
        used.add(n);
        while (!q.isEmpty()) {
            Item it = q.poll();
            int mon = it.money;
            int c = it.c;
            if (mon <= 0) continue;
            //System.out.format("c %d money %d\n", c, mon);
            if (c%11 == 0) {
                //System.out.format("%d%%11 == 0, getting %d money\n", c, mon);
                sum += mon;
            }
            long m = 1;
            while (m <= c) {
                //System.out.println(m);
                int next = (int)(c + m);
                if (((c % (m*10)) / m) < 9 && !used.contains(next)) {
                    //System.out.format("From %d, adding %d\n", c, c + m);
                    q.add(new Item(next, mon - 1));
                    used.add(next);
                }
                next = (int)(c - m);
                if (((c % (m*10)) / m) > 0 && !used.contains(next)) {
                    //System.out.format("From %d, adding %d\n", c, c - m);
                    q.add(new Item(next, mon - 1));
                    used.add(next);
                }
                m *= 10;
            }
        }
        // if (money <= 0) return;
        // int t = horner(digits);
        // if (used.contains(t)) return;
        // if (divisible(digits)) {
        //     System.out.format("Value: %d, Money: %d\n", t, money);
        //     used.add(t);
        //     sum += money;
        //     return;
        // }
        // for (int i = 0; i < digits.length; i++) {
        //     if (digits[i] - 1 >= 0) {
        //         digits[i] -= 1;
        //         doit(digits, money-1, used);
        //         digits[i] += 1;
        //     }
        //     if (digits[i] + 1 <= 9) {
        //         digits[i] += 1;
        //         doit(digits, money-1, used);
        //         digits[i] -= 1;
        //     }
        // }
    }

    private static boolean divisible(int[] digits) {
        return horner(digits) % 11 == 0;
    }

    private static int horner(int[] digits) {
        int re = 0;
        for (int i = 0; i < digits.length; i++) {
            re = (re*10) + digits[i];
        }
        return re;
    }
}

class Item {
    int c;
    int money;
    Item(int c, int money) {
        this.c = c;
        this.money = money;
    }
}
