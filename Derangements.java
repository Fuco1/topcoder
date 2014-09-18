import java.util.*;
import java.io.*;

public class Derangements {

    public Derangements() {}

    public static void main(String[] args) {
        derangement(3);
        System.out.println("===========");
        derangement(4);
        System.out.println("===========");
        derangement(5);
    }

    public static void derangement(int n) {
        derangement(new int[n], new boolean[n], 0);
    }

    public static void derangement(int[] a, boolean[] used, int level) {
        if (level == a.length) {
            System.out.println(Arrays.toString(a));
        }
        for (int i = 0; i < a.length; i++) {
            if (used[i] || i == level) continue;
            used[i] = true;
            a[level] = i+1;
            derangement(a, used, level+1);
            used[i] = false;
        }
    }
}
