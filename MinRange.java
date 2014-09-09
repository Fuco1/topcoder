public class MinRange {

    public MinRange() {}

    public static void main(String[] args) {
        minRange(new int[][]{{4,10,15},{0,9,12},{5,18}});
        minRange(new int[][]{{4,10,15,24,26},{0,9,12,20},{5,18,22,30}});
        minRange(new int[][]{{1, 2, 3, 80}, {1, 2, 3, 90, 200}, {1, 2, 3, 99, 300}});
    }

    public static void minRange(int[][] lists) {
        int[] c = new int[lists.length];
        int min = getMinHead(lists,c);
        int max = getMaxHead(lists,c);
        int rmin = min;
        int rmax = max;
        while (shift(lists, c)) {
            min = getMinHead(lists,c);
            max = getMaxHead(lists,c);
            if (max - min <= rmax - rmin) {
                rmax = max;
                rmin = min;
            }
        }
        System.out.format("%d - %d\n", rmin, rmax);
    }

    private static boolean shift(int[][] lists, int[] c) {
        int min = Integer.MAX_VALUE;
        int mini = -1;
        for (int i = 0; i < c.length; i++) {
            if (c[i] < lists[i].length - 1 && min > lists[i][c[i]]) {
                min = lists[i][c[i]];
                mini = i;
            }
        }
        if (mini == -1) return false;

        c[mini]++;
        return true;
    }

    private static int getMinHead(int[][] lists, int[] c) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < c.length; i++) {
            if (min > lists[i][c[i]]) {
                min = lists[i][c[i]];
            }
        }
        return min;
    }

    private static int getMaxHead(int[][] lists, int[] c) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < c.length; i++) {
            if (max < lists[i][c[i]]) {
                max = lists[i][c[i]];
            }
        }
        return max;
    }
}
