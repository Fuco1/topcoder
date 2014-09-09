public class PartitionProblem {

    public PartitionProblem() {}

    public static void main(String[] args) {
        System.out.println(partition(new int[]{3,1,1,2,2,1}));
        System.out.println(partition(new int[]{3,5}));
        System.out.println(partition(new int[]{3,5,8,9,1,2,3,-4,5,-2}));
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
                System.out.print("   " + (table[j][i] ? '✓' : '❌'));
            }
            System.out.println("");
        }
    }

    public static boolean partition(int[] num) {
        int max = num[0];
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            max += Math.abs(num[i]);
            min -= Math.abs(num[i]);
        }
        boolean[][] table = new boolean[num.length][1 + max - min];
        table[0][num[0] - min] = true;
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < 1 + max - min; j++) {
                table[i][j] = ((i > 0 && j - num[i] >= 0 && j - num[i] < 1 + max - min && table[i-1][j - num[i]]) ||
                               (i > 0 && j + num[i] >= 0 && j + num[i] < 1 + max - min && table[i-1][j + num[i]]));
            }
        }
        printTable(table, num, min);
        return table[num.length - 1][-min];
    }
}
