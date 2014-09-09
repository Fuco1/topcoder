import java.util.*;
import java.io.*;

public class MaxSquare {

    public MaxSquare() {}

    public static void main(String[] args) {
        //maxWithTable(loadBoard("square1.in"));
        //max(loadBoard("square2.in"));
        //maxWithTable(loadBoard("square3.in"));
        max(loadBoard("square4.in"));
        //maxWithTable(loadBoard("square4.in"));
    }

    private static boolean[][] loadBoard(String file) {
        String line;
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
            in.close();
        } catch (IOException e) {
        }
        boolean[][] re = new boolean[lines.size()][lines.get(0).length()];
        int i = 0;
        for (String l : lines) {
            int j = 0;
            for (char c : l.toCharArray()) {
                re[i][j++] = c == '#';
            }
            i++;
        }
        return re;
    }

    public static void maxWithTable(boolean[][] data) {
        int[][] right = new int[data.length][data.length];
        int[][] up = new int[data.length][data.length];
        int maxr = 0;
        int maxc = 0;
        for (int i = 0; i < data.length; i++) {
            maxr = 0;
            maxc = 0;
            for (int j = data.length - 1; j >= 0; j--) {
                if (data[i][j]) maxr++;
                else maxr = 0;
                if (data[j][i]) maxc++;
                else maxc = 0;
                right[i][j] = maxr;
                up[j][i] = maxc;
            }
        }

        maxr = 0;
        maxc = 0;
        int max = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data.length; c++) {
                int tmp = Math.min(right[r][c], up[r][c]);
                if (tmp > 0 && right[r+tmp-1][c] >= tmp && up[r][c+tmp-1] >= tmp && tmp > max) {
                    max = tmp;
                    maxr = r;
                    maxc = c;
                }
            }
        }
        System.out.println("r: " + maxr + ", c: " + maxc + ", max: " + max);
    }

    public static void max(boolean[][] data) {
        int maxr = 0;
        int maxc = 0;
        int max = 0;
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data.length; c++) {
                int tmp = maxSquare(data,r,c);
                if (tmp > max) {
                    max = tmp;
                    maxr = r;
                    maxc = c;
                }
            }
        }
        System.out.println("r: " + maxr + ", c: " + maxc + ", max: " + max);
    }

    public static int maxSquare(boolean[][] data, int r, int c) {
        int max = 0;
        for (int i = 0; i < data.length - Math.max(r,c); i++) {
            if (checkSquare(data,r,c,i)) {
                max = i;
            }
        }
        return max;
    }

    public static boolean checkSquare(boolean[][] data, int r, int c, int i) {
        for (int j = 0; j <= i; j++) {
            if (!(data[r][c+j] && data[r+j][c] && data[r+j][c+i] && data[r+i][c+j])) return false;
        }
        return true;
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
}
