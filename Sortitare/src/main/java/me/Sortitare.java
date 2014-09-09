package me;
import java.util.*;
import java.io.*;

public class Sortitare {

    public Sortitare() {}

    private static int[][] memo;
    private static int[] stock;

    public static int turns(int[] tableau, int[] stock) {
        System.out.println(Arrays.toString(tableau));
        Arrays.sort(stock);
        Sortitare.stock = stock;
        memo = new int[stock.length + 1][100];
        for (int i = 0; i < stock.length+1; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        return doit(tableau, 0);
    }

    // search with memo doesn't work
    private static int doit(int[] tableau, int deck) {
        int i;
        for (i = 0; i < tableau.length - 1; i++) {
            if (tableau[i] > tableau[i+1]) break;
        }
        if (i == tableau.length - 1) return deck + 1;
        // if (tableau[i] < memo[deck][i]) {
        //     memo[deck][i] = tableau[i];
        // } else {
        //     return Integer.MAX_VALUE;
        // }
        System.out.println(Arrays.toString(tableau));
        for (int c = deck; c < stock.length; c++) {
            for (int ind = 0; ind <= tableau.length; ind++) {
                int[] copy = Arrays.copyOf(tableau, tableau.length);
                if (ind < tableau.length) copy[ind] = stock[c];
                int re = doit(copy, deck+1);
                //if (re == Integer.MAX_VALUE) return -1;
                if (re != -1) return re;
            }
        }
        return -1;
    }
}
