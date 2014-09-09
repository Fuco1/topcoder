import java.util.*;

public class ZeroOneSort {

    public ZeroOneSort() {}

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new int[]{-1, 1, 3, -2, 2})));
        System.out.println(Arrays.toString(sort(new int[]{1,-2,3,9,-4,5,6,7,-3,8})));
    }

    public static void swap(int[] data, int l, int h) {
        int tmp = data[l];
        data[l] = data[h];
        data[h] = tmp;
    }

    public static void reverse(int[] data, int l, int h) {
        while (h > l) {
            swap(data, l++, h--);
        }
    }

    public static int[] sort(int[] data) {
        doSort(data, 0, data.length - 1);
        return data;
    }

    public static void doSort(int[] data, int l, int h) {
        if (h - l < 1) return;
        else if (h - l == 1) {
            if (data[l] > 0 && data[h] < 0) {
                swap(data, l, h);
            }
        } else {
            int m = (l + h) / 2;
            doSort(data, l, m);
            doSort(data, m+1, h);
            int n1 = l;
            int n2 = m+1;
            while (n1 <= m && data[n1] < 0) n1++;
            while (n2 <= h && data[n2] < 0) n2++;
            reverse(data, n1, m);
            reverse(data, m+1, n2-1);
            reverse(data, n1, n2-1);
        }
    }
}
