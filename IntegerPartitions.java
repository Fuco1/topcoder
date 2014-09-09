import java.util.*;

public class IntegerPartitions {

    public IntegerPartitions() {}

    public static void main(String[] args) {
        partition(6);
    }

    public static void partition(int i) {
        int[] r = new int[i];
        r[0] = i;
        doPartition(r);
    }

    //nefunguje uplne presne
    public static void doPartition(int[] p) {
        while (true) {
            int i = p.length - 1;
            while (i >= 0 && p[i] <= 1) {
                i--;
            }
            if (i < 0) return;
            int j = i;
            while (j < p.length && p[j] + 1 >= p[i]) {
                j++;
            }
            if (j == p.length) return;
            p[j]++;
            p[i]--;
            System.out.println(Arrays.toString(p));
        }
    }
}
