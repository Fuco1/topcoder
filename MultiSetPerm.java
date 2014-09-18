import java.util.*;
import java.io.*;

public class MultiSetPerm {

    public MultiSetPerm() {}

    public static void main(String[] args) {
        msp(new int[]{1,1,2,2});
        System.out.println("=========");
        msp(new int[]{1,1,2,2,3,3});
        System.out.println("=========");
        msp(new int[]{1,1,1,2,2});
    }

    // we expect the set `a' to be sorted
    public static void msp(int[] a) {
        msp(a, new int[a.length], new boolean[a.length], 0);
    }

    public static void msp(int[] a, int [] out, boolean[] used, int level) {
        if (level == a.length) {
            System.out.println(Arrays.toString(out));
        }
        for (int i = 0; i < a.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            out[level] = a[i];
            msp(a, out, used, level+1);
            used[i] = false;
            while (i + 1 < a.length && a[i] == a[i+1]) i++;
        }
    }
}
