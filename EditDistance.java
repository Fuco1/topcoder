import java.util.*;
import java.io.*;

public class EditDistance {

    public EditDistance() {}

    public static void main(String[] args) {
        System.out.println(distance("ab", "ba"));
        System.out.println(distance("steve", "setva"));
        System.out.println(distance("kitten", "sitting"));
    }

    private static List<Operation> operations;
    // pick whatever operations you want here.
    static {
        operations = new ArrayList<Operation>();
        operations.add(new Insert());
        operations.add(new Delete());
        //operations.add(new Match());
        operations.add(new Substitute());
        operations.add(new Transpose());
    }

    public static int distance(String a, String b) {
        return doDistance((" "+a).toCharArray(), (" "+b).toCharArray());
    }

    private static int doDistance(char[] a, char[] b) {
        int[][] t = new int[a.length][b.length];
        for (int i = 0; i < a.length; i++) t[i][0] = i;
        for (int j = 0; j < b.length; j++) t[0][j] = j;
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                int cost = Integer.MAX_VALUE;
                for (Operation op : operations) {
                    int c = op.cost(t,a,b,i,j);
                    cost = Math.min(cost,c);
                }
                t[i][j] = cost;
            }
        }
        printTable(t);
        return t[a.length-1][b.length-1];
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

// this should really be an interface, but I was lazy and put the
// INFINITY constant here so I don't have to duplicate it everywhere
abstract class Operation {
    protected static final int INFINITY = Integer.MAX_VALUE / 2;

    abstract public int cost(int[][] t, char[] a, char[] b, int i, int j);
}

class Insert extends Operation {
    public int cost(int[][] t, char[] a, char[] b, int i, int j) {
        return t[i-1][j] + 1;
    }
}

class Delete extends Operation {
    public int cost(int[][] t, char[] a, char[] b, int i, int j) {
        return t[i][j-1] + 1;
    }
}

class Match extends Operation {
    public int cost(int[][] t, char[] a, char[] b, int i, int j) {
        return t[i-1][j-1] + ((a[i] == b[j]) ? 0 : INFINITY);
    }
}

class Substitute extends Operation {
    public int cost(int[][] t, char[] a, char[] b, int i, int j) {
        return t[i-1][j-1] + ((a[i] == b[j]) ? 0 : 1);
    }
}

class Transpose extends Operation {
    public int cost(int[][] t, char[] a, char[] b, int i, int j) {
        if (a.length < 2 || b.length < 2) return INFINITY;
        return (a[i] == b[j-1] && a[i-1] == b[j]) ? 1 : INFINITY;
    }
}
