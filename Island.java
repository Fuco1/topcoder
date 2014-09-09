public class Island {

    public Island() {}

    public static void main(String[] args) {
        System.out.println(island(4,4,2,2,0));
        System.out.println(island(4,4,2,2,1));
        System.out.println(island(4,4,2,2,2));
        System.out.println(island(6,4,2,2,2));
        System.out.println(island(6,5,2,2,2));
    }

    public static void printIsland(int[][] island) {
        for (int r = 0; r < island[0].length; r++) {
            for (int c = 0; c < island.length; c++) {
                System.out.format("%4d", island[c][r]);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public static double island(int w, int h, int x, int y, int n) {
        int[][] island = new int[w+2][h+2];
        int[][] next = new int[w+2][h+2];
        for (int c = 0; c < w+2; c++) {
            for (int r = 0; r < h+2; r++) {
                if (!(c == 0 || r == 0 || c == w+1 || r == h+1)) {
                    island[c][r] = 1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int c = 1; c <= w; c++) {
                for (int r = 1; r <= h; r++) {
                    next[c][r] = island[c-1][r] + island[c+1][r] + island[c][r-1] + island[c][r+1];
                }
            }
            int[][] tmp = island;
            island = next;
            next = tmp;
        }
        printIsland(island);
        return island[x+1][y+1] / Math.pow(4,n);
    }
}
