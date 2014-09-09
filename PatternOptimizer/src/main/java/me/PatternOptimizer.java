package me;
import java.util.*;
import java.io.*;

public class PatternOptimizer {

    public PatternOptimizer() {}

    public static String optimize(String pattern) {
        char[] data = pattern.toCharArray();
        int sc = 0;
        int qc = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == '*') {
                int k = i;
                while (k > 0 && data[k-1] == '?') {
                    data[k-1] = '*';
                    data[k] = '?';
                    k--;
                }
            }
        }
        return String.valueOf(data).replaceAll("\\*+", "*");
    }
}
