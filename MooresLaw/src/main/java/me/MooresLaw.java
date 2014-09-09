package me;
import java.util.*;
import java.io.*;

public class MooresLaw {

    public MooresLaw() {}

    private static double exp = Math.pow(2, 2/3.0);
    private static double log = Math.log(exp);

    public static double shortestComputationTime(int years) {
        double t = Math.log(years * log)/log;
        if (t < 0) return years;
        else return t + (years / Math.pow(exp, t));
    }
}
