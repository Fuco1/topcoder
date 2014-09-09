import java.util.*;

public class Permutations {

    public Permutations() {}

    public static void main(String[] args) throws InterruptedException {
        //printPerms(3);
        //recursivePerms(4, new int[]{1,2,3,4});
        basicPerms("123");
    }

    public static void basicPerms(String str) {
        doBasicPerms(str.toCharArray(), new char[str.length()], new boolean[str.length()], 0);
    }

    private static void doBasicPerms(char[] in, char[] out, boolean[] used, int level) {
        if (level == used.length) {
            System.out.println(new String(out));
            return;
        }

        for (int i = 0; i < used.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            out[level] = in[i];
            doBasicPerms(in, out, used, level+1);
            used[i] = false;
        }
    }

    public static void printPerms(int n) throws InterruptedException {
        int[] perm = new int[n];
        for (int i = 0; i < n; i++) perm[i] = i+1;
        while (true) {
            for (int i : perm) {
                System.out.print(i);
            }
            System.out.println("");
            int k = n - 2;
            while (k >= 0 && perm[k] > perm[k+1]) k--;
            if (k < 0) return;
            int l = n - 1;
            while (perm[k] > perm[l]) l--;
            int tmp = perm[k];
            perm[k] = perm[l];
            perm[l] = tmp;
            k++;
            l = n - 1;
            while (k < l) {
                tmp = perm[k];
                perm[k] = perm[l];
                perm[l] = tmp;
                k++;
                l--;
            }
        }
    }

    public static void recursivePerms(int n, int[] data) {
        if (n == 0) {
            System.out.println(Arrays.toString(data));
        } else {
            for (int i = 0; i < n; i++) {
                recursivePerms(n - 1, data);
                int index = n % 2 == 0 ? 0 : i;
                int tmp = data[index];
                data[index] = data[n-1];
                data[n-1] = tmp;
            }
        }
    }
}
