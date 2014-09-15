import java.util.*;
import java.io.*;

public class RadixSort {

    public RadixSort() {}

    public static void main(String[] args) {
        System.out.println(Arrays.toString(radixSort(new int[]{3,2,5,122,7,12,4,76,13})));
    }

    public static int[] radixSort(int[] a) {
        Deque[] deques = new Deque[10];
        for (int i = 0; i < 10; i++) {
            deques[i] = new ArrayDeque();
        }
        // this part is not necessary if we know how many digits we have.
        int max = 0;
        for (int i : a) {
            if (i > max) max = i;
        }
        int k = (int)Math.ceil(Math.log(max)/Math.log(10));
        //
        for (int m = 0; m <= k; m++) {
            // into queues
            int mod = (int)Math.pow(10,m);
            for (int i : a) {
                deques[(i/mod)%10].add(i);
            }
            // and back into array
            int j = 0;
            for (int i = 0; i < 10; i++) {
                while (!deques[i].isEmpty()) {
                    a[j] = (Integer)deques[i].poll(); // no primitive type containers, UGH
                    j++;
                }
            }
        }
        return a;
    }
}
