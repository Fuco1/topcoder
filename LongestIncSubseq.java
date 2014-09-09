import java.util.*;

public class LongestIncSubseq {

    public LongestIncSubseq() {}

    public static void main(String[] args) {
        lis(new int[]{3,5,1,2,7,4,6});
        lis(new int[]{0, 8, 4, 12, 2, 10, 6});
        lis(new int[]{0, 8, 4, 12, 2, 10, 1});
        lis(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}); // = 0, 2, 6, 9, 13, 15; 0, 4, 6, 9, 11, 15
    }

    public static int lis(int[] data) {
        int[] m = new int[data.length];
        int[] p = new int[data.length];
        p[0] = -1;
        int len = 0;
        for (int i = 0; i < data.length; i++) {
            int low = 0;
            int high = len;
            int mid;
            while (low <= high) {
                mid = (low + high) / 2;
                if (data[m[mid]] < data[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            m[low] = i;
            if (low > 0) p[i] = m[low-1]; else p[i] = -1;
            len = Math.max(len,low);
        }
        // print the seq
        int c = m[len];
        while (c >= 0) {
            System.out.print(data[c] + " ");
            c = p[c];
        }
        System.out.println("");
        return len;
    }
}
