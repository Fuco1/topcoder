package me;
import java.util.*;
import java.io.*;

public class ReversalChain {

    public ReversalChain() {}

    public static int minReversal(String init, String goal) {
        System.out.println(init);
        return doit(init, goal, new HashSet<String>());
    }

    private static int doit(String init, String goal, Set<String> used) {
        if (init.equals(goal)) return 0;
        Deque<Item> q = new ArrayDeque<Item>();
        q.add(new Item(init, 0, 0, init.length() - 1));
        used.add(init);
        while(!q.isEmpty()) {
            Item it = q.poll();
            //System.out.println(it.str + " " + it.swaps);
            for (int i = it.s; i <= it.e; i++) {
                for (int j = i+1; j <= it.e; j++) {
                    String n = reverse(it.str, i, j);
                    if (!used.contains(n)) {
                        if (n.equals(goal)) return it.swaps+1;
                        used.add(n);
                        q.add(new Item(n, it.swaps+1, i, j));
                    }
                }
            }
        }
        return -1;
    }

    private static String reverse(String re, int s, int e) {
        char[] data = re.toCharArray();
        while (s < e) {
            char tmp = data[s];
            data[s] = data[e];
            data[e] = tmp;
            s++; e--;
        }
        return String.valueOf(data);
    }
}

class Item {
    String str;
    int swaps;
    int s;
    int e;
    Item(String str, int swaps, int s, int e) {
        this.str = str;
        this.swaps = swaps;
        this.s = s;
        this.e = e;
    }
}
