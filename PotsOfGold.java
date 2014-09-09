public class PotsOfGold {

    public PotsOfGold() {}

    public static void main(String[] args) {
        pots(new int[]{6,3,1,4}); // 9:5
        pots(new int[]{12,32,4,23,6,42,16,3,85,23,4,7,3,5,45,34,2,1}); //177:170
        pots(new int[]{1,3,1}); // 2:3
        pots(new int[]{2,3,4,1,1}); // 6:5
        pots(new int[]{2,1,4,1,1}); // 4:5
    }

    public static void pots(int[] pots) {
        int[][] t = new int[pots.length][pots.length];
        boolean[][] p = new boolean[pots.length][pots.length];

        for (int i = 0; i < pots.length; i++) {
            t[i][i] = pots[i];
        }

        for (int i = 1; i < pots.length; i++) {
            for (int j = 0; j < pots.length - i; j++) {
                int k = j + i;
                if (pots[j] - t[j+1][k] > pots[k] - t[j][k-1]) {
                    t[j][k] = pots[j] - t[j+1][k];
                    p[j][k] = true; // = down
                } else {
                    t[j][k] = pots[k] - t[j][k-1];
                }
            }
        }
        printTable(t);
        printTable(p);
        System.out.println(t[0][pots.length-1]);
        // find the sum
        int i = 0;
        int j = pots.length - 1;
        int sum = t[i][j];
        while (i != j) {
            if (p[i][j]) i++; else j--;
            sum += t[i][j];
        }
        System.out.println(sum);
    }

        private static void printTable(int[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                System.out.format("%5d",table[j][i]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private static void printTable(boolean[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                char p = 'd';
                if (!table[j][i]) p = 'l';
                System.out.format("    " + p);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

// public class PotsOfGold {

//     public static void main(String[] args) {
//         int[] goldPots = { 12, 32, 4, 23, 6, 42, 16, 3, 85, 23, 4, 7, 3, 5, 45, 34, 2, 1 };
//         int coins = getMaxGold(goldPots);
//         System.out.println(coins);
//     }

//     private static int getMaxGold(int[] goldPots) {
//         Integer[][]memo=new Integer[goldPots.length][goldPots.length];
//         return getMaxGold(goldPots, 0, goldPots.length - 1,memo);
//     }

//     private static int getMaxGold(int[] goldPots, int startIndex, int endIndex,Integer[][]memo) {
//         if (startIndex > endIndex)
//             return 0;
//         if(memo[startIndex][endIndex]!=null)
//             return memo[startIndex][endIndex];
//         int coinsIfStart = goldPots[startIndex]
//             + Math.min(getMaxGold(goldPots, startIndex + 2, endIndex,memo),
//                        getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
//         int coinsIfEnd = goldPots[endIndex]
//             + Math.min(getMaxGold(goldPots, startIndex, endIndex - 2,memo),
//                        getMaxGold(goldPots, startIndex + 1, endIndex - 1,memo));
//         memo[startIndex][endIndex]=Math.max(coinsIfStart, coinsIfEnd);
//         return memo[startIndex][endIndex];
//     }
// }
