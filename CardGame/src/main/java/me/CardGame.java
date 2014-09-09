package me;

import java.util.Arrays;

public class CardGame {

    public static int choose(int n, int k) {
        if (k == 0) return 1;
        else {
            return (n * choose(n-1, k-1)) / k;
        }
    }

    public static int hand(int[] cards, int k) {
        int sum = 0;
        Arrays.sort(cards);
        for (int i = cards.length - 1; i >= k-1; i--) {
            sum += cards[i] * choose(i, k-1);
        }
        return sum;
    }
}
