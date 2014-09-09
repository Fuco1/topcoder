package me;
import java.util.*;
import java.io.*;

public class ScrabbleBet {

    public ScrabbleBet() {}

    private static int choose(int n, int k) {
        int nCk = 1;
        for (int i = 0; i < k; i++) {
            nCk = (nCk * (n-i)) / (i+1);
        }
        return nCk;
    }

    public static double estimate(int trials, int games, int winsNeeded, int winChance) {
        double c = winChance / 100.0;
        int nCk = 1;
        // chance that I win less than winsNeeded = chance my opponent
        // wins a game
        double prob = 0;
        for (int i = 0; i < winsNeeded; i++) {
            prob += nCk * Math.pow(c, i) * Math.pow(1-c, games - i);
            nCk = (nCk * (games-i)) / (i+1);
        }
        // my opponent must win *all* the games, therefore the chance
        // I win at least one is the opposite of that.
        return 1-Math.pow(prob, trials);
    }
}
