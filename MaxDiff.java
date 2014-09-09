import java.util.*;

public class MaxDiff {

    public MaxDiff() {}

    public static void main(String[] args) {
        maxDiff(new int[]{2,-1,-2,1,-4,2,8});
    }

    public static void maxDiff(int[] data) {
        int[] maxr  = new int[data.length];
        int[] minr  = new int[data.length];
        int[] maxl  = new int[data.length];
        int[] minl  = new int[data.length];

        int cmax = 0;
        int cmin = 0;
        for (int i = 0; i < data.length; i++) {
            cmax = Math.max(0, cmax+data[i]);
            cmin = Math.min(0, cmin+data[i]);
            maxr[i] = cmax;
            minr[i] = cmin;
        }

        cmax = 0;
        cmin = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            cmax = Math.max(0, cmax+data[i]);
            cmin = Math.min(0, cmin+data[i]);
            maxl[i] = cmax;
            minl[i] = cmin;
        }

        int max = Integer.MIN_VALUE;
        int maxi = 0;
        for (int i = 0; i < data.length; i++) {
            int diff1 = maxr[i] - (i+1 < data.length ? minl[i+1] : 0);
            if (diff1 > max) {
                max = maxr[i] - diff1;
                maxi = i;
            }
            int diff2 = (data.length - 2 - i >= 0 ? minr[data.length - 2 - i] : 0);
            if (maxl[data.length - 1 - i] - diff2 > max) {
                max = maxl[data.length - 1 - i] - diff2;
                maxi = - i - data.length;
            }
        }

        if (maxi >= 0) {
            int s = maxi;
            int e = maxi;
            while (s >= 0 && maxr[s] != 0) s--;
            while (e < data.length && minl[e] != 0) e++;
            System.out.println(Arrays.toString(Arrays.copyOfRange(data, s+1, maxi)));
            System.out.println(Arrays.toString(Arrays.copyOfRange(data, maxi, e)));
        }
        else {
            maxi = 2*data.length + maxi - 1;
            int s = maxi;
            int e = maxi;
            while (s >= 0 && minr[s] != 0) s--;
            while (e < data.length && maxl[e] != 0) e++;
            System.out.println(Arrays.toString(Arrays.copyOfRange(data, s+1, maxi)));
            System.out.println(Arrays.toString(Arrays.copyOfRange(data, maxi, e)));
        }
        System.out.println(max);
    }

    public static void maxDiffWithRanges(int[] data) {
        int[] maxr  = new int[data.length];
        int[] minr  = new int[data.length];
        int[] maxl  = new int[data.length];
        int[] minl  = new int[data.length];
        int[] maxre = new int[data.length];
        int[] minre = new int[data.length];
        int[] maxle = new int[data.length];
        int[] minle = new int[data.length];

        int cmax = 0;
        int cmin = 0;
        for (int i = 0; i < data.length; i++) {
            cmax = Math.max(0, cmax+data[i]);
            cmin = Math.min(0, cmin+data[i]);
            maxr[i] = cmax;
            minr[i] = cmin;
            if (i > 0) {
                if (cmax >= maxr[maxre[i-1]]) {
                    maxre[i] = i;
                } else {
                    maxre[i] = maxre[i-1];
                }
                if (cmin <= minr[minre[i-1]]) {
                    minre[i] = i;
                } else {
                    minre[i] = minre[i-1];
                }
            }
        }

        cmax = 0;
        cmin = 0;
        maxle[data.length - 1] = data.length - 1;
        minle[data.length - 1] = data.length - 1;
        for (int i = data.length - 1; i >= 0; i--) {
            cmax = Math.max(0, cmax+data[i]);
            cmin = Math.min(0, cmin+data[i]);
            maxl[i] = cmax;
            minl[i] = cmin;
            if (i < data.length - 1) {
                if (cmax >= maxl[maxle[i+1]]) {
                    maxle[i] = i;
                } else {
                    maxle[i] = maxle[i+1];
                }
                if (cmin <= minl[minle[i+1]]) {
                    minle[i] = i;
                } else {
                    minle[i] = minle[i+1];
                }
            }
        }

        System.out.println(Arrays.toString(maxr));
        System.out.println(Arrays.toString(maxre));
        System.out.println(Arrays.toString(minr));
        System.out.println(Arrays.toString(minre));
        System.out.println(Arrays.toString(maxl));
        System.out.println(Arrays.toString(maxle));
        System.out.println(Arrays.toString(minl));
        System.out.println(Arrays.toString(minle));
    }
}
