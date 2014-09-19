import java.util.*;
import java.io.*;

public class Queens {

    public Queens() {}

    public static void main(String[] args) {
        queens(1);
        queens(2);
        queens(3);
        queens(4);
        queens(5);
        queens(6);
        queens(7);
        queens(8);
        queens(30);
        queens(50);
    }

    public static void queens(int dim) {
        boolean[][] constraints = new boolean[dim][dim];
        for (boolean[] b : constraints) {
            Arrays.fill(b, true);
        }
        int[] queens = new int[dim];
        Arrays.fill(queens, -1);
        if (!doQueens(queens, constraints, 0)) {
            System.out.println("No solution");
        }
    }

    // classical scheme for a search with propagation:
    // 1. check if there is an unasignable variable, if so, fail
    // 2. check if the puzzle is solved, if so, print answer and quit
    // 3. find the variable with smallest domain
    // 4. for each value in domain
    //    1. set the variable to value
    //    2. propagate the constraints
    //    3. do recursive search
    private static boolean doQueens(int[] queens, boolean[][] constraints, int level) {
        boolean solved = true;
        int dim = queens.length;
        int min = Integer.MAX_VALUE;
        int mini = 0;
        // this loop checks:
        // - if the puzzle is completely solved
        // - which variable has the smallest domain
        // - if there is an empty domain for unset variable
        for (int i = 0; i < dim; i++) {
            if (queens[i] == -1) solved = false;
            int sum = 0;
            for (int j = 0; j < dim; j++) {
                if (constraints[i][j]) sum++;
            }
            if (min > sum && sum > 0) {
                min = sum;
                mini = i;
            }
            // no possible assignment, empty domain
            if (sum == 0 && queens[i] == -1) return false;
        }
        if (solved) {
            printQueens(queens);
            return true;
        }
        for (int i = nextAvail(constraints[mini], 0); i != -1; i = nextAvail(constraints[mini], i+1)) {
            int tmp = queens[mini];
            queens[mini] = i;
            // we clone so that we don't have to bother with unsetting
            // propagated constraints... since the DFS depth is
            // linear, this only uses O(n^3) memory, and our n can
            // only reasonably be < 150
            boolean[][] nconstraints = clone(constraints);
            propagate(mini, i, nconstraints);
            boolean re = doQueens(queens, nconstraints, level+1);
            queens[mini] = tmp;
            if (re) return true;
        }
        return false;
    }

    private static int nextAvail(boolean[] constraints, int i) {
        for (; i < constraints.length; i++) {
            if (constraints[i]) return i;
        }
        return -1;
    }

    private static void propagate(int i, int j, boolean[][] constraints) {
        int dim = constraints.length;
        for (int k = 0; k < dim; k++) {
            constraints[i][k] = false;
            constraints[k][j] = false;
        }
        int len = dim + Math.min(i-j, j-i);
        for (int k = 0; k < len; k++) {
            constraints[Math.max(i-j, 0) + k][Math.max(j-i, 0) + k] = false;
        }
        len = Math.min(i+1+j,2*dim-i-j-1);
        for (int k = 0; k < len; k++) {
            constraints[Math.max(dim-len, 0) + k][Math.min(j+i, dim-1) - k] = false;
        }
    }

    private static boolean[][] clone(boolean[][] o) {
        boolean[][] re = new boolean[o.length][];
        for (int i = 0; i < re.length; i++) {
            re[i] = o[i].clone();
        }
        return re;
    }

    private static void printQueens(int[] queens) {
        for (int j = 0; j < queens.length; j++) {
            for (int i = 0; i < queens.length; i++) {
                System.out.print("+---");
            }
            System.out.println("+");
            int c = queens[j];
            for (int i = 0; i < c; i++) {
                System.out.print("|   ");
            }
            System.out.print("| Q |");
            for (int i = c+1; i < queens.length; i++) {
                System.out.format("   |");
            }
            System.out.println("");
        }
        for (int i = 0; i < queens.length; i++) {
            System.out.print("+---");
        }
        System.out.println("+");
    }

    private static void printTable(boolean[][] table) {
        for (int j = 0; j < table.length; j++) {
            for (int i = 0; i < table[0].length; i++) {
                char p = '1';
                if (!table[j][i]) p = '0';
                System.out.format(" " + p);
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
