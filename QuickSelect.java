import java.util.*;
import java.io.*;

public class QuickSelect {

    public QuickSelect() {}

    public static void main(String[] args) {
        System.out.println(select(new int[]{10,8,7,5,1,3,2,6,4,9}, 0, 9, 5));
        System.out.println(select(new int[]{10,8,7,5,1,3,2,6,4,9}, 0, 9, 2));
        System.out.println(select(new int[]{10,8,7,5,1,3,2,6,4,9}, 0, 9, 4));
        System.out.println(select(new int[]{10,8,7,5,1,3,2,6,4,9}, 0, 9, 8));
    }

    public static int select(int[] data, int l, int h, int n) {
        if (l >= h) return data[l];
        int pivotIndex = partition(data, l, h);
        if (pivotIndex == n) return data[n];
        if (pivotIndex < n) {
            return select(data, pivotIndex + 1, h, n);
        } else {
            return select(data, l, pivotIndex - 1, n);
        }
    }

    private static int partition(int[] data, int l, int h) {
        int pivotIndex = l + (new Random()).nextInt(h - l + 1);
        int pivotValue = data[pivotIndex];
        while (l < h) {
            while (data[l] < pivotValue) { l++; }
            while (data[h] > pivotValue) { h--; }
            if (l < h) {
                int tmp = data[l];
                data[l] = data[h];
                data[h] = tmp;
            }
        }
        return l;
    }
}
