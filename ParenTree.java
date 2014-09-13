import java.util.*;
import java.io.*;

public class ParenTree {

    public ParenTree() {}

    public static void main(String[] args) {
        System.out.println(printPaths(parens(1)));
        System.out.println(printPaths(parens(2)));
        System.out.println(printPaths(parens(3)));
        System.out.println(printPaths(parens(4)));
    }

    public static Node parens(int n) {
        return doParens(n-1, n);
    }

    private static Node doParens(int o, int c) {
        Node h = new Node();
        if (c == 0) return h;
        if (o > 0 && o <= c) {
            h.left = doParens(o-1, c);
        }
        if (c > 0 && o < c) {
            h.right = doParens(o, c-1);
        }
        return h;
    }

    public static List<String> printPaths(Node head) {
        List<String> re = new ArrayList<String>();
        List<String> paths = doPrintPaths(head);
        for (String p : paths) {
            re.add("(" + p);
        }
        return re;
    }

    private static List<String> doPrintPaths(Node head) {
        List<String> re = new ArrayList<String>();
        if (head.left == null && head.right == null) {
            re.add("");
            return re;
        }
        if (head.left != null) {
            List<String> left = doPrintPaths(head.left);
            for (String l : left) {
                re.add("(" + l);
            }
        }
        if (head.right != null) {
            List<String> right = doPrintPaths(head.right);
            for (String r : right) {
                re.add(")" + r);
            }
        }
        return re;
    }
}

class Node {
    Node left;
    Node right;

    Node() {}

    public String toString() {
        return "(N" + (left == null ? "" : left) + (right == null ? "" : right) + ")";
    }
}
