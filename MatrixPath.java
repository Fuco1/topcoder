public class MatrixPath {

    public MatrixPath() {}

    public static void main(String[] args) {
        matrix(new int[][]{{1,5,9},{2,3,8},{4,6,7}});
    }

    public static void matrix(int[][] data) {
        boolean[] counter = new boolean[data.length * data.length];
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                if (r > 0 && data[r-1][c] - data[r][c] == 1) {
                    counter[data[r][c]-1] = true;
                }
                if (r < data.length - 1 && data[r+1][c] - data[r][c] == 1) {
                    counter[data[r][c]-1] = true;
                }
                if (c > 0 && data[r][c-1] - data[r][c] == 1) {
                    counter[data[r][c]-1] = true;
                }
                if (c < data[0].length - 1 && data[r][c+1] - data[r][c] == 1) {
                    counter[data[r][c]-1] = true;
                }
            }
        }
        int max = 0; int maxi = 0; int cur = 0; int[] seq = new int[counter.length];
        int i = 0;
        for (boolean v : counter) {
            if (v) {
                cur++;
                if (cur > max) {
                    max = cur;
                    maxi = i;
                }
            } else {
                cur = 0;
            }
            i++;
        }
        while (counter[maxi-1]) maxi--;
        while (counter[maxi]) {
            System.out.println(maxi+1);
            maxi++;
        }
        System.out.println(maxi+1);
    }
}
