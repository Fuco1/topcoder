package me;

public class BettingMoney {

    public BettingMoney() {}

    public static int gain(int[] amounts, int[] cpd, int result) {
        int gain = 0;
        for (int i = 0; i < amounts.length; i++) {
            gain += amounts[i];
        }
        gain -= amounts[result];
        gain *= 100;
        gain -= amounts[result] * cpd[result];
        return gain;
    }
}
