package me;
import java.util.*;
import java.io.*;

public class PrintScheduler {

    public PrintScheduler() {}

    public static String getOutput(String[] threads, String[] slices) {
        StringBuilder sb = new StringBuilder();
        int[] pos = new int[threads.length];
        for (String s : slices) {
            String[] foo = s.split(" ");
            int thread = Integer.parseInt(foo[0]);
            int time = Integer.parseInt(foo[1]);
            while (time > 0) {
                sb.append(threads[thread].charAt(pos[thread]%threads[thread].length()));
                pos[thread]++;
                time--;
            }
        }
        return sb.toString();
    }
}
