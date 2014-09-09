public class SubsetSumProblem {

    public SubsetSumProblem() {}

    public static void main(String[] args) {
        System.out.println(subsetsum(new int[]{-7, -3, -2, 5, 8}, 0));
        System.out.println(subsetsum(new int[]{3, 34, 4, 12, 5, 2}, 9));
        System.out.println(subsetsum(new int[]{-1, -2}, 9));
        System.out.println(subsetsum(new int[]{3, 4}, -9));
        System.out.println(subsetsum(new int[]{-4, -2, 2}, -1));
        System.out.println(subsetsum(new int[]{3, 4, -10}, -9));
    }

    private static void printTable(boolean[][] table, int[] num, int min) {
        System.out.print("    ");
        for (int i : num) {
            System.out.format("%4d", i);
        }
        System.out.println("");
        for (int i = 0; i < table[0].length; i++) {
            System.out.format("%4d", min++);
            for (int j = 0; j < table.length; j++) {
                System.out.print("   " + (table[j][i] ? 'y' : 'n'));
            }
            System.out.println("");
        }
    }

    public static boolean subsetsum(int[] num, int target) {
        int min = 0;
        int max = 0;
        for (int i : num) {
            if (i < 0) min += i;
            if (i > 0) max += i;
        }
        if (target < min || target > max) return false;
        boolean[][] table = new boolean[num.length][1 + max - min];
        for (int m = 0; m < num.length; m++) {
            for (int n = min; n <= max; n++) {
                table[m][n - min] = ((num[m] == n) ||
                                     (m > 0 && table[m-1][n-min]) ||
                                     (m > 0 && n - num[m] - min >= 0 &&
                                     n - num[m] - min <= max-min) &&
                                     table[m-1][n-num[m]-min]);
            }
        }
        //printTable(table, num, min);
        return table[num.length-1][target - min];
    }
}
