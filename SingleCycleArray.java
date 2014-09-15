import java.util.*;
import java.io.*;

public class SingleCycleArray {

    public SingleCycleArray() {}

    public static void main(String[] args) {
        System.out.println(isCycle2(new int[]{}));
        System.out.println(isCycle2(new int[]{5}));
        System.out.println(isCycle2(new int[]{2,2,-1}));
        System.out.println(isCycle2(new int[]{1,1,-1})); // internal infinite loop, so we need to check we're not, landing on an already visited node
        System.out.println(isCycle2(new int[]{1,1,1,1,1}));
        System.out.println(isCycle2(new int[]{6,6,6,6,6}));
        System.out.println(isCycle2(new int[]{-6,-6,-6,-6,-6}));
        System.out.println(isCycle2(new int[]{1,-1,1,-1,0}));
        System.out.println(isCycle2(new int[]{1,1,-2,1,1,1}));
    }

    private static int mod(int a, int z) {
        return ((a % z) + z) % z;
    }

    public static boolean isCycle(int[] a) {
        int n = a.length;
        if (n == 0) return true;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int current = mod(a[0], n);
        while (current != 0 && !visited[current]) {
            visited[current] = true;
            current = mod(current + a[current], n);
        }
        if (current != 0) return false;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    // version with counting
    public static boolean isCycle2(int[] a) {
        int n = a.length;
        int current = 0;
        for (int i = 0; i < n; i++) {
            current = mod(current + a[current], n);
            if (current == 0 && i < n - 1) {
                return false;
            }
        }
        return current == 0;
    }
}
