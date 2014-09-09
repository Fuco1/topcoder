package me;
import java.util.*;
import java.io.*;

public class WorldPeace {

    public WorldPeace() {}

    public static long numGroups(int k, int[] countries) {
        Queue<Integer> q = new PriorityQueue<Integer>(k, Collections.reverseOrder());
        for (int i : countries) {
            q.add(i);
        }
        long re = 0;
        int counter = 0;
        int[] buf = new int[k];
        while (true) {
            while (counter < k) {
                if (q.isEmpty()) return re;
                int c = q.poll();
                if (c == 0) continue;
                buf[counter] = c;
                counter++;
            }
            //System.out.println(Arrays.toString(buf));
            re++;
            counter = 0;
            for (int i = 0; i < k; i++) {
                q.add(buf[i] - 1);
            }
        }
        //return re;
    }
}
